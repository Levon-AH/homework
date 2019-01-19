package org.BankSystem;

import org.Exceptions.GreatorAmountException;
import org.Exceptions.InvalidAccountException;
import org.models.Account;
import org.models.Card;
import org.models.bank.Bank;

import java.util.Map;
import java.util.Set;

public class BankManagerImpl implements BankManager {

    @Override
    public boolean checkValidAccount(Card card, Bank bank) throws InvalidAccountException {
        boolean result = false;
        if(!bank.getStore().containsKey(card.getFullName())){
            throw new InvalidAccountException("invalid account");
        } else {
            for (Account current: bank.getStore().get(card.getFullName())){
                if (card.getNumber() == current.getCardNumber())
                    result = true;
            }
        }
        return result;
    }

    @Override
    public boolean checkAccountBalance(Card card, Bank bank, long amount) throws InvalidAccountException, GreatorAmountException {
        if (!checkValidAccount(card, bank)){
            throw new InvalidAccountException("invalid account");
        }
        Account account = null;
        for (Account current: bank.getStore().get(card.getFullName())){
            if (current.getCardNumber().compareTo(card.getNumber()) == 0){
                account = current;
            }
        }

        if (account != null){
            return amount <= account.getAmount();
        }
        else throw new GreatorAmountException("you  can't get money for this amount => " + amount);
    }

    @Override
    public void getMoney(Card card, Bank bank, long amount) throws GreatorAmountException, InvalidAccountException {
        if (!checkAccountBalance(card, bank, amount)){
            throw new GreatorAmountException("you  can't get money for this amount => " + amount);
        }
        Map<String, Set<Account>> store = bank.getStore();
        Account account = null;
        for (Account current: store.get(card.getFullName())){
            if (current.getCardNumber().compareTo(card.getNumber()) == 0){
                account = current;
            }
        }
        account.setAmount(account.getAmount() - amount);
    }

    @Override
    public Account getAccount(Card card, Bank bank) {
        Map<String, Set<Account>> store = bank.getStore();
        Account account = null;
        for (Account current: store.get(card.getFullName())){
            if (current.getCardNumber().compareTo(card.getNumber()) == 0){
                account = current;
            }
        }
        return account;
    }

}
