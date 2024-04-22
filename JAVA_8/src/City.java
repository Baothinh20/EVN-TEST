import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public City(int id, String name, int population, String countryCode) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    // public static int comparePoluation(City c1, City c2){return (c1.population < c2.population) ? -1 : ((c1.population == c2.population) ? 0 : 1);}
    public static List<City> mostPopulationCity(List<City> cities){
        return cities.stream().max(Comparator.comparing(City::getPopulation)).stream().collect(Collectors.toList());
    }
}
