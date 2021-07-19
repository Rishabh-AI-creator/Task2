import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private Integer empId;
    private String empName;
    private Integer salary;
    private String dept_Name;

    public Employee(Integer empId, String empName, Integer salary , String dept_Name) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.dept_Name = dept_Name;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDept_Name() {
        return dept_Name;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", dept_Name='" + dept_Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId.equals(employee.empId) && empName.equals(employee.empName) && salary.equals(employee.salary) && dept_Name.equals(employee.dept_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, salary, dept_Name);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.empId - employee.empId;
    }

}
