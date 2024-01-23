package de.telran.lambda.reduce;

import java.util.List;
import java.util.stream.Stream;

public class SimpleReduce {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9);
//        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,7,8,9);
        Integer sum = list1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum="+ sum);

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        sum = list1.stream().reduce((p1,p2)->p1+p2).orElse(0);
        System.out.println("Sum="+ sum);
        // p1 op p2 op p3 op ... pN
        int mult = list1.stream().reduce((p1,p2)->p1*p2).orElse(0);
        System.out.println("Mult="+ mult);

        // T reduce(T identity, BinaryOperator<T> accumulator);
        sum = 0;
        for (int el : list1) {
            sum+=el;
        }
        System.out.println("Sum="+ sum);

        // identity op p1 op p2 op p3 op p4.....
        Integer ident = 10;
        sum = list1.stream().reduce(ident, (p1,p2)->p1+p2);
        System.out.println("Sum="+ sum);

        ident = 1;
        mult = list1.stream().reduce(ident, (p1,p2)->p1*p2);
        System.out.println("Mult="+ mult);

        mult = list1.stream().reduce(1, (p1,p2)->p1*p2);
        System.out.println("Mult="+ mult);

        // <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        // нужно использовать только с parallelStream
        sum = list1.stream().reduce(0,
                (p1,p2)->{
                            System.out.println("accumulator = "+p1+"+"+p2);
                            return p1+p2;
                          },
                (s1,s2)-> {
                    System.out.println("combiner = "+s1+"+"+s2);
                    return s1+s2;
                            }
                );
        System.out.println("Sum="+ sum);
        System.out.println();


        sum = list1.parallelStream().reduce(0,
                 (p1,p2)->{
                    System.out.println("accumulator = "+p1+"+"+p2);
                    return p1+p2;
                },
                (s1,s2)-> {
                    System.out.println("combiner = "+s1+"+"+s2);
                    return s1+s2;
                }

        );
        System.out.println("Sum="+ sum);


        /// Работа со сложными объектами
        List<Phone> phones = List.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));

        // такое решение неправильное, надо использовать parallelStream для данного перегруженного метода reduce
       sum = phones.stream().reduce(0,
                (x,y)-> {
                    if(y.getPrice()<50000)
                        return x + y.getPrice();
                    else
                        return x + 0;
                },
                (x, y)->x+y);

        System.out.println(sum); // 117000

        sum = phones.parallelStream().reduce(0,
                (x,y)-> {
                    System.out.println("accumulator = " + x + "+" + y.getPrice());
                    if(y.getPrice()<50000)
                        return x + y.getPrice();

                    else
                        return x + 0;
                },
                (x, y)-> {
                    System.out.println("combiner = "+x+"+"+y);
                    return x+y;
                });

        System.out.println(sum); // 117000


        // такое решение неправильное, надо использовать parallelStream для данного перегруженного метода reduce
        sum = phones.stream().
                mapToInt((x)-> x.getPrice())
                .reduce(0, (x,y)-> x + y);

        System.out.println(sum); // 117000
    }
}
