package org.course;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.course.dto.Animal;
import org.course.dto.Employee;
import org.course.dto.Position;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Log
public class Main {

    final List<Employee> employees = List.of(
            Employee.builder().id(1).lastName("Неприкосновенный").firstName("Светоч").age(42).position(Position.DIRECTOR).build(),
            Employee.builder().id(2).lastName("Очищающий").firstName("Жребий").age(20).position(Position.JURIST).build(),
            Employee.builder().id(3).lastName("Изысканный").firstName("Каркас").age(23).position(Position.MANAGER).build(),
            Employee.builder().id(4).lastName("Таинственный").firstName("Кокон").age(45).position(Position.MANAGER).build(),
            Employee.builder().id(5).lastName("Гневный").firstName("Ученик").age(35).position(Position.WORKER).build(),
            Employee.builder().id(6).lastName("Серебряный").firstName("Спектр").age(23).position(Position.WORKER).build(),
            Employee.builder().id(7).lastName("Пробуждающий").firstName("Свиток").age(20).position(Position.WORKER).build(),
            Employee.builder().id(8).lastName("Фальшивый").firstName("Почерк").age(52).position(Position.WORKER).build()
    );

    public static void main(String[] args) {
//        log.warning("sdfsdf");
//
//        var kj = IntStream.range(1, 10).max();
//        System.out.println(kj.getAsInt());

        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) continue;
            x += 10;
            count++;
            if (count > 3) break;
            System.out.print(x);
        }

    }

    public void create() {
        var stream1 = employees.stream();

        var stream2 = IntStream.range(1, 10); // 1..9
        var stream3 = IntStream.rangeClosed(1, 10); // 1..10

        stream2.sum();
        stream2.max();

        var stream4 = Stream.of(
                Employee.builder().id(1).lastName("Неприкосновенный").firstName("Светоч").age(42).position(Position.DIRECTOR).build(),
                Employee.builder().id(2).lastName("Очищающий").firstName("Жребий").age(20).position(Position.JURIST).build()
        );

        var stream5 = Stream.<Employee>builder()
                .add(Employee.builder().id(1).lastName("Неприкосновенный").firstName("Светоч").age(42).position(Position.DIRECTOR).build())
                .add(Employee.builder().id(1).lastName("Неприкосновенный").firstName("Светоч").age(42).position(Position.DIRECTOR).build())
                .build();

        var animalStream = Stream.of(
                new Animal("Hourse")
        );

        var streamConcat = Stream.concat(stream1, stream5);
        var streamConcat2 = Stream.concat(animalStream, stream5);
        streamConcat2.forEach(e -> {
            if (e instanceof Employee) {
                ((Employee) e).getAge();
            }
        });

        employees.parallelStream();
    }

    public void terminal() {
        var count = employees.stream().count();

        employees.stream().forEach(e -> e.getAge());

        employees.stream().forEach(e -> e.setAge(e.getAge() + 1));

        employees.forEach(e -> e.setAge(e.getAge() + 1));

        for (var employee : employees) {
            employee.setAge(employee.getAge() + 1);
        }

        for (int i = 0; i < employees.size(); i++) {
            var employee = employees.get(i);
            employee.setAge(employee.getAge() + 1);
        }

        var ageById = employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee.getAge()));
        var employeesById = employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
        employeesById.get(5);
        employees.stream().toArray();

        var list1 = employees.stream().collect(Collectors.toList());
        list1.add(Employee.builder().id(8).lastName("Фальшивый").firstName("Почерк").age(52).position(Position.WORKER).build());

        var list2 = employees.stream().toList();
        list2.add(Employee.builder().id(8).lastName("Фальшивый").firstName("Почерк").age(52).position(Position.WORKER).build());


        IntStream.range(1, 10).average();
        IntStream.range(1, 10).sum();

        employees.stream().findAny();
        employees.stream().findFirst();

        var older80 = employees.stream().anyMatch(employee -> employee.getAge() > 80);
    }

    public void nonTerminal() {
        var ages = employees
                .stream()
                .map(employee -> {
                    System.out.println(employee.getId());
                    return employee.getFirstName();
                })
                .collect(Collectors.joining(""));

        //// EQUAL
        var namesStream1 = employees
                .stream()
                .map(employee -> {
                    System.out.println(employee.getId());
                    return employee.getFirstName();
                });

        var streamBuilder = Stream.<String>builder();
        for (int i = 0; i < employees.size(); i++) {
            var employee = employees.get(i);
            streamBuilder.add(employee.getFirstName());
        }
        var namesStream2 = streamBuilder.build();
        ////

        employees
                .stream()
                .map(Employee::getId)
                .distinct()
                .toList();

        var stream1 = employees
                .stream()
                .map(employee -> {
                    System.out.println(employee.getLastName() + " " + employee.getFirstName());
                    return employee;
                });

        var stream2 = employees
                .stream()
                .peek(employee -> System.out.println(employee.getLastName() + " " + employee.getFirstName()))
                .peek(printName());

        var filtered = employees
                .stream()
                .filter(employee -> employee.getAge() < 30)
                .sorted((e1, e2) -> e1.getAge() - e2.getAge())
                .sorted(Comparator.comparingInt(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 20)
                .map(Employee::getId)
                .toList();
    }

    public static Consumer<Employee> printName() {
        return (e) -> {
            System.out.println(e.getLastName() + " " + e.getFirstName());
        };
    }

    @SneakyThrows
    public void optional(List<Employee> employees) {
        if (employees == null) {
            Collections.<Employee>emptyList().forEach(printName());
        } else {
            employees.forEach(printName());
        }

        Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .forEach(printName());

        Optional.ofNullable(employees)
                .orElseThrow(() -> new Exception("List is empty"))
                .forEach(printName());
    }

}
