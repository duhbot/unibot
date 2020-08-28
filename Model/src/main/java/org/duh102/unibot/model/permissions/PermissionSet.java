package org.duh102.unibot.model.permissions;

import java.util.*;
import java.util.stream.Collectors;

public class PermissionSet {
    private Set<ServicePermissions> basicPermissions;
    private Map<CustomPermission, Long> customPermissions;

    public PermissionSet() {
        basicPermissions = new HashSet<>();
        customPermissions = new HashMap<>();
    }

    public PermissionSet(List<ServicePermissions> basicPermissions, List<CustomPermissionLevel> customPermissions) {
        this.basicPermissions = new HashSet<>(basicPermissions);
        this.customPermissions = customPermissions.stream().collect(Collectors.toMap(CustomPermissionLevel::getPermission, CustomPermissionLevel::getLevel));
    }

    public boolean satisfies(List<ServicePermissions> basicPermissions, List<CustomPermissionLevel> customPermissions) {
        return this.basicPermissions.containsAll(basicPermissions) && customPermissionsMeetOrExceed(customPermissions);
    }

    private boolean customPermissionsMeetOrExceed(List<CustomPermissionLevel> checkPermissions) {
        for(CustomPermissionLevel customLevel : checkPermissions) {
            CustomPermission checkPermission = customLevel.getPermission();
            if(!this.customPermissions.containsKey(checkPermission)) {
                return false;
            }
            long requiredLevel = customLevel.getLevel();
            if(this.customPermissions.get(checkPermission) < requiredLevel) {
                return false;
            }
        }
        return true;
    }
}
