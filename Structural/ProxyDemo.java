/*
Scenario:
Bangladesh government citizen database restricts direct access.
Proxy controls access by checking authorization before forwarding requests.
This adds security layer without modifying real database access code.
*/

interface Database {
    void access();
}

class RealDatabase implements Database {
    public void access() {
        System.out.println("Accessing secure citizen database...");
    }
}

class DatabaseProxy implements Database {
    private RealDatabase realDatabase = new RealDatabase();
    private boolean authorized;

    public DatabaseProxy(boolean authorized) {
        this.authorized = authorized;
    }

    public void access() {
        if (authorized) {
            realDatabase.access();
        } else {
            System.out.println("Access denied: Unauthorized user.");
        }
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Database unauthorizedAccess = new DatabaseProxy(false);
        unauthorizedAccess.access();

        Database authorizedAccess = new DatabaseProxy(true);
        authorizedAccess.access();
    }
}
