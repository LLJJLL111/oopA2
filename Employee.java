public class Employee extends Person {
    private String employeeId;
    private String department;
    private double salary;

    // Default constructor
    public Employee() {
        super();
        this.employeeId = "E000";
        this.department = "Unknown";
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, int age, String email, String employeeId, String department, double salary) {
        super(name, age, email);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}