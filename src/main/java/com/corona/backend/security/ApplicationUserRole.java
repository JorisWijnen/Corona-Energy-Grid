package com.corona.backend.security;

import com.corona.backend.models.CustomGrantedAuthority;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.corona.backend.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    // ADD all the user roles you want, and bind them to the permissions you defined.
    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<CustomGrantedAuthority> getGrantedAuthorities(){
        Set<CustomGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new CustomGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new CustomGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
