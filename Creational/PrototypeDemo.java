/*
Scenario:
A Bangladeshi publishing house clones book templates to quickly create new editions.
Prototype pattern allows cloning existing book objects instead of creating from scratch.
This boosts efficiency when many similar objects are needed.
*/

class Book implements Cloneable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }

    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Book original = new Book("Learn Java", "Sahad");
        Book copy = original.clone();

        original.display();
        copy.display();

        System.out.println("original == copy? " + (original == copy));
    }
}
