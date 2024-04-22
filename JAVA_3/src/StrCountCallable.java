import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrCountCallable implements Callable<Map<String, Integer>> {
    private String inputFile;

    public StrCountCallable(String inputFile) {
        this.inputFile = inputFile;
    }

    public Map<String, Integer> call() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        List<String> results = new ArrayList<String>();
        Map<String, Integer> resultCount = new TreeMap<String, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " .,!=+-”");
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                results.add(st.nextToken());
            }
        }
        for (String result : results) {
            if(resultCount.containsKey(result)){
                resultCount.put(result, resultCount.get(result)+1);
            } else{
                resultCount.put(result, 1);
            }
        }
        resultCount = resultCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        br.close();
        return resultCount;
    }
}
