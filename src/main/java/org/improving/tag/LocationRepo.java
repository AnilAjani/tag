package org.improving.tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends CrudRepository<Location, Long> {
    Location findByName(String name);

    List<Location> findAllByName();
}
