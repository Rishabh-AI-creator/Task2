import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
// 1. Store All the above Employee using Suitable Collections
        employees.add(new Employee(1001,"Raman", 10000));
        employees.add(new Employee(1002,"Rohit", 20000));
        employees.add(new Employee(1003,"Manoj", 12000));
        employees.add(new Employee(1004,"Amit", 12000));
        employees.add(new Employee(1005,"Kabit", 11500));
        employees.add(new Employee(1006,"Laxam", 11500));
        employees.add(new Employee(1007,"Dipesh", 10000));
        employees.add(new Employee(1008,"Amit", 10000));
        employees.add(new Employee(1009,"Manoj", 17500));
        employees.add(new Employee(1010,"Rohit", 21000));
        employees.add(new Employee(1003,"Manoj", 15000));
        employees.add(new Employee(1002,"Rohit", 20000));

// 2.Print Employee List in sorting order of empId (using comparator/comparable)
        Collections.sort(employees);
        for(Employee employee  :  employees){
            System.out.println(employee);
        }
        System.out.println();

// 3. a.Print all the unique Employee (use equals and hashcode and store in set
        System.out.println();
        Set<Employee> employees1 = new HashSet<>(employees);
        for (Employee employee: employees1){
            System.out.println(employee);
        }
//    b.Sort the above unique Employee according to name

        List<Employee> employees2 = new ArrayList<>(employees1);
        Collections.sort(employees2,new NameComparator());
        for (Employee employee: employees2){
            System.out.println(employee);
        }

// 4. a.Store All the Employee List using EmpId as a key in Map and value should be EmployeeDetails
//	Example
//	map.put("1001", new Employee(1001,"Dummy",8000));
        System.out.println();
        Map<Integer,Employee> map = new HashMap<>();
        map.put(1001,new Employee(1001,"Raman", 10000));
        map.put(1002,new Employee(1002,"Rohit", 20000));
        map.put(1003,new Employee(1003,"Manoj", 12000));
        map.put(1004,new Employee(1004,"Amit", 12000));
        map.put(1005,new Employee(1005,"Kabit", 11500));
        map.put(1006,new Employee(1006,"Laxam", 11500));
        map.put(1007,new Employee(1007,"Dipesh", 10000));
        map.put(1008,new Employee(1008,"Amit", 10000));
        map.put(1009,new Employee(1009,"Manoj", 17500));
        map.put(1010,new Employee(1010,"Rohit", 21000));
        map.put(1003,new Employee(1003,"Manoj", 15000));
        map.put(1002,new Employee(1002,"Rohit", 20000));

//     b. Fetch Employee Details By empId

        System.out.println(map.get(1001));


// 5. a.
        System.out.println();
       Collections.sort(employees,new NameComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
//   b.
        System.out.println();
        Collections.sort(employees,new SalaryComparator());
        System.out.println(employees);

    }
}
