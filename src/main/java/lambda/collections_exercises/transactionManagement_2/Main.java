package lambda.collections_exercises.transactionManagement_2;

import stream.helperClasses.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("6542", State.PROCESSING, 3500);
        Transaction transaction2 = new Transaction("3652", State.FINISHED, 35);
        Transaction transaction3 = new Transaction("1245", State.FINISHED, 150);
        Transaction transaction4 = new Transaction("9875", State.PROCESSING, 450);
        Transaction transaction5 = new Transaction("2565", State.CANCELED, 300);
        Transaction transaction6 = new Transaction("3254", State.CANCELED, 200);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);

        Account account1 = new Account(9000, "RO221 252 326", transactions);
        Account account2 = new Account(80, "RO299 321 523", transactions);
        Account account3 = new Account(650, "RO854 455 856", transactions);
        Account account4 = new Account(7500, "RO112 326 444", transactions);
        Account account5 = new Account(20, "RO120 000 215", transactions);
        Account account6 = new Account(20, "RO985 000 288", transactions);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);

//Avand intr-un main o lista de conturi, care au fiecare lista lor de tranzactii, scrie o metoda care sa returneze suma tranzactiilor
// cu starea CANCELED din conturile care au soldul mai mare decat 0.
//(HINT: stream pe lista de conturi si filter pentru a filtra conturile cu balanta mai mare decat 0, apoi flatMap pentru a ajunge la
// tranzactiile conturilor si filter pentru a filtra tranzactiile CANCELED)

//sum of transactions with canceled 0
        Integer sumOfTransactionsWithCanceledState = accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                //.map(transaction -> transaction.getAmount())
                //.reduce((sum, amount) -> sum + amount);
                .collect(Collectors.summingInt(transaction -> transaction.getAmount()));
        //System.out.println(sumOfTransactionsWithCanceledState.orElse(0));
        System.out.println(sumOfTransactionsWithCanceledState);

        System.out.println(getSumOfTransactionsWithCanceledState(accounts));
    }

    public static Integer getSumOfTransactionsWithCanceledState(List<Account> accounts) {
        int sum = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                for (Transaction transaction : account.getTransactions()) {
                    if (transaction.getState() == State.CANCELED) {
                        sum += transaction.getAmount();
                    }
                }
            }
        }
        return sum;
    }

}
