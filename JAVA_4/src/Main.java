import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {
    public static final Point PointA = new Point(800,800);

    public static final Point PointB = new Point(4000,800);

    public static final Point PointC = new Point(2400,2400);

    public static final int CapFirstSet = 8000;

    public static final int CapSecondSet = 10000;

    public static final int CapThirdSet = 12000;

    public static final int CapResultSet = 30000;

    public static void main(String[] args) {
        try{
            File outputFile = new File("output.txt");
            outputFile.createNewFile();
            BufferedWriter  bw = new BufferedWriter(new FileWriter(outputFile));
            Set<Point> resultPoints = new HashSet<>();
            Set<Point> firstSetPoints = new HashSet<Point>();
            Set<Point> secondSetPoints = new HashSet<Point>();
            Set<Point> thirdSetPoints = new HashSet<Point>();

            while(firstSetPoints.size() != CapFirstSet){
                Point tempPoint = new Point();
                tempPoint = RandomPointA();
                if(tempPoint.distance(PointA) < 400) {
                    firstSetPoints.add(tempPoint);
                }
            }

            while(secondSetPoints.size() != CapSecondSet){
                Point tempPoint = new Point();
                tempPoint = RandomPointB();
                if(tempPoint.distance(PointB) < 500) {
                    secondSetPoints.add(tempPoint);
                }
            }

            while(thirdSetPoints.size() != CapThirdSet){
                Point tempPoint = new Point();
                tempPoint = RandomPointC();
                if(tempPoint.distance(PointC) < 600) {
                    thirdSetPoints.add(tempPoint);
                }
            }

            resultPoints.addAll(firstSetPoints);
            resultPoints.addAll(secondSetPoints);
            resultPoints.addAll(thirdSetPoints);

            for(Point point : resultPoints) {
                bw.write("(" + point.getX() +";" + point.getY() +") " +"\n");
            }
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Point RandomPointA() {
        Random r = new Random();
        int x = r.nextInt(PointA.getX()) + 400;
        int y = r.nextInt(PointA.getY()) + 400;
        return new Point(x, y);
    }

    public static Point RandomPointB() {
        Random r = new Random();
        int x = r.nextInt(PointB.getX()) + 500;
        int y = r.nextInt(PointB.getY()) + 500;
        return new Point(x, y);
    }

    public static Point RandomPointC() {
        Random r = new Random();
        int x = r.nextInt(PointC.getX()) + 600;
        int y = r.nextInt(PointC.getY()) + 600;
        return new Point(x, y);
    }
}
