package com.corona.backend.security.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {

    private final String password;
    private final String username;
    private final boolean isAccountNonExpired;
    private final boolean isEnabled;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final Set<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser(String password, String username, boolean isAccountNonExpired, boolean isEnabled, boolean isAccountNonLocked, boolean isCredentialsNonExpired, Set<? extends GrantedAuthority> grantedAuthorities) {
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isEnabled = isEnabled;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.grantedAuthorities = grantedAuthorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
