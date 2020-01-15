package hello;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class ThingFormToThing implements Converter<ThingForm, Thing> {
    @Override
    public Thing convert(ThingForm thingForm) {
        Thing thing = new Thing();
        if (thingForm.getId() != null && !StringUtils.isEmpty(thingForm.getId())) {
            thing.setId(thingForm.getId());
        }
        thing.setDescription(thingForm.getDescription());
        thing.setVal(thingForm.getVal());
        return thing;
    }
}
