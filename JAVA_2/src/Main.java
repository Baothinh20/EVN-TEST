import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        try {
            File outputFile = new File("output.txt");
            outputFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            String line;
            List<String> results = new ArrayList<String>();
            Map<String, Integer> resultCount = new HashMap<String, Integer>();
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
            for (String result : resultCount.keySet()) {
                bw.write(result + "  " + resultCount.get(result).toString() + "\n");
            }
            bw.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}