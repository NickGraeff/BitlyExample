package hello;

import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, String> {
}
