package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication
@RestController
public class Application {

    private ThingService thingService;
    private ThingToThingForm thingToThingForm;
    private ThingFormToThing thingFormToThing;

    @Autowired
    public void setThingService(ThingService thingService) {
        this.thingService = thingService;
    }

    @Autowired
    public void setThingToThingForm(ThingToThingForm thingToThingForm) {
        this.thingToThingForm = thingToThingForm;
    }

    @Autowired
    public void setThingFormToThing(ThingFormToThing thingFormToThing) {
        this.thingFormToThing = thingFormToThing;
    }

    @GetMapping("/time")
    public String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    }

    @GetMapping("/thing/{id}")
    public String getThing(@PathVariable String id) {
        Thing thing = thingService.loadThing(id);
        return thing.getId() + ", " + thing.getDescription() + ", " + thing.getVal();
    }

    @PostMapping("/thing/{id}")
    public void setThing(ThingForm thingForm, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
            thingService.saveThing(thingFormToThing.convert(thingForm));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
