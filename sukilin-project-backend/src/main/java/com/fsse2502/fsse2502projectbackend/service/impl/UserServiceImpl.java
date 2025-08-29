package com.fsse2502.fsse2502projectbackend.service.impl;

import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import com.fsse2502.fsse2502projectbackend.repository.UserRepository;
import com.fsse2502.fsse2502projectbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByEmail(FirebaseUserData firebaseUserData) {
//        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(firebaseUserData.getEmail());
//
//        if (optionalUserEntity.isPresent()) {
//            return optionalUserEntity.get();
//        }
//
//        UserEntity userEntity = new UserEntity(firebaseUserData)
//        return userRepository.save(userEntity);

        return userRepository.findByEmail(firebaseUserData.getEmail()).orElseGet(
                () -> userRepository.save(new UserEntity(firebaseUserData))
        );
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData){
        Optional<UserEntity> userEntityOptional = userRepository.findByFirebaseUid(firebaseUserData.getFirebaseUid());

        if (userEntityOptional.isPresent()){
            return userEntityOptional.get();
        }

        UserEntity userEntity = userRepository.save(new UserEntity(firebaseUserData));
        return userEntity;
    };
}
