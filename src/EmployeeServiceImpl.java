
import java.util.*;

public class EmployeeServiceImpl {
    public void addEmployeeDetails() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001, "Raman", 10000));
        employees.add(new Employee(1002, "Rohit", 20000));
        employees.add(new Employee(1003, "Manoj", 12000));
        employees.add(new Employee(1004, "Amit", 12000));
        employees.add(new Employee(1005, "Kabit", 11500));
        employees.add(new Employee(1006, "Laxam", 11500));
        employees.add(new Employee(1007, "Dipesh", 10000));
        employees.add(new Employee(1008, "Amit", 10000));
        employees.add(new Employee(1009, "Manoj", 17500));
        employees.add(new Employee(1010, "Rohit", 21000));
        employees.add(new Employee(1003, "Manoj", 15000));
        employees.add(new Employee(1002, "Rohit", 20000));
        for (Employee employee : employees) {
            EmployeeRepository.employeesList.add(employee);
        }
    }

    public void getEmployeeDetail() {
        List<Employee> employee = EmployeeRepository.employeesList;
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }
    }

    public void getSortedEmployeeDetail() {
        List<Employee> employee = EmployeeRepository.employeesList;
        Collections.sort(employee);
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }
    }

    public Map<Integer, Employee> getUniqueEmployeeDetail() {
        List<Employee> employee = EmployeeRepository.employeesList;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee1 : employee) {
            map.put(employee1.empId, employee1);
        }
        return map;
    }

    public void getUniqueSortedEmployeeDetail() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Map<Integer, Employee> map = employeeService.getUniqueEmployeeDetail();
        List<Employee> employees = new ArrayList<>(map.values());
        Collections.sort(employees, new NameComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public boolean printEmployeeDetailByID(Integer empId) {
        List<Employee> employees = EmployeeRepository.employeesList;
        Employee employee = new Employee();
        boolean check = false;
        for (Employee employee1 : employees) {
            if (employee1.empId.equals(empId)) {
                check = true;
                System.out.println(employee1.empId + " " + employee1.empName + " " + employee1.salary);
            }
        }
        return check;
    }

    public void printEmployeeDetailsBySalary() {
        List<Employee> employeeList = EmployeeRepository.employeesList;

          Map<Integer,String> map = new HashMap<>();
          for(Employee employee: employeeList) {
              map.put(employee.empId, employee.empName);

          }
          List list = new LinkedList(map.entrySet());
          Collections.sort(list,new NameComparator());
        System.out.println(list);

//        Collections.sort(employeeList, new NameComparator());
//        Map<Integer,List<Employee>> map= new HashMap<>();
//        for(Employee employee: employeeList){
//            map.put(employee.salary,employeeList);
//        }
//        System.out.println(map);

    }

}

