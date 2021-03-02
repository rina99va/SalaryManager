package com.salary.manager.domain.repository;

import com.salary.manager.domain.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    List<UserModel> findByName(final String name);
}
