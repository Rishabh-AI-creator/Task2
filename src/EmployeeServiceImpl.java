
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl {
    private EmployeeRepository employeeRepository;
     public EmployeeServiceImpl(){
         employeeRepository = new EmployeeRepository();
     }
    public void addEmployeeDetails(Employee employee) {
        employeeRepository.insertEmployeeData(employee);
    }

    public List<Employee> getEmployeeDetail() {
        List<Employee> employee = employeeRepository.getEmployeeList();
        return employee;
    }

    public void getSortedEmployeeDetail() {
        List<Employee> employee = employeeRepository.getEmployeeList();
        Collections.sort(employee);
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }
    }

    public Map<Integer, Employee> getUniqueEmployeeDetail() {
        List<Employee> employee = employeeRepository.getEmployeeList();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee1 : employee) {
            map.put(employee1.getEmpId(), employee1);
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
        List<Employee> employees = employeeRepository.getEmployeeList();
        Employee employee = new Employee();
        boolean check = false;
        for (Employee employee1 : employees) {
            if (employee1.getEmpId().equals(empId)) {
                check = true;
                System.out.println(employee1.getEmpId() + " - " + employee1.getEmpName() + " - " + employee1.getSalary() + " - " + employee1.getDept_Name());
            }
        }
        return check;
    }

    public void printEmployeeDetailsBySalary() {
        List<Employee> employee = employeeRepository.getEmployeeList();
        Collections.sort(employee,new NameComparator());
        Map<Integer,String> map =new LinkedHashMap<>();
        for(Employee employee1 : employee){
            map.put(employee1.getEmpId(),employee1.getEmpName());
        }
        Set<Map.Entry<Integer, String>> list =  map.entrySet();
        System.out.println(list);
        Map<Integer, List<Employee>> mapMap = employee.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(mapMap);
    }

    public boolean deleteEmployeeDetail(Integer empId) {
       List<Employee> employeeList = employeeRepository.deleteEmployeeData();
         boolean verify = false;
        for (int i = 0 ; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmpId().equals(empId)) {
                verify = true;
                employeeList.remove(i);
            }
        }
         return verify;
    }

    public void printAllEmployeeNameUpperCase() {
         List<Employee> employeeList = employeeRepository.getEmployeeList();
         List<String> listName = employeeList.stream().map(employee1 -> employee1.getEmpName().toUpperCase()).collect(Collectors.toList());
         System.out.println(listName);
    }

    public void printSalaryAboveInput(int salary) {
         List<Employee> employees = employeeRepository.getEmployeeList();
         List<Employee> employeesBySalary = employees.stream().filter(employee -> employee.getSalary()>salary).collect(Collectors.toList());
        System.out.println(employeesBySalary);
    }

    public int totalSalaryOfEmployees() {
        List<Employee> employees = employeeRepository.getEmployeeList();
        int total_Salary = employees.stream().mapToInt(Employee::getSalary).sum();
        return total_Salary;
    }
    public OptionalDouble averageSalaryOfEmployees() {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalDouble average_Salary = employees.stream().mapToInt(Employee::getSalary).average();
        return average_Salary;
    }
    public OptionalInt maxSalaryOfEmployees() {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalInt max_Salary = employees.stream().mapToInt(Employee::getSalary).max();
        return max_Salary;
    }
    public OptionalInt minSalaryOfEmployees() {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalInt min_Salary = employees.stream().mapToInt(Employee::getSalary).min();
        return min_Salary;
    }

    public int totalSalaryOfEmployeesAccDepartment(String dept_name) {
        List<Employee> employees = employeeRepository.getEmployeeList();
        int total_DepartmentSalary = employees.stream().filter(employee -> employee.getDept_Name().equals(dept_name)).mapToInt(Employee::getSalary).sum();
        return total_DepartmentSalary;
    }

    public OptionalDouble averageSalaryOfEmployeesAccDepartment(String dept_name) {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalDouble average_DepartmentSalary = employees.stream().filter(employee -> employee.getDept_Name().equals(dept_name)).mapToInt(Employee::getSalary).average();
        return average_DepartmentSalary;
    }

    public OptionalInt maxSalaryOfEmployeesAccDepartment(String dept_name) {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalInt max_DepartmentSalary = employees.stream().filter(employee -> employee.getDept_Name().equals(dept_name)).mapToInt(Employee::getSalary).max();
        return max_DepartmentSalary;
    }

    public OptionalInt minSalaryOfEmployeesAccDepartment(String dept_name) {
        List<Employee> employees = employeeRepository.getEmployeeList();
        OptionalInt min_DepartmentSalary = employees.stream().filter(employee -> employee.getDept_Name().equals(dept_name)).mapToInt(Employee::getSalary).min();
        return min_DepartmentSalary;
    }
}

