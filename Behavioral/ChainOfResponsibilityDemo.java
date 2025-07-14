/*
Scenario:
A Bangladeshi university handles student complaints. If the faculty can’t resolve it,
it gets passed to the department. If still unresolved, the admin takes over.
This Chain of Responsibility decouples the sender and handler of requests.
*/

abstract class ComplaintHandler {
    protected ComplaintHandler next;

    public void setNext(ComplaintHandler next) {
        this.next = next;
    }

    abstract void handleComplaint(String complaintType);
}

class FacultyHandler extends ComplaintHandler {
    public void handleComplaint(String complaintType) {
        if (complaintType.equalsIgnoreCase("faculty")) {
            System.out.println("Complaint handled by Faculty.");
        } else if (next != null) {
            next.handleComplaint(complaintType);
        }
    }
}

class DepartmentHandler extends ComplaintHandler {
    public void handleComplaint(String complaintType) {
        if (complaintType.equalsIgnoreCase("department")) {
            System.out.println("Complaint handled by Department.");
        } else if (next != null) {
            next.handleComplaint(complaintType);
        }
    }
}

class AdminHandler extends ComplaintHandler {
    public void handleComplaint(String complaintType) {
        System.out.println("Complaint handled by Admin.");
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        ComplaintHandler faculty = new FacultyHandler();
        ComplaintHandler department = new DepartmentHandler();
        ComplaintHandler admin = new AdminHandler();

        faculty.setNext(department);
        department.setNext(admin);

        faculty.handleComplaint("faculty");
        faculty.handleComplaint("department");
        faculty.handleComplaint("hostel"); // Goes to Admin as fallback
    }
}
