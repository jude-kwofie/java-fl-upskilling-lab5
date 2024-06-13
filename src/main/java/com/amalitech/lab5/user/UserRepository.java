package com.amalitech.lab5.user;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends ListCrudRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String email);

}
