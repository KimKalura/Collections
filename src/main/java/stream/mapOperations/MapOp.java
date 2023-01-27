package stream.mapOperations;

import stream.helperClasses.Job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOp {
    public static void main(String[] args) {
       List<Integer> numbers = List.of(2, 4, 6, 8);
        //1. genereaza o noua lista, cu numerele din lista initiala impartite la 2
        //VAR 1
        List<Integer> dividedNumbers = numbers.stream()
                .map(number -> number / 2)
                .collect(Collectors.toList());
        System.out.println(dividedNumbers);
        //VAR 2
//        Stream<Integer> numbersStream = numbers.stream();
//        Stream<Integer> dividedNumbersStream = numbersStream.map(number -> number/2);
//        List<Integer> collectedDividedNumbers = dividedNumbersStream.collect(Collectors.toList());
//        System.out.println(collectedDividedNumbers);

        //System.out.println("ex 1" + dividedNo(numbers));

        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");
        //2. returneaza elementele din lista transformate in string-uri cu toate literele mari
        List<String> namesUpperCase = list.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(namesUpperCase);

        //3. printeaza lungimile fiecarui String din lista
//        list.stream()
//                .map(name -> name.length())
//                .forEach(l-> System.out.println(l));
        //cu .collect:
        List<Integer> nameLengths = list.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        System.out.println(nameLengths);


        List<Job> jobs = Arrays.asList(
                new Job("programator", "programeaza aplicatii", 12000),
                new Job("contabil", "tine contabilitatea", 5000));
        //4. genereaza o lista cu numele job-urilor din lista de job-uri
        System.out.println(getAllNamesJobs(jobs));
        System.out.println(getNamesOfJobWithSalaryGreaterThan(jobs, 10000));
    }


    //4
    public static List<String> getAllNamesJobs(List<Job> jobs) {
        return jobs.stream()
                .map(job -> job.getTitle())
                .collect(Collectors.toList());
    }

    public static List<String> getNamesOfJobWithSalaryGreaterThan(List<Job> jobs, int salary) {
        return jobs.stream()
                .filter(job -> job.getSalary() > salary)
                .map(job -> job.getTitle())
                .collect(Collectors.toList());
    }

}