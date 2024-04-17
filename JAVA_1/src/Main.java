
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.random;
// 5% số phần tử giao nhau
public class Main {
    public static void main(String[] args) {
        int N = 2000000;
        int I = 10000;
        long startTime = System.currentTimeMillis();
        Set<Integer> set1 = new Random().ints()
                .distinct()
                .limit(N)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> set2 = new Random().ints()
                .distinct()
                .limit( N-I)
                .boxed()
                .collect(Collectors.toSet());
        int count = 0;
        for(Integer s : set1){
            if(set2.size() == N){
                break;
            }
            set2.add(s);
            count++;
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        System.out.println("\n");
        System.out.println(runTime);
    }
}