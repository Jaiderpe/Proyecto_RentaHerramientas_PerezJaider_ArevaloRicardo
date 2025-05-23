package com.herramientas.api.persistence.utils;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ROLE_ADMINISTRATOR(Arrays.asList(
        RolePermission.READ_ALL_USERS,
        RolePermission.CREATE_USER,
        RolePermission.UPDATE_USER,
        RolePermission.DELETE_USER,
        RolePermission.MANAGE_TOOLS,
        RolePermission.MANAGE_CATEGORIES,
        RolePermission.VIEW_REPORTS,
        RolePermission.MANAGE_PAYMENTS
    )),
    ROLE_PROVIDER(Arrays.asList(
        RolePermission.MANAGE_OWN_TOOLS,
        RolePermission.ACCEPT_REJECT_BOOKINGS,
        RolePermission.CONFIRM_RETURN,
        RolePermission.GENERATE_INVOICES,
        RolePermission.RECEIVE_NOTIFICATIONS
    )),
    ROLE_CUSTOMER(Arrays.asList(
        RolePermission.SEARCH_TOOLS,
        RolePermission.BOOK_TOOL,
        RolePermission.PAYMENT_PROCESS,
        RolePermission.VIEW_HISTORY
    ));

    private List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }
}