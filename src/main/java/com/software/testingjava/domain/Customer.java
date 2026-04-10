package com.software.testingjava.domain;

import java.util.Objects;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final boolean premiumMember;

    public Customer(String id, String name, String email, boolean premiumMember) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.premiumMember = premiumMember;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }
}
