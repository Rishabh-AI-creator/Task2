import java.util.ArrayList;
import java.util.List;

public  class EmployeeDataBase {
  private  List<Employee> employeesList;
  private static EmployeeDataBase instance = null;

  private EmployeeDataBase (){
      employeesList = new ArrayList<>();
      employeesList.add(new Employee(1001, "Raman", 10000,"Backend"));
      employeesList.add(new Employee(1002, "Rohit", 20000,"Tester"));
      employeesList.add(new Employee(1003, "Manoj", 12000,"Frontend"));
      employeesList.add(new Employee(1004, "Amit", 12000,"Backend"));
      employeesList.add(new Employee(1005, "Kabit", 11500,"Frontend"));
      employeesList.add(new Employee(1006, "Laxam", 11500,"Frontend"));
      employeesList.add(new Employee(1007, "Dipesh", 10000,"Tester"));
      employeesList.add(new Employee(1008, "Amit", 10000,"Backend"));
      employeesList.add(new Employee(1009, "Manoj", 17500,"Frontend"));
      employeesList.add(new Employee(1010, "Rohit", 21000,"Tester"));
      employeesList.add(new Employee(1003, "Manoj", 15000,"Tester"));
      employeesList.add(new Employee(1002, "Rohit", 20000,"Backend"));
   }
   public  static EmployeeDataBase getInstance(){
      synchronized (EmployeeDataBase.class) {
          if (instance == null) {

              instance = new EmployeeDataBase();

          }
          return instance;
      }
   }
   public List<Employee> getEmployeesList(){
      return employeesList;
   }
}
