package de.telran.lambda.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.maxBy;

public class SimpleStream {
    public static void main(String[] args) {
        String[][] arrStr = { {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "o", "y"}};

        List<String> lists = Arrays.stream(arrStr)
                .flatMap(x->Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(lists);

        // --------  Терминальные методы
        System.out.println("--------  Терминальные методы");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        // --- toList
        List<String> result = givenList.stream()
                .map(x-> x.toUpperCase())
                .collect(toList());
        result.add("sss");
        System.out.println(result);

        result = givenList.stream()
                .collect(toUnmodifiableList());
//        result.add("sss"); //UnsupportedOperationException
        System.out.println(result);

        // --- toSet
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> resultSet = listWithDuplicates.stream().collect(toSet());
        System.out.println(resultSet);
        resultSet = listWithDuplicates.stream().collect(toCollection(TreeSet::new));
        System.out.println(resultSet);

        resultSet = givenList.stream().collect(toUnmodifiableSet());
//        resultSet.add("dd"); //UnsupportedOperationException

        // --- toCollection
        result = givenList.stream().collect(toCollection(LinkedList::new));
        System.out.println(result);

        // --- toMap
        Map<String, Integer> resultMap = givenList.stream()
                .collect(toMap(Function.identity(), String::length));
        System.out.println(resultMap);

        //.IllegalStateException - при дубликатах
//        resultMap = listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));

        //выберем любое из этих двух конфликтующих значений
        resultMap = listWithDuplicates.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(resultMap);

        // --- toUnmodifiableMap
        resultMap = givenList.stream()
                .collect(toUnmodifiableMap(Function.identity(), String::length));
//         resultMap.put("foo", 3); //UnsupportedOperationException


        // --- joining
        String resultString = givenList.stream().collect(joining());
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(","));
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(", ", "[", "]"));
        System.out.println(resultString);

        // --- counting
        Long resultLong = givenList.stream().collect(counting());
        System.out.println(resultLong);

        // --- summarizingDouble
        DoubleSummaryStatistics resultStat = givenList.stream()
                .collect(summarizingDouble(String::length));
        System.out.println(resultStat);

        // --- averagingDouble
        Double resultDouble = givenList.stream()
                .collect(averagingDouble(String::length));
        System.out.println(resultDouble);

        // --- summingDouble
        resultDouble = givenList.stream()
                .collect(summingDouble(String::length));
        System.out.println(resultDouble);

        // --- maxBy()/minBy()
        Optional<String> resultOpt = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));
        System.out.println(resultOpt);

        resultOpt = givenList.stream()
                .collect(minBy(Comparator.naturalOrder()));
        System.out.println(resultOpt);

        // --- groupingBy
        Map<Integer, Set<String>> resultMap1 = givenList.stream()
                .collect(groupingBy(String::length, toSet()));
        System.out.println(resultMap1);

        List<String> list = List.of("bb", "ccc", "dd", "aj", "uiu", "aa", "bb");
        Map<Integer, List<String>> resultMap2 = list.stream()
                .collect(groupingBy(String::length, toList()));
        System.out.println(resultMap2);

        // --- partitioningBy
        Map<Boolean, List<String>> resultMap3 = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));
        System.out.println(resultMap3);

        // --- teeing
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        int sum = numbers.stream().collect(teeing(
                minBy(Integer::compareTo), // The first collector
                maxBy(Integer::compareTo), // The second collector
                (min, max) -> min.get()+max.get()// Receives the result from those collectors and combines them
        ));
        System.out.println(sum);

        //("bb", "ccc", "dd", "aj", "uiu", "aa", "bb");
        // == anyMatch
        boolean is = list.stream()
                .anyMatch(x -> x.startsWith("b"));
        System.out.println(is);

        // == allMatch
        is = list.stream()
                .allMatch(x -> x.startsWith("b"));
        System.out.println(is);
    }
}
