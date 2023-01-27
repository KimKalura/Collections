package lambda.collections_exercises.employeesManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //7.  Gestiunea angajatilor
        //Un angajat este caracterizat de nume si salariu
        //Un departament este caracterizat de nume, cod, si o lista de angajati. Codul este un String
        //---Avand o lista de departamente intr-un main, care are fiecare o lista de angajati, scrie o metoda care primeste lista de departamente si un salariu minim.
        //---Metoda va returna cati angajati din toate departamentele au salariul mai mare decat salariul minim primit ca parametru.
        //(HINT: stream pe departamente si apoi flatMap pentru a ajunge la angajati, apoi filter pentru a filtra pe cei cu salariul mai mare decat salariul minim si count
        // la final pentru a-i numara)

        List<Employee> employeesList1 = new ArrayList<>();
        employeesList1.add(new Employee("Sarah", 9000));
        employeesList1.add(new Employee("Ethan", 5000));
        employeesList1.add(new Employee("Rahela", 8500));

        List<Employee> employeesList2 = new ArrayList<>();
        employeesList2.add(new Employee("Raskolnikov", 4500));
        employeesList2.add(new Employee("Esther", 8700));
        employeesList2.add(new Employee("Kamil", 5600));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Medical Dep", "M356", employeesList1));
        departments.add(new Department("Technology Dep", "T888", employeesList2));

        System.out.println(getAllEmployeesWithBiggestSalaryFromDep(5800, departments));
        System.out.println(allEmployeesWithBiggestSalaryFromDep(5000, departments));
    }

    public static int getAllEmployeesWithBiggestSalaryFromDep(int minSalary, List<Department> departments) {
        int employeesNo = 0;
        for (int i = 0; i < departments.size(); i++) {
            List<Employee> currentDepEmployees = departments.get(i).getEmployeeList();
            for (int j = 0; j < currentDepEmployees.size(); j++) {
                if (minSalary < currentDepEmployees.get(j).getSalary()) {
                    employeesNo++;
                }
            }
        }
        return employeesNo;

        //SAU for-each:
       /* for (Department department : departments) {
            for (Employee employee : department.getEmployeeList()) {
                if (minSalary < employee.getSalary()) {
                    employeesNo++;
                }
            }
        }
        return employeesNo;*/
    }

    public static long allEmployeesWithBiggestSalaryFromDep(int minSalary, List<Department> departments) {

        return departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .filter(employee -> employee.getSalary() > minSalary)
                .count();
    }
}
