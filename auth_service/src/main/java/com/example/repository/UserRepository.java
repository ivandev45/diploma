package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ivan on 09.06.18.
 */
public interface UserRepository extends CrudRepository<UserEntity, String> {
    UserEntity findUserEntityByUserId(String userId);
}
