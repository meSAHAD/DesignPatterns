/*
Scenario:
Bangladeshi ATM behaves differently when card is inserted or not.
State pattern lets ATM change its behavior dynamically based on its state.
*/

interface ATMState {
    void handle();
}

class NoCardState implements ATMState {
    public void handle() {
        System.out.println("Please insert your card.");
    }
}

class HasCardState implements ATMState {
    public void handle() {
        System.out.println("Please enter your PIN.");
    }
}

class ATM {
    private ATMState currentState;

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle();
    }
}

public class StateDemo {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.setState(new NoCardState());
        atm.request();

        atm.setState(new HasCardState());
        atm.request();
    }
}
