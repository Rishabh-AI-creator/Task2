import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Employee Details Management");

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        while(true){
            System.out.println("\n");
            System.out.println("1. Add Employee details");
            System.out.println("2. Print Employee List");
            System.out.println("3. Print Employee List in Sorting Order");
            System.out.println("4. Print all the unique Employee");
            System.out.println("5. Print all the unique Employee By Sorting");
            System.out.println("6. Print Employee details by EmpId ");
            System.out.println("7. Print Employee List by Salary ");
            System.out.println("8. Delete Employee Detail by EmpId ");
            System.out.println("9. Print All Employee name in upper case");
            System.out.println("10. Print All Employee List with salary greater than input by user");
            System.out.println("11. Find Total,Average,Min,Max Salary in Employee List");
            System.out.println("12. Print Total,Average,Min,Max Salary dept wise");
            System.out.println("13. Exit");
            System.out.println("Enter option: ");
            int option = scanner.nextInt();
             if(option == 1){
                 System.out.println("Enter employee id:");
                 int empId = scanner.nextInt();
                 System.out.println("Enter employee name:");
                 String empName = scanner.next();
                 System.out.println("Enter employee salary");
                 int salary = scanner.nextInt();
                 System.out.println("Enter department name");
                 String dept_Name = scanner.next();
                 Employee employee = new Employee(empId,empName,salary,dept_Name);
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
            else if(option == 9){
                 employeeService.printAllEmployeeNameUpperCase();
             }
             else if(option == 10){
                 System.out.println("Enter salary");
                 int salary = scanner.nextInt();
                 employeeService.printSalaryAboveInput(salary);
             }
             else if(option == 11){
                 System.out.println("1.Print total salary of employees ");
                 System.out.println("2.Print average salary of employees ");
                 System.out.println("3.Print max salary of employees ");
                 System.out.println("4.Print min salary of employees ");
                 System.out.println("Enter choice");
                 int choice = scanner.nextInt();

                 if(choice == 1) {
                     System.out.println("Total salary: ");
                     int total_Salary = employeeService.totalSalaryOfEmployees();
                     System.out.println(total_Salary);
                 }
                 else if(choice == 2) {
                     System.out.println("Average salary: ");
                     OptionalDouble average_Salary = employeeService.averageSalaryOfEmployees();
                     System.out.println(average_Salary);
                 }
                 else if(choice == 3){
                     System.out.println("Maximum salary: ");
                     OptionalInt max_Salary = employeeService.maxSalaryOfEmployees();
                     System.out.println(max_Salary);
                 }
                 else if(choice == 4){
                     System.out.println("Minimum salary: ");
                     OptionalInt min_Salary = employeeService.minSalaryOfEmployees();
                     System.out.println(min_Salary);
                 }
             }
             else if(option == 12){
                 System.out.println("Enter department name");
                 String dept_Name = scanner.next();
                 int total_DeptSalary = employeeService.totalSalaryOfEmployeesAccDepartment(dept_Name);
                 System.out.println(total_DeptSalary);
                 OptionalDouble average_DepartmentSalary = employeeService.averageSalaryOfEmployeesAccDepartment(dept_Name);
                 System.out.println(average_DepartmentSalary);
                 OptionalInt max_DepartmentSalary = employeeService.maxSalaryOfEmployeesAccDepartment(dept_Name);
                 System.out.println(max_DepartmentSalary);
                 OptionalInt min_DepartmentSalary = employeeService.minSalaryOfEmployeesAccDepartment(dept_Name);
                 System.out.println(min_DepartmentSalary);
             }
             else if( option == 13){
                System.out.println("Exit");
            break;
            }
            else {
                System.out.println("Option not found");
            }
        }
    }
}
