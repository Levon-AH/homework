package org.ATMSystem;

import org.Exceptions.ATMBalanceException;

public class ATMManagerImpl implements ATMManager {
    @Override
    public boolean checkMoney(ATM atm, long amount){
        return amount <= atm.getBalance();
    }

    @Override
    public void reduceBalance(ATM atm, long amount) throws ATMBalanceException {
        if (!checkMoney(atm, amount))
            throw new ATMBalanceException("no money for reduce");
        atm.setBalance(atm.getBalance() - amount);
    }
}
