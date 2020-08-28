package org.duh102.unibot.model.permissions;

import org.duh102.unibot.model.exception.UniqueViolationException;

import java.util.HashMap;
import java.util.Map;

public class CustomPermission {
    private static final Map<String, CustomPermission> CUSTOM_PERMISSION_MAP = new HashMap<>();

    public static CustomPermission getPermission(String name) {
        synchronized (CUSTOM_PERMISSION_MAP) {
            return CUSTOM_PERMISSION_MAP.getOrDefault(name, null);
        }
    }

    public String getPermissionName() {
        return permissionName;
    }

    private String permissionName;

    public CustomPermission(String permissionName) throws UniqueViolationException {
        this.permissionName = permissionName;
        boolean succeeded = false;
        synchronized (CUSTOM_PERMISSION_MAP) {
            if(!CUSTOM_PERMISSION_MAP.containsKey(permissionName)) {
                CUSTOM_PERMISSION_MAP.put(permissionName, this);
                succeeded = true;
            }
        }
        if(!succeeded) {
            throw new UniqueViolationException(String.format("Already have custom permission named %s", permissionName));
        }
    }
}
