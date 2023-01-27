package stream.collectOperations;

import stream.helperClasses.Account;
import stream.helperClasses.Employee;
import stream.helperClasses.Status;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingOp {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "India"));
        employeeList.add(new Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new Employee("Ryan", 53, 54000, "Libya"));
        //1. returneaza o lista cu numele tututor angajatilor din lista de angajati
        List<String> employeeNames = employeeList.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        System.out.println(employeeNames);

        System.out.println(getEmployeeNames1(employeeList));
        System.out.println(getEmployeeNames2(employeeList));

        //2. returneaza un set cu tarile tututor angajatilor din lista de angajati
        Set<String> employeeCountries = employeeList.stream()
                .map(employee -> employee.getCountry())
                .collect(Collectors.toSet());
        System.out.println(employeeCountries);

        System.out.println(getEmployeeCountries(employeeList));

        //3. returneaza o mapa in care cheia este fiecare nume de angajat din lista, iar valoarea este tara angajatului
        Map<String, String> employeesByCountry = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getCountry()));
        System.out.println(employeesByCountry);

        System.out.println(getEmployeesByCountry(employeeList));

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(3000, "3451231231", Status.ACTIVE));
        accounts.add(new Account(4000, "1233451233", Status.ACTIVE));
        accounts.add(new Account(5000, "1287429134", Status.ACTIVE));
        accounts.add(new Account(6000, "4567831246", Status.ACTIVE));
        accounts.add(new Account(7000, "3467851293", Status.ACTIVE));
        //***
        //4. returneaza o lista cu numerele de cont ale tuturor conturilor din lista de conturi
        List<String> accountsNumbersForAllAccounts = accounts.stream()
                .map(account -> account.getNumber())
                 //.forEach(account-> System.out.println(account));
                .collect(Collectors.toList());
        System.out.println(accountsNumbersForAllAccounts);

        System.out.println(getAccountsNumbersForAllAccounts1(accounts));

        //5. returneaza suma soldurilor  tuturor conturilor din lista de conturi
        Optional<Integer> sumOfBalance = accounts.stream()
                .map(account -> account.getBalance())
                .reduce((sum, balance) -> sum + balance);
        System.out.println(sumOfBalance.orElse(0));
        //VAR 2
        Integer sum = accounts.stream().collect(Collectors.summingInt(a -> a.getBalance()));
        System.out.println(sum);

        System.out.println(getSumOfBalance(accounts));

        //***
        //6. returneaza o lista cu soldurile conturilor din lista de conturi
        List<Integer> accountsSoldList = accounts.stream()
                .map(account -> account.getBalance())
                .collect(Collectors.toList());
        System.out.println(accountsSoldList);

        System.out.println(getAccountsSoldList(accounts));
    }

    //1
    public static List<String> getEmployeeNames1(List<Employee> employeeList) {
        List<String> employeeNames = employeeList.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        return employeeNames;
    }

    public static List<String> getEmployeeNames2(List<Employee> employeeList) {
        List<String> allEmployeesNames = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            allEmployeesNames.add(employeeList.get(i).getName());
        }
        return allEmployeesNames;
    }

    //2
    public static Set<String> getEmployeeCountries(List<Employee> employeeList) {
        Set<String> allCountries = new HashSet<>();
        for (int i = 0; i < employeeList.size(); i++) {
            allCountries.add(employeeList.get(i).getCountry());
        }
        return allCountries;
    }

    //3
    public static Map<String, String> getEmployeesByCountry(List<Employee> employeesList) {
        Map<String, String> employeesByCountry = new HashMap<>();
        for (Employee employee : employeesList) {
            employeesByCountry.put(employee.getName(), employee.getCountry());
        }
        return employeesByCountry;
    }

    //4
    public static List<String> getAccountsNumbersForAllAccounts1(List<Account> accountList) {
        List<String> accountsNumbers = new ArrayList<>();
        for (int i = 0; i < accountList.size(); i++) {
            accountsNumbers.add(accountList.get(i).getNumber());
        }
        return accountsNumbers;
    }

    //5
    public static Integer getSumOfBalance(List<Account> accountList) {
        int sum = 0;
        for (int i = 0; i < accountList.size(); i++) {
            sum += accountList.get(i).getBalance();
        }
        return sum;
    }

    //6
    public static List<Integer> getAccountsSoldList(List<Account> accountList) {
        List<Integer> foundedAccountSold = new ArrayList<>();
        for (int i = 0; i < accountList.size(); i++) {
            foundedAccountSold.add(accountList.get(i).getBalance());
        }
        return foundedAccountSold;
    }
}