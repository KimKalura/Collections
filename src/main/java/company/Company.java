package company;

import java.util.*;

public class Company {

    List<Employee> employeeList;

    public Company(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    public List<Employee> filterByAgeGreaterThan(int age) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getAge() > 50) {
                foundEmployees.add(employeeList.get(i));
            }
        }
        return foundEmployees;
    }

    public List<Employee> findEmployeesByCountry(String country) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCountry().equals(country)) {
                foundEmployees.add(employeeList.get(i));
            }
        }
        return foundEmployees;
    }

    public void sortByName() {
        Collections.sort(employeeList);
    }

    public void sortByCountry() {
        employeeList.sort(new CountryComparator());
    }

    public Map<String, Integer> groupNoOfEmployeesByCountry() {
        Map<String, Integer> noOfEmployeesByCountry = new HashMap<>();
        for (int i = 0; i < employeeList.size(); i++) {
            String country = employeeList.get(i).getCountry();
            if (!noOfEmployeesByCountry.containsKey(country)) {
                noOfEmployeesByCountry.put(country, 1);
            } else {
                noOfEmployeesByCountry.put(country, noOfEmployeesByCountry.get(country) + 1);
            }
        }
        return noOfEmployeesByCountry;
    }

    public Map<String, List<Employee>> groupEmployeesByCountry() {
        Map<String, List<Employee>> employeesByCountry = new HashMap<>();
        for (int i = 0; i < employeeList.size(); i++) {
            String country = employeeList.get(i).getCountry();
            if(!employeesByCountry.containsKey(country)) {
                List<Employee> employees = new ArrayList<>();
                employees.add(employeeList.get(i));
                employeesByCountry.put(country, employees);
            }else {
                employeesByCountry.get(country).add(employeeList.get(i));
            }
        }
        return employeesByCountry;
    }
}
