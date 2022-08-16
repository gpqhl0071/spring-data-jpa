package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

  @Modifying
  @Query("update User u set u.firstName = ?1 where u.id = ?2")
  @Transactional
  int setFirstNameByID(String firstname, long id);

  List<User> findByFirstName(String firstName);

  User findTopByOrderByIdDesc();
}
