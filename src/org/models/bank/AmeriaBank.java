package org.models.bank;

import java.util.HashMap;

public class AmeriaBank extends Bank {
    private static AmeriaBank instance;

    private AmeriaBank(){
        store = new HashMap<>();
    }

    public static AmeriaBank getInstance(){
        if (instance == null){
            instance = new AmeriaBank();
        }
        return instance;
    }
}
