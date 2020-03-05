package com.lingjiancong.base;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lingjiancong
 * @since 2018-06-08
 */
public class Java8Test {

    @Test
    public void mapTest() {

        Map<String, Integer> map = new HashMap<>();

        map.computeIfAbsent("123", Integer::valueOf);
        map.forEach((k, v) ->
                System.out.println(k + " - " + v)
        );

        map.computeIfPresent("123", (key, value) -> Integer.valueOf(key) + 10);
        System.out.println(map);

        map.merge("123", 123, (oldValue, newValue) -> oldValue - newValue);
        map.forEach((k, v) ->
                System.out.println(k + " - " + v)
        );
    }

    @Test
    public void dateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();

        Date date = new Date();

        System.out.println(dateTime);
        System.out.println(date);

        Instant instant = Instant.now();

        System.out.println(Date.from(instant));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        System.out.println(formatter.format(dateTime));
    }

    @Test
    public void functionalInterfaceTest() {
        Predicate<String> predicate = s -> s.length() > 0;

        Assert.assertTrue(predicate.test("s"));
        Assert.assertFalse(predicate.negate().test("s"));

        Optional<String> op = Optional.ofNullable(null);

        Assert.assertFalse(op.isPresent());
    }

    @Test
    public void streamTest() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        IntStream.range(1, 4)
                .mapToObj(v -> "a" + v)
                .sorted()
                .forEach(System.out::println);

        Arrays.stream(new int[]{1, 3, 3, 2})
                .average()
                .ifPresent(System.out::println);

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);

    }

    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    List<Person> persons =
            Arrays.asList(
                    new Person("Max", 18),
                    new Person("Peter", 23),
                    new Person("Pamela", 23),
                    new Person("David", 12));


    @Test
    public void collectTest() {
        persons.stream()
                .collect(Collectors.groupingBy(p -> p.age))
                .forEach((k, v) -> System.out.println(k + " : " + v));

        persons.stream()
                .collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + " : " + name2))
                .forEach((k, v) -> System.out.println(k + " : " + v));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        // supplier
                        () -> new StringJoiner(" | "),
                        // accumulator
                        (j, p) -> j.add(p.name.toUpperCase()),
                        // combiner
                        (j1, j2) -> j1.merge(j2),
                        // finisher
                        StringJoiner::toString);

        String names = persons
                .stream()
                .collect(personNameCollector);

        // MAX | PETER | PAMELA | DAVID
        System.out.println(names);
    }


    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    @Test
    public void flatMapTest() {
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        System.out.println(foos);

        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

    @Test
    public void reduceTest() {
        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
    }

    @Test
    public void filterTest() {
        List<Integer> list = new ArrayList<>();

        IntStream.range(1, 4).forEach(v -> list.add(v));

        System.out.println(list);

        List<Integer> value = list.stream().filter(x -> x < 0).collect(Collectors.toList());
        System.out.println(value);
    }

    @Test
    public void testEmptySum() {

        Value value = new Value();
        value.type = 1;
        value.value = 2;

        List<Value> values = new ArrayList<>();
        values.add(value);

        int sum = values.stream().filter(x -> x.type == 2).mapToInt(x -> x.value).sum();
        Assert.assertTrue(sum == 0);
    }

    class Value {
        @Rule
        public int type;
        public int value;
    }

    @Test
    public void testDate() {
        int monthInt = 201808;
        final int year = monthInt / 100, month = monthInt % 100;
        LocalDate date = LocalDate.of(year, month, 1);
        final String monthString = date.toString().substring(0, 7);
        System.out.println(monthString);

    }

}
