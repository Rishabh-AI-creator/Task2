import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Employee Details Management");
        System.out.println("Enter the option");

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.addEmployeeDetails();
        while(true){
            int option = scanner.nextInt();
            if(option == 1){
                employeeService.getEmployeeDetail();
            }
            else if( option == 2){
                employeeService.getSortedEmployeeDetail();
            }
            else if( option == 3){
                System.out.println(employeeService.getUniqueEmployeeDetail());
            }
            else if( option == 4){
                employeeService.getUniqueSortedEmployeeDetail();
            }
            else if( option == 5){
                System.out.println("Enter employee id");
                Integer empId = scanner.nextInt();
                boolean check = employeeService.printEmployeeDetailByID(empId);
                if(!check){
                    System.out.println("Employee details not found");
                }
            }
            else if( option == 6){
                employeeService.printEmployeeDetailsBySalary();
            }
            else if( option == 7){
                System.out.println("Exit");
            break;
            }
            else {
                System.out.println("Option not found");
            }
        }
    }
}
