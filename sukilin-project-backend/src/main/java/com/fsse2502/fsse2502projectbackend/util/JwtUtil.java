package com.fsse2502.fsse2502projectbackend.util;

import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {
    public static FirebaseUserData toFirebaseUserData(JwtAuthenticationToken token) {
        return new FirebaseUserData(token);
    }

    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwt) {
        return null;
    }
}
