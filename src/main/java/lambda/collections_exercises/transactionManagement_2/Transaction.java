package lambda.collections_exercises.transactionManagement_2;

public class Transaction {

    private String id;
    private State state;
    private int amount;

    public Transaction(String id, State state, int amount) {
        this.id = id;
        this.state = state;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", amount=" + amount +
                '}';
    }
}
