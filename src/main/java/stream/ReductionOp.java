package stream;

import org.w3c.dom.ls.LSOutput;
import stream.helperClasses.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReductionOp {
    public static void main(String[] args) {
        List<Integer> transactions = List.of(20, 40, -60, 5);
        //1. printeaza maximul din lista de numere
        Optional<Integer> optionalMax = transactions.stream()
                .max((number1, number2) -> number1.compareTo(number2));
        System.out.println(optionalMax.orElse(0));

        System.out.println(maxNumber(transactions));
        System.out.println(maxNumber1(transactions));

        //2. printeaza suma numerelor din lista
        Optional<Integer> optionalSum = transactions.stream()
                .reduce((sum, transaction) -> sum + transaction);

//       if(optionalSum.isPresent()){
//            System.out.println(optionalSum.get());
//        }
        System.out.println(optionalSum.orElse(0));

        System.out.println(printSum(transactions));
        System.out.println(printSum1(transactions));


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "India"));
        employeeList.add(new Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new Employee("Ryan", 53, 54000, "Libya"));
        //3. printeaza suma salariilor angajatilor din lista
        //pasi (3)
        //1.stream din lista de angajati
        //2. mapam lista de angajati la lista de salarii
        //3. folosim reduce pt a face suma salariilor
        Optional<Integer> printSumOfAllEmployeesSalaries = employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce((sum, transaction) -> sum + transaction);
        System.out.println(printSumOfAllEmployeesSalaries.orElse(0));

        System.out.println(printSumOfSalaries(employeeList));
        System.out.println(printSumOfSalaries1(employeeList));
    }

    //With METHODS:
    //1
    public static Integer maxNumber(List<Integer> noList) {
        Optional<Integer> optionalMax = noList.stream()
                .max((number1, number2) -> number1.compareTo(number2));
        return optionalMax.orElse(0);
    }

    public static Integer maxNumber1(List<Integer> noList) {
        int max = noList.get(0);
        //int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < noList.size(); i++) {
            if (max < noList.get(i)) {
                max = noList.get(i);
            }
        }
        return max;
    }

    //2
    public static Integer printSum(List<Integer> noList) {
        Optional<Integer> optionalSum = noList.stream()
                .reduce((sum, transaction) -> sum + transaction);
        return optionalSum.orElse(0);
    }

    public static Integer printSum1(List<Integer> noList) {
        int sum = 0;
        for (int i = 0; i < noList.size(); i++) {
            sum += noList.get(i);
        }
        return sum;
    }

    //3
    public static Integer printSumOfSalaries(List<Employee> employeeList) {
        Optional<Integer> printSumOfAllEmployeesSalaries = employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce((sum, transaction) -> sum + transaction);
        return printSumOfAllEmployeesSalaries.orElse(0);
    }

    public static Integer printSumOfSalaries1(List<Employee> employeeList) {
        int sum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            sum += employeeList.get(i).getSalary();
        }
        return sum;
    }
}
