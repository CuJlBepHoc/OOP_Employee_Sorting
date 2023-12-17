package Homework.HM_003;

public class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: Имя='%s', Возраст=%d, ЗП=%.0f", name, age, salary);
    }
}
