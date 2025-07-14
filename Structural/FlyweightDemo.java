/*
Scenario:
A Bangla text editor stores thousands of repeated characters like ‘অ’.
Flyweight pattern shares common character objects to save memory.
This optimizes resource usage in large-scale text editing.
*/

import java.util.HashMap;
import java.util.Map;

interface BanglaCharacter {
    void print();
}

class ConcreteCharacter implements BanglaCharacter {
    private char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    public void print() {
        System.out.print(symbol + " ");
    }
}

class CharacterFactory {
    private static Map<Character, BanglaCharacter> pool = new HashMap<>();

    public static BanglaCharacter getCharacter(char symbol) {
        if (!pool.containsKey(symbol)) {
            pool.put(symbol, new ConcreteCharacter(symbol));
        }
        return pool.get(symbol);
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        String name = "অন্তর";

        for (char c : name.toCharArray()) {
            BanglaCharacter character = CharacterFactory.getCharacter(c);
            character.print();
        }
        System.out.println();
    }
}
