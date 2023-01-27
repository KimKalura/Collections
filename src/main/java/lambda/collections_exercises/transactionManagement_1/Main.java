package lambda.collections_exercises.transactionManagement_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //6. Gestiunea tranzactiilor.
        // O tranzactie este caracterizata de id, amount si de contul din care s-a facut tranzactia.(HINT: atribute: id, sum, account - care este de tip Account)
        // Un cont este caracterizat de balance (sold) si un account number (numar de cont).(HINT - aceasta este clasa Account).
        //Avand o lista de tranzactii intr-un main, scrie o metoda care primeste aceasta lista de tranzactii si genereaza o mapa in care cheia sa fie numarul de cont,
        // iar valoarea sa fie suma amount-urilor tututor tranzactiilor care au avut loc din acel cont.(HINT) - Collectors.summingLong.

        Account account1 = new Account(8000, "RO145 521 362");
        Account account2 = new Account(350, "RO352 215 256");
        Account account3 = new Account(90350, "RO783 012 236");
        Account account4 = new Account(500, "RO321 456 785");

        Transaction transaction1 = new Transaction("6592", 3500, account1);
        Transaction transaction2 = new Transaction("4521", 200, account2);
        Transaction transaction3 = new Transaction("3574", 500, account3);
        Transaction transaction4 = new Transaction("9632", 250, account4);

        List<Transaction> transactionsList = new ArrayList<>();
        transactionsList.add(transaction1);
        transactionsList.add(transaction2);
        transactionsList.add(transaction3);
        transactionsList.add(transaction4);


        //"RO145 521 362" = 3500   accountNo= sum amount
        Map<String, Long> sumOfTransactionsBynAccount = transactionsList.stream()
                //.filter(account->account.getAmount())
                //.map(transaction -> transaction.getAmount())
                .collect(Collectors.groupingBy(transaction -> transaction.getAccount().getAccountNumber(), Collectors.summingLong(transaction -> transaction.getAmount())));
        System.out.println(sumOfTransactionsBynAccount);


        System.out.println(getSumOfTransactionsByAccount(transactionsList));

    }

    public static Map<String, Integer> getSumOfTransactionsByAccount(List<Transaction> transactions) {
        Map<String, Integer> sumOfTransactionsByAccountNo = new HashMap<>();
        for (Transaction transaction : transactions) {
            String key = transaction.getAccount().getAccountNumber();
            if (!sumOfTransactionsByAccountNo.containsKey(key)) { //daca mapa nu contine cheia (contul tranzactiei), atunci...
                sumOfTransactionsByAccountNo.put(key, transaction.getAmount());//...punem la nr de cont al tranzactiei(,) punem ca s-a facut un anumit Amount(adica Amount-ul tranzactiei)
            } else {
                sumOfTransactionsByAccountNo.put(key, sumOfTransactionsByAccountNo.get(key) + transaction.getAmount());
            }
        }
        return sumOfTransactionsByAccountNo;
    }
    //din else:  sumOfTransactionsByAccountNo.get(key)->reprez ce era inainte + cu ce am acum (+ transaction.getAmount())
    //+ transaction.getAmount() vreau sa il adun la ce era inainte in Mapa adica, sumOfTransactionsByAccountNo.get(key)
}

