/*
Scenario:
A Bangladeshi chatbot interprets simple commands: "ON", "OFF".
Interpreter pattern parses and executes these commands dynamically.
*/

interface Expression {
    void interpret(String context);
}

class OnExpression implements Expression {
    public void interpret(String context) {
        if (context.equalsIgnoreCase("on")) {
            System.out.println("Device turned ON.");
        }
    }
}

class OffExpression implements Expression {
    public void interpret(String context) {
        if (context.equalsIgnoreCase("off")) {
            System.out.println("Device turned OFF.");
        }
    }
}

public class InterpreterDemo {
    public static void main(String[] args) {
        Expression on = new OnExpression();
        Expression off = new OffExpression();

        on.interpret("on");
        off.interpret("off");
    }
}
