package basis.Person_hierarchy.Employees;

import basis.Person_hierarchy.Employee;

import java.time.LocalDate;

public class LuggageStaff extends Employee {
    public LuggageStaff(String name, String lastName, LocalDate dateOfBirth, String registerNr){
        super(name, lastName, dateOfBirth, registerNr);
    }
}
