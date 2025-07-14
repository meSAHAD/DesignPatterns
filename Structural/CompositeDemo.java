/*
Scenario:
A Bangladeshi university directory contains faculties, departments, and students.
Composite pattern treats individual students and groups (departments) uniformly.
Enables recursive tree-like structures and operations.
*/

import java.util.ArrayList;
import java.util.List;

interface UniversityUnit {
    void showDetails();
}

class Student implements UniversityUnit {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Student: " + name);
    }
}

class Department implements UniversityUnit {
    private String name;
    private List<UniversityUnit> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(UniversityUnit unit) {
        members.add(unit);
    }

    public void showDetails() {
        System.out.println("Department: " + name);
        for (UniversityUnit unit : members) {
            unit.showDetails();
        }
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        Department cse = new Department("CSE");
        cse.add(new Student("Sahad"));
        cse.add(new Student("Rafi"));

        Department eee = new Department("EEE");
        eee.add(new Student("Nusrat"));

        Department faculty = new Department("Engineering Faculty");
        faculty.add(cse);
        faculty.add(eee);

        faculty.showDetails();
    }
}
