package com.example.lab5.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.example.lab5.model.User;


public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken{

    private final UserPrincipal principal;
    public UserPrincipalAuthenticationToken(UserPrincipal principal){
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
    
}
