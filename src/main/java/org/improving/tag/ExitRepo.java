package org.improving.tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExitRepo extends CrudRepository {
    Exit findByName(String name);

    List<Exit> findAllByName();
}
