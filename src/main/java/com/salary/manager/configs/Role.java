package com.salary.manager.configs;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER;

    public static Role findRoleByRoleName(final String roleName) {
        if (roleName.equalsIgnoreCase(ADMIN.name())) {
            return ADMIN;
        } else {
            return USER;
        }
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
