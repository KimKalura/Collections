package company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Korea", "Kim", 51));
        employeeList.add(new Employee("Israel", "Ariela", 36));
        employeeList.add(new Employee("Lebanon", "Fatima", 28));
        employeeList.add(new Employee("Palestine", "Abdul", 45));
        employeeList.add(new Employee("Romania", "Irina", 25));
        employeeList.add(new Employee("Romania", "Raluca", 26));

        Company company = new Company(employeeList);

        System.out.println(company.filterByAgeGreaterThan(50));
        System.out.println(company.findEmployeesByCountry("Romania"));
        company.sortByName();
        System.out.println(company.getEmployeeList());
        company.sortByCountry();
        System.out.println(company.getEmployeeList());

        System.out.println(company.groupNoOfEmployeesByCountry());
        System.out.println(company.groupEmployeesByCountry());

    }
}
