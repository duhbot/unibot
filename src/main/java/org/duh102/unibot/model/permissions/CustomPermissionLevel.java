package org.duh102.unibot.model.permissions;

public class CustomPermissionLevel {

    private CustomPermission permission;
    private Long level;

    public CustomPermissionLevel(CustomPermission permission, Long level) {
        this.permission = permission;
        this.level = level;
    }
    public CustomPermission getPermission() {
        return permission;
    }

    public Long getLevel() {
        return level;
    }
}
