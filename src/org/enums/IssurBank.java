package org.enums;

import org.models.bank.ACBABank;
import org.models.bank.AmeriaBank;
import org.models.bank.Bank;
import org.models.bank.HSBCBank;

public enum IssurBank {
    AMERIA{
        @Override
        public Bank getBankInstance() {
            return AmeriaBank.getInstance();
        }
    },
    HSBC{
        @Override
        public Bank getBankInstance() {
            return HSBCBank.getInstance();
        }
    },
    ACBA{
        @Override
        public Bank getBankInstance() {
            return ACBABank.getInstance();
        }
    };

    public abstract Bank getBankInstance();
}
