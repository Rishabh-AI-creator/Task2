import java.util.ArrayList;
import java.util.List;

public  class EmployeeDataBase {
   private List<Employee> employeesList;

   public EmployeeDataBase (){
      employeesList = new ArrayList<>();
      employeesList.add(new Employee(1001, "Raman", 10000));
      employeesList.add(new Employee(1002, "Rohit", 20000));
      employeesList.add(new Employee(1003, "Manoj", 12000));
      employeesList.add(new Employee(1004, "Amit", 12000));
      employeesList.add(new Employee(1005, "Kabit", 11500));
      employeesList.add(new Employee(1006, "Laxam", 11500));
      employeesList.add(new Employee(1007, "Dipesh", 10000));
      employeesList.add(new Employee(1008, "Amit", 10000));
      employeesList.add(new Employee(1009, "Manoj", 17500));
      employeesList.add(new Employee(1010, "Rohit", 21000));
      employeesList.add(new Employee(1003, "Manoj", 15000));
      employeesList.add(new Employee(1002, "Rohit", 20000));
   }
   public  void addNewEmployeeDetails(Employee employee){
      Employee employee1 =new Employee(employee.getEmpId(), employee.getEmpName(), employee.getSalary());
      employeesList.add(employee1);
   }
   public List<Employee> getEmployeesList(){
      return employeesList;
   }
}
