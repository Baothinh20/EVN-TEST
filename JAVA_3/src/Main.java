import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        List<String> fileName = new ArrayList<>();
        Stream<Path> paths = Files.walk(Paths.get("E:\\EVN-TEST\\JAVA_3\\input_3"));
        fileName = paths
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .collect(Collectors.toList());
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Callable<Map<String, Integer>> callable;
        Future<Map<String, Integer>> future;

        for (String filepath : fileName){
            callable = new StrCountCallable(filepath);
            future = executor.submit(callable);
            futures.add(future);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        File outputFile = new File("E:\\EVN-TEST\\JAVA_3\\output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        outputFile.createNewFile();
        for (Future<Map<String,Integer>> f : futures){
            int count = 0;
            bw.write(f + "\n");
            for (Map.Entry<String,Integer> entry : f.get().entrySet()){
                if(count < 10){
                    bw.write(entry.getKey() + " : " + entry.getValue() + "\n");
                    count++;
                }
            }
        }
        bw.close();
    }
}