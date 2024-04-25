import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader brCity = new BufferedReader(new FileReader("cities.dat"));
            BufferedReader brCountry = new BufferedReader(new FileReader("countries.dat"));
            String line;
            List<City> cities = new ArrayList<City>();
            List<Country> countries = new ArrayList<Country>();
            while ((line = brCity.readLine()) != null){
                Pattern p = Pattern.compile("((?<==)[\\w.-]+).*((?<==)[\\w.-¯\\s]+).*((?<==)[\\w.-]+).*((?<==)[\\w.-]+)");
                Matcher m = p.matcher(line);
                if (m.find()){
                    cities.add(new City(Integer.parseInt(m.group(1)), m.group(2), Integer.parseInt(m.group(3)), m.group(4)));
                }
            }

            while ((line = brCountry.readLine()) != null){
                Pattern p = Pattern.compile("((?<==)[\\w.-]+).*((?<==)[\\w.-¯\\s]+).*((?<==)[\\w.-]+).*((?<==)[\\w.-]+).*((?<==)[\\w.-]+).*((?<==)[\\w.-]+).*((?<==)[\\w.-]+)");
                Matcher m = p.matcher(line);
                if (m.find()){
                    countries.add(new Country(m.group(1), m.group(2), m.group(3), Double.parseDouble(m.group(4)), Integer.parseInt(m.group(5)), Double.parseDouble(m.group(6)), Integer.parseInt(m.group(7))));
                }
            }
            // mot so phong chu bi loi khi doc file
            // Q1 tp va quoc gia
            // System.out.println(City.mostPopulationCity(cities).get(0).getName());
            List<Country> countriesResult = Country.mostPopulationCountry(countries);
            System.out.println(countriesResult.get(0).getName());

            // Q2
            // Create better City Info
            List<CityExtend> cityExtendList = new ArrayList<CityExtend>();
            for(City city : cities){
                for(Country country : countries){
                    if(country.getCode().equals(city.getCountryCode())){
                        if(country.getCapital() == city.getId()){
                            cityExtendList.add(new CityExtend(city.getId(), city.getName(), city.getPopulation(), city.getCountryCode(), country.getName(), country.getContinent(), true));
                        } else {
                            cityExtendList.add(new CityExtend(city.getId(), city.getName(), city.getPopulation(), city.getCountryCode(), country.getName(), country.getContinent(), false));
                        }
                    }
                }
            }
            Map<String,List<CityExtend>> cityByContinent = mostPopulationCityPerContinent(cityExtendList);

            // Q3
            List<CityExtend> cityExtendListResult1 = cityExtendList
                    .stream()
                    .sorted(Comparator.comparing(CityExtend::getPopulation).reversed())
                    .filter(c -> c.isCapital() == true)
                    .max(Comparator.comparing(CityExtend::getPopulation)
                    )
                    .stream().collect(Collectors.toList());

            // Q4
            Map<String,List<CityExtend>> capitalByContinent = mostPopulationCapitalPerContinent(cityExtendList);

            // Q5
            Map<String,List<CityExtend>> sortContryByCity = sortCityCountryASC(cityExtendList);

            // Q6
            // da chinh sua du lieu country
            List<Country> countriesResult2 = countries
                    .stream()
                    .filter(c -> c.getPopulation() != 0)
                    .sorted(Comparator.comparing(Country::getPopulationPerSufaceArea).reversed()).collect(Collectors.toList());

            brCity.close();
            brCountry.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<CityExtend> sortPopulationCityExtendASC(List<CityExtend> cityExtendList){
        return cityExtendList.stream().sorted(Comparator.comparing(CityExtend::getContinent)).sorted(Comparator.comparing(CityExtend::getPopulation).reversed()).collect(Collectors.toList());
    }

    public static Map<String,List<CityExtend>> mostPopulationCityPerContinent(List<CityExtend> cityExtendList){
        cityExtendList = sortPopulationCityExtendASC(cityExtendList);
        Map<String,List<CityExtend>> cityByContinent = new HashMap<String, List<CityExtend>>();
        return cityByContinent = cityExtendList.stream()
                .collect(Collectors.groupingBy(
                        CityExtend::getContinent, // Group by continent
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                l -> l.stream().limit(1).collect(Collectors.toList())
                        )
                ));
    }

    public static Map<String,List<CityExtend>> mostPopulationCapitalPerContinent(List<CityExtend> cityExtendList){
        cityExtendList = sortPopulationCityExtendASC(cityExtendList);
        Map<String,List<CityExtend>> cityByContinent = new HashMap<String, List<CityExtend>>();
        return cityByContinent = cityExtendList.stream().filter(c -> c.isCapital() == true)
                .collect(Collectors.groupingBy(
                        CityExtend::getContinent, // Group by continent
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                l -> l.stream().limit(1).collect(Collectors.toList())
                        )
                ));
    }

    public static Map<String,List<CityExtend>> sortCityCountryASC(List<CityExtend> cityExtendList){
        cityExtendList = sortPopulationCityExtendASC(cityExtendList);
        Map<String,List<CityExtend>> cityByContinent = new HashMap<String, List<CityExtend>>();
        return cityByContinent = cityExtendList.stream()
                .collect(Collectors.groupingBy(
                        CityExtend::getCountryCode, // Group by continent
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                l -> l.stream().collect(Collectors.toList())
                        )
                ));
    }
}