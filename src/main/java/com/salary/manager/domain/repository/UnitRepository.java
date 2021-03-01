package com.salary.manager.domain.repository;

import com.salary.manager.domain.model.UnitModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<UnitModel, String> {

    List<UnitModel> findByName(final String name);
}
