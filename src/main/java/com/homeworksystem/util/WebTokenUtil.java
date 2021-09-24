package com.homeworksystem.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class WebTokenUtil {
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    private static final String privateKey = "NCUCSHOMEWORKSYSTEM";

    /**
     * 加密token.
     */
    public static String getToken(String userId, String userRole) {

        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        Map<String, Object> header = new HashMap<>(2);
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        String token = JWT
                .create()
                .withHeader(header)
                .withClaim("userId" ,userId)
                .withClaim("userRole", userRole)
                .withExpiresAt(date)
                .withClaim("timeStamp", System.currentTimeMillis())
                .sign(algorithm);

        return token;
    }

    public Map<String, String> parseToken(String token) {
        HashMap<String, String> map = new HashMap<>();
        DecodedJWT decodedjwt = JWT.require(Algorithm.HMAC256(privateKey))
                .build().verify(token);
        Claim userId = decodedjwt.getClaim("userId");
        Claim userRole = decodedjwt.getClaim("userRole");
        Claim timeStamp = decodedjwt.getClaim("timeStamp");
        map.put("userId", userId.asString());
        map.put("userRole", userRole.asString());
        map.put("timeStamp", timeStamp.asLong().toString());
        return map;
    }
}