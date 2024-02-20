package de.telran.hash;

import java.util.*;

public class SimpleHash {
    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<>();
        sets.addAll(Set.of(1,6,4,9,3,7));
        sets.add(21);
        sets.add(19);
        sets.remove(3);
        System.out.println(sets);

        Set<Integer> setsLin = new LinkedHashSet<>(Set.of(1,6,4,9,3,7));
        setsLin.add(2);
        System.out.println(setsLin);

        Map<Integer, String> maps = new HashMap<>();
        maps.put(6, "Вася");
        maps.put(9, "Петя");
        maps.put(22, "Гриша");
        System.out.println(maps);





    }
}
