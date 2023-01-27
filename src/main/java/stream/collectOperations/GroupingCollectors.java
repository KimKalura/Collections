package stream.collectOperations;


import stream.helperClasses.Account;
import stream.helperClasses.Employee;
import stream.helperClasses.Item;
import stream.helperClasses.Status;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingCollectors {
    public static void main(String[] args) {

        List<Account> accounts = List.of(
                new Account(3333, "530012", Status.REMOVED),
                new Account(15000, "771843", Status.ACTIVE),
                new Account(0, "681891", Status.BLOCKED),
                new Account(2000, "681891", Status.ACTIVE)
        );
        //1. grupeaza conturile din lista dupa status (adica genereaza o mapa in care cheia este statusul, iar valoarea o lista cu toate conturile care au acel status)
        Map<Status, List<Account>> accountsByStatus = accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getStatus()));
        System.out.println("JAVA8, ex 1 " + accountsByStatus);

        System.out.println("CLASIC, ex 1" + getAccountsListByStatus(accounts));


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));
        //2. grupeaza angajatii din lista dupa tara (adica genereaza o mapa in care cheia este tara, iar valoarea o lista cu toti angajatii din acea tara
        Map<String, List<Employee>> employeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry()));
        System.out.println("JAVA8, ex 2 " + employeesByCountry);
        System.out.println("CLASIC, ex 2 " + getEmployeesByCountry(employeeList));

        //3. genereaza o mapa in care cheia este tara, iar valoarea este suma salariilor angajatilor din acea tara)
        Map<String, Long> sumOfSalariesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.summingLong(employee -> employee.getSalary())));
        System.out.println("JAVA8, ex 3 " + sumOfSalariesByCountry);
        System.out.println("CLASIC, ex 3 " + getSumOfSalariesByCountry(employeeList));

        //4. genereaza o mapa in care cheia este tara, iar valoarea este numarul de angajati din acea tara)
        Map<String, Long> numberOfEmployeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.counting()));
        System.out.println("JAVA8, ex 4 " + numberOfEmployeesByCountry);
        System.out.println("CLASIC, ex4 " + getNoOfEmployeesByCountry(employeeList));

        List<Item> items = Arrays.asList(
                new Item("apple", 10, 9.99),
                new Item("banana", 20, 19.99),
                new Item("orange", 10, 29.99),
                new Item("watermelon", 10, 29.99),
                new Item("papaya", 20, 9.99),
                new Item("apple", 10, 9.99),
                new Item("banana", 10, 19.99),
                new Item("apple", 20, 9.99)
        );
        System.out.println(" ");


        //5. genereaza o mapa in care cheia este numele produsului, iar valoarea este numarul de produse cu acel nume care se afla in lista
        Map<String, Long> noOfProductsByName = items.stream()
                .collect(Collectors.groupingBy(item -> item.getName(), Collectors.counting()));
        System.out.println("JAVA8, ex 5, number of products by name " + noOfProductsByName);
        System.out.println("CLASIC, ex 5, number of products by name " + getNoOfProductsByName(items));


        //6. genereaza o mapa in care cheia este numele produsului, iar valoarea cantitatea totala a produselor cu acel nume)
        Map<String, Long> quantityOfProductsByname = items.stream()
                .collect(Collectors.groupingBy(item -> item.getName(), Collectors.summingLong(item -> item.getQty())));
        System.out.println("JAVA8, ex 6 " + quantityOfProductsByname);
        System.out.println("CLASIC, ex 6 " + getQuantityOfProductsByName(items));

        //7. genereaza o mapa in care cheia este pretul produsului, iar valoarea este lista de produse cu acelasi pret; adica grupeaza produsele dupa pret
        Map<Double, List<Item>> productsByPrice = items.stream()
                .collect(Collectors.groupingBy(item -> item.getPrice()));
        System.out.println("JAVA8, ex 7 " + productsByPrice);
        System.out.println("CLASIC, ex 7 " + getAllProductsByPrice(items));
    }

    //1
    public static Map<Status, List<Account>> getAccountsListByStatus(List<Account> accountsList) {
        Map<Status, List<Account>> foundAccountByStatus = new HashMap<>();
        for (Account account : accountsList) {
            if (!foundAccountByStatus.containsKey(account.getStatus())) {
                List<Account> list = new ArrayList<>();
                list.add(account);
                foundAccountByStatus.put(account.getStatus(), list);
            } else {
                foundAccountByStatus.get(account.getStatus()).add(account);
            }
        }
        return foundAccountByStatus;
    }

    //2
    public static Map<String, List<Employee>> getEmployeesByCountry(List<Employee> employeeList) {
        Map<String, List<Employee>> employeesByCountry = new HashMap<>();
        for (Employee employee : employeeList) {
            if (!employeesByCountry.containsKey(employee.getCountry())) {
                List<Employee> list = new ArrayList<>();
                list.add(employee);
                employeesByCountry.put(employee.getCountry(), list);
            } else {
                employeesByCountry.get(employee.getCountry()).add(employee);

            }
        }
        return employeesByCountry;
    }

    //3
    public static Map<String, Integer> getSumOfSalariesByCountry(List<Employee> employeeList) {
        Map<String, Integer> sumOfSalariesByCountry = new HashMap<>();
        for (Employee employee : employeeList) {
            if (!sumOfSalariesByCountry.containsKey(employee.getCountry())) {
                sumOfSalariesByCountry.put(employee.getCountry(), employee.getSalary());
            } else {
                sumOfSalariesByCountry.put(employee.getCountry(), sumOfSalariesByCountry.get(employee.getCountry()) + employee.getSalary());
            }
        }
        return sumOfSalariesByCountry;
    }

    //4
    public static Map<String, Integer> getNoOfEmployeesByCountry(List<Employee> employeesList) {
        Map<String, Integer> noOfEmployeesByCountry = new HashMap<>();
        for (Employee employee : employeesList) {
            if (!noOfEmployeesByCountry.containsKey(employee.getCountry())) {
                noOfEmployeesByCountry.put(employee.getCountry(), 1);
            } else {
                noOfEmployeesByCountry.put(employee.getCountry(), noOfEmployeesByCountry.get(employee.getCountry()) + 1);
            }
        }
        return noOfEmployeesByCountry;
    }

    //6
    public static Map<String, Integer> getQuantityOfProductsByName(List<Item> items) {
        Map<String, Integer> quantityOfProductsByName = new HashMap<>();
        for (Item product : items) {
            if (!quantityOfProductsByName.containsKey(product.getName())) {
                quantityOfProductsByName.put(product.getName(), product.getQty());
            } else {
                quantityOfProductsByName.put(product.getName(), quantityOfProductsByName.get(product.getName()) + product.getQty());
            }
        }
        return quantityOfProductsByName;
    }

    //5
    public static Map<String, Integer> getNoOfProductsByName(List<Item> items) {
        Map<String, Integer> noOfProductByName = new HashMap<>();
        for (Item product : items) {
            if (!noOfProductByName.containsKey(product.getName())) {
                noOfProductByName.put(product.getName(), 1);
            } else {
                noOfProductByName.put(product.getName(), noOfProductByName.get(product.getName()) + 1);
            }
        }
        return noOfProductByName;
    }

    //7
    public static Map<Double, List<Item>> getAllProductsByPrice(List<Item> items) {
        Map<Double, List<Item>> productByPrice = new HashMap<>();
        for (Item product : items) {
            if (!productByPrice.containsKey(product.getPrice())) {
                List<Item> list = new ArrayList<>();
                list.add(product);
                productByPrice.put(product.getPrice(), list);
            } else {
                productByPrice.get(product.getPrice()).add(product);
            }
        }
        return productByPrice;
    }

}