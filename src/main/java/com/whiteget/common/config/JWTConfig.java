package com.whiteget.common.config;

import lombok.Data;

@Data
public class JWTConfig {

    private String userId;

    private Long expireTime = 7200000L;

    private Long refreshTokenExpire = 604800000L;
}
