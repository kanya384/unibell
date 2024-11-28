package com.unibell.clients.entity;

import com.unibell.clients.exception.BadArgumentException;

public enum ContactType {
    EMAIL,
    PHONE;

    public static ContactType fromString(String str) {
        try {
            return ContactType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadArgumentException(String.format("No such Contact Type: %s", str));
        }
    }
}
