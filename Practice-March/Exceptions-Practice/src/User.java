public class User {
    public String name;
    public double balance;
    public boolean isActive;

    User(String name, double balance, boolean isActive) {
        this.name = name;
        this.balance = balance;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void deductBalance(double amount) {
        balance-= amount;
    }
}
