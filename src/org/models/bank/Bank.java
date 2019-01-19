package org.models.bank;

import org.models.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Bank {
    protected Map<String, Set<Account>> store;

    public Bank(Map<String, Set<Account>> store) {
        this.store = store;
    }

    public Bank(){

    }

    public Map<String, Set<Account>> getStore() {
        return store;
    }

    public void setStore(Map<String, Set<Account>> store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Bank => {" +
                "store = " + store +
                '}';
    }
}
