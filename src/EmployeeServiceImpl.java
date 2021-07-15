
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
                System.out.println(employee1.getEmpId() + " - " + employee1.getEmpName() + " - " + employee1.getSalary());
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
}

