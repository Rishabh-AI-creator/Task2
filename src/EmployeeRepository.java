import java.util.List;

public class EmployeeRepository {
    private  EmployeeDataBase employeeDataBase;

    public EmployeeRepository(){
        employeeDataBase = new EmployeeDataBase();
    }
    public void insertEmployeeData(Employee employee){
        employeeDataBase.getEmployeesList().add(employee);
    }

    public List<Employee> getEmployeeList(){
       return employeeDataBase.getEmployeesList();
    }

    public List<Employee> deleteEmployeeData() {
       return employeeDataBase.getEmployeesList();
    }
}
