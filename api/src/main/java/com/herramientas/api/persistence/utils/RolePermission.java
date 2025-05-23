package com.herramientas.api.persistence.utils;

public enum RolePermission {
    // Admin
    READ_ALL_USERS,
    CREATE_USER,
    UPDATE_USER,
    DELETE_USER,
    MANAGE_TOOLS,
    MANAGE_CATEGORIES,
    VIEW_REPORTS,
    MANAGE_PAYMENTS,

    // Proveedor
    MANAGE_OWN_TOOLS,
    ACCEPT_REJECT_BOOKINGS,
    CONFIRM_RETURN,
    GENERATE_INVOICES,
    RECEIVE_NOTIFICATIONS,

    // Cliente
    SEARCH_TOOLS,
    BOOK_TOOL,
    PAYMENT_PROCESS,
    VIEW_HISTORY
}