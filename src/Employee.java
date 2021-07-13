import java.util.Objects;

public class Employee implements Comparable<Employee> {
    public Integer empId;
    public String empName;
    public Integer salary;


    public Employee(Integer empId, String empName, Integer salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && salary == employee.salary && Objects.equals(empName, employee.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, salary);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.empId - employee.empId;
    }
}
