/*
Scenario:
A Bangladeshi bank has a single ATM system instance to manage transactions.
Singleton ensures only one instance of the ATM system exists application-wide.
This controls shared resource access and saves memory.
*/

class ATMSystem {
    private static ATMSystem instance;

    private ATMSystem() {
        System.out.println("ATM System Initialized.");
    }

    public static ATMSystem getInstance() {
        if (instance == null) {
            instance = new ATMSystem();
        }
        return instance;
    }

    public void withdraw(int amount) {
        System.out.println("Withdrawing Tk " + amount);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        ATMSystem atm1 = ATMSystem.getInstance();
        atm1.withdraw(1000);

        ATMSystem atm2 = ATMSystem.getInstance();
        atm2.withdraw(500);

        System.out.println("atm1 and atm2 are the same instance? " + (atm1 == atm2));
    }
}
