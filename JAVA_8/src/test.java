import java.util.*;
import java.util.stream.Collectors;
// group by 2 item list
public  class test {
    public static void test() {
        List<String> items = Arrays.asList(
                "apple", "banana", "orange",
                "grape", "apple", "banana",
                "apple", "orange", "orange"
        );

        // Grouping by item and limiting to 2 elements per group
        Map<String, List<String>> limitedGroups = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item, // Group by item
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().limit(2).collect(Collectors.toList())
                        )
                ));

        // Print the limited groups
        limitedGroups.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
//Map<String, List<MyObject>> limitedGroups = objects.stream()
//        .collect(Collectors.groupingBy(
//                MyObject::getCategory, // Group by category
//                Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        list -> list.stream().limit(2).collect(Collectors.toList())
//                )
//        ));
