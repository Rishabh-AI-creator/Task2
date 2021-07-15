import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Employee Details Management");
        System.out.println("Enter the option");
        System.out.println("1. Add Employee details");
        System.out.println("2. Print Employee List");
        System.out.println("3. Print Employee List in Sorting Order");
        System.out.println("4. Print all the unique Employee");
        System.out.println("5. Print all the unique Employee By Sorting");
        System.out.println("6. Print Employee details by EmpId ");
        System.out.println("7. Print Employee List by Salary ");
        System.out.println("8. Delete Employee Detail by EmpId ");
        System.out.println("9. Exit");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        while(true){
            int option = scanner.nextInt();
             if(option == 1){
                 System.out.println("Enter employee id:");
                 int empId = scanner.nextInt();
                 System.out.println("Enter employee name:");
                 String empName = scanner.next();
                 System.out.println("Enter employee salary");
                 int salary = scanner.nextInt();
                 Employee employee = new Employee(empId,empName,salary);
                 employeeService.addEmployeeDetails(employee);
             }
            else if(option == 2){
              List<Employee> employee =  employeeService.getEmployeeDetail();
                 System.out.println(employee);
            }
            else if( option == 3){
                employeeService.getSortedEmployeeDetail();
            }
            else if( option == 4){
                System.out.println(employeeService.getUniqueEmployeeDetail());
            }
            else if( option == 5){
                employeeService.getUniqueSortedEmployeeDetail();
            }
            else if( option == 6){
                System.out.println("Enter employee id");
                Integer empId = scanner.nextInt();
                boolean check = employeeService.printEmployeeDetailByID(empId);
                if(!check){
                    System.out.println("Employee details not found");
                }
            }
            else if( option == 7){
                employeeService.printEmployeeDetailsBySalary();
            }
            else if(option == 8){
                 System.out.println("Enter employee id");
                 Integer empId = scanner.nextInt();
               boolean verify = employeeService.deleteEmployeeDetail(empId);
               if(!verify){
                   System.out.println("Employee detail not found");
               }
             }
            else if( option == 9){
                System.out.println("Exit");
            break;
            }
            else {
                System.out.println("Option not found");
            }
        }
    }
}
