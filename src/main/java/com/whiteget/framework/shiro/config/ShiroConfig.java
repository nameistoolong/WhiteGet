package com.whiteget.framework.shiro.config;

import com.whiteget.framework.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    @Value("${shiro.user.successUrl}")
    private String successUrl;

    @Value("${shiro.user.unauthorizedUrl}")
    private String unauthUrl;

    @Bean
    public UserRealm getRealm(){
        return new UserRealm();
    }

    @Bean
    public SecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean setShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthUrl);
        LinkedHashMap<String, String> filterChainDefinition = new LinkedHashMap<>();
        filterChainDefinition.put("/static/**", "anon");
        filterChainDefinition.put("/logout", "logout");
        filterChainDefinition.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinition);
        return shiroFilterFactoryBean;
    }
}
