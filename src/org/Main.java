package org;

import org.ATMSystem.ATM;
import org.Parser.ParseXML;
import org.models.Card;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Card> list = ParseXML.initBanks();
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        String input;
        System.out.println("============ For exit enter '$' =============");
        do{
            long amount = new Random().nextInt(100000);
            int randomCardIndex = new Random().nextInt(list.size());
            Card randomCard = list.get(randomCardIndex);
            System.out.println(randomCard.getIssurBank().getBankInstance());
            atm.withDraw(amount, randomCard);
            input = scanner.next();
        } while (!input.equals("$"));

    }
}
