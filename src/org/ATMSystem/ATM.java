package org.ATMSystem;

import org.BankSystem.BankManager;
import org.BankSystem.BankManagerImpl;
import org.Exceptions.ATMBalanceException;
import org.Exceptions.GreatorAmountException;
import org.Exceptions.InvalidAccountException;
import org.models.Account;
import org.models.Card;

import java.util.Random;
import java.util.logging.Logger;

public class ATM {
    private Logger logger = Logger.getLogger("ATM Logger");
    private long balance;
    private BankManager bankManager;
    private ATMManager atmManager;

    public ATM(){
        balance = new Random().nextInt(1000000);
        bankManager = new BankManagerImpl();
        atmManager = new ATMManagerImpl();
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void withDraw(long amount, Card card){
        Account account = bankManager.getAccount(card, card.getIssurBank().getBankInstance());
        logger.info("Your request are preparing on this card... " + card);

        try {
            logger.info("Your request are success on your account " + account + " ====== " +  "and reduce amount " + amount);
            bankManager.getMoney(card, card.getIssurBank().getBankInstance(), amount);
            logger.info("After your card " + account);
            logger.info("YOUR REQUEST ARE SUCCESS ON THIS ATM... " + this);
            atmManager.reduceBalance(this, amount);
            logger.info("after reducing ATM " + this );
        } catch (GreatorAmountException e) {
            logger.warning(e + " Error on get money on this bank and amount ------> " + amount + "\t" + account);
        }catch (ATMBalanceException e){
            logger.warning(e + " Error on get money on this ATM and amount ------> " + amount + "\t" + this);
        }catch (InvalidAccountException e){
            logger.warning(e + " Error invalid account");
        } catch (Exception e) {
            System.out.println(e + " Exception");
        }
    }

    @Override
    public String toString() {
        return "ATM => {" +
                "balance = " + balance +
                '}';
    }
}
