import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> staff = new ArrayList<>();
        Employee first = new Employee("Sam", "Smith", 40, "Retail Sales Representative", new BigDecimal("30.824"));
        Employee second = new Employee("Christopher", "Johnson", 25, "Office Clerk", new BigDecimal("27.617"));
        Employee third = new Employee("Jenifer", "Williams", 18, "Customer Service Representative", new BigDecimal("29.624"));
        Employee fourth = new Employee("Katherine", "Miller", 38, "Accountant", new BigDecimal("52.548"));
        Employee fifth = new Employee("John", "Wilson", 29, "Marketing managers", new BigDecimal("103.440"));
        Employee sixth = new Employee("Jason", "Davis", 60, "CEO", new BigDecimal("413.020"));
        Employee seventh = new Employee("Bruce", "Jackson", 47, "Computer and Information Systems Manager", new BigDecimal("162.930"));
        Employee eighth = new Employee("Gabriel", "Thompson", 21, "Lawyer", new BigDecimal("127.990"));
        Employee ninth = new Employee("Mia", "Robinson", 33, "Software developer", new BigDecimal("93.948"));
        Employee tenth = new Employee("Alisa", "Torres", 42, "Administrative assistant", new BigDecimal("48.092"));
        Employee eleventh = new Employee("Elliott", "Adams", 56, " Mechanic", new BigDecimal("57.110"));

        staff.add(first);
        staff.add(second);
        staff.add(third);
        staff.add(fourth);
        staff.add(fifth);
        staff.add(sixth);
        staff.add(seventh);
        staff.add(eighth);
        staff.add(ninth);
        staff.add(tenth);
        staff.add(eleventh);
    }
}
