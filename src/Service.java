import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Service {
    private Connection connection;
    private Statement statement;
    private final String insertStatement = "insert into employees (name, lastname, age, position, salary) value (?, ?, ?, ?, ?);";
    private PreparedStatement ps;


    public void main(String[] args) {

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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect();
            create();
            insert();
            update();
            read();
            notReallyCorrectInsert("Alisa", "Torres", 42, "Administrative assistant", new BigDecimal("48.092"));
            notReallyCorrectInsert("Jason", "Davis", 60, "CEO", new BigDecimal("413.020"));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:database/employee.db");
    }

    private void create() throws SQLException {
        statement = connection.createStatement();
        statement.execute("create table if not exists employees (id integer primary key autoincrement, name text, lastname text, age integer, position text, salary bigDecimal);");
        ps = connection.prepareStatement(insertStatement);
    }

    private void insert() throws SQLException {
        int insertedrows = statement.executeUpdate("insert into employees (name, lastname, age, position, salary) values (first.get.Name, first.get.LastName, first.getAge, first.getPosition, first.getSalary().doubleValue()), (second.get.Name, second.get.LastName, second.getAge, second.getPosition, second.getSalary().doubleValue();");
        System.out.println(insertedrows);
    }

    private void update() throws SQLException {
        statement.executeUpdate("update employees set name = 'Ivan Pupkovich' where get.Age > 30");
    }

    private void delete() throws SQLException {
        statement.executeUpdate("delete from employees where id = 1 or name like '%Morz%' or getSalary.doubleValue(10) > 0;");
    }

    private void read() throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("select name, age from employees;")) {
            while (resultSet.next()) {
                System.out.printf("Employees: %s age %s\n",
                        resultSet.getString(1),
                        resultSet.getInt("age"));
            }
        }
    }

    private void notReallyCorrectInsert(String name, String lastname, int age, String position, BigDecimal salary) throws SQLException {
        statement.executeUpdate("insert into students (name, lastname, age, position, salary) values ('" + name + "', '\" + lastname + \"', " + age + ", '\" + position + \"', \" + salary + \");");
    }


    private void preparedInsert(String name, String lastname, int age, String position, BigDecimal salary) throws SQLException {
        ps.setString(1, name);
        ps.setString(2, lastname);
        ps.setInt(3, age);
        ps.setString(4, position);
        ps.setBigDecimal(5, salary);
        ps.executeUpdate();
    }
}
