package com.fsse2502.fsse2502projectbackend.service;

import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;

public interface UserService {
    UserEntity getEntityByEmail(FirebaseUserData firebaseUserData);

    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);
}
