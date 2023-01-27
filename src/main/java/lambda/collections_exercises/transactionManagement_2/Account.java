package lambda.collections_exercises.transactionManagement_2;

import java.util.List;

public class Account {

    private int balance;
    private String accountNo;
    private List<Transaction> transactions;

    public Account(int balance, String accountNo, List<Transaction> transactions) {
        this.balance = balance;
        this.accountNo = accountNo;
        this.transactions = transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNo='" + accountNo + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
