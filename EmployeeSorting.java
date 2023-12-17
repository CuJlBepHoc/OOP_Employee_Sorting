package Homework.HM_003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = generateRandomEmployees(15);
        printEmployees("Начальный список: ", employees);

        // 1. Сортировка по убыванию возраста
        Collections.sort(employees, Comparator.comparingInt(Employee::getAge).reversed());
        printEmployees("Сортировка по убыванию возраста:", employees);

        // 2. Сортировка по возрастанию зарплаты
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        printEmployees("Сортировка по зарплате:", employees);

        // 3. Топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени
        List<Employee> top5BySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(5)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        printEmployees("Топ 5 сотрудников с наибольшей зарплатой (Сортировка по имени):", top5BySalary);

        // 4. Сортировать сотрудников по возрастанию возрастов, затем убыванию зарплаты,
        // затем по имени
        Collections.sort(employees, Comparator
                .comparingInt(Employee::getAge)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                .thenComparing(Employee::getName));
        printEmployees("Особая сортировка:", employees);
    }

    private static List<Employee> generateRandomEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();
        String[] names = { "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack" };

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            int age = 20 + random.nextInt(40);
            double salary = random.nextDouble() * 5000;
            employees.add(new Employee(name, age, salary));
        }

        return employees;
    }

    private static void printEmployees(String message, List<Employee> employees) {
        System.out.println(message);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
}