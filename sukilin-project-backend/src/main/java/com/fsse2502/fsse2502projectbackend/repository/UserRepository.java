package com.fsse2502.fsse2502projectbackend.repository;

import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByFirebaseUid(String firebaseUid);
}
