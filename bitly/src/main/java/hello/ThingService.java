package hello;

public interface ThingService {
    Thing saveThing(Thing thing);
    Thing loadThing(String id);
}
