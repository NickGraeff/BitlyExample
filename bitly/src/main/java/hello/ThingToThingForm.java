package hello;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class ThingToThingForm implements Converter<Thing, ThingForm> {
    @Override
    public ThingForm convert(Thing thing) {
        ThingForm thingForm = new ThingForm();
        if (thing.getId() != null && !StringUtils.isEmpty(thing.getId())) {
            thingForm.setId(thing.getId());
        }
        thingForm.setDescription(thing.getDescription());
        thingForm.setVal(thing.getVal());
        return thingForm;
    }
}
