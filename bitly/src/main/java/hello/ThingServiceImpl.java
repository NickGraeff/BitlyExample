package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThingServiceImpl implements ThingService {

    private ThingRepository thingRepository;
    private ThingFormToThing thingFormToThing;

    @Autowired
    public ThingServiceImpl(ThingRepository thingRepository, ThingFormToThing thingFormToThing) {
        this.thingRepository = thingRepository;
        this.thingFormToThing = thingFormToThing;
    }

    @Override
    public Thing saveThing(Thing thing) {
        thingRepository.save(thing);
        return thing;
    }

    @Override
    public Thing loadThing(String id) {
        return thingRepository.findById(id).orElse(null);
    }
}
