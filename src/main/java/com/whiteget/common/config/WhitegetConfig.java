package com.whiteget.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "whiteget")
public class WhitegetConfig {

    private String projectName;

    private String projectRootUrl;

    private Boolean demoMode;

    private Boolean devMode;

    private JWTConfig jwt;
}
