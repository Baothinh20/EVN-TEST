public class CityExtend {
    private int id;
    private String cityName;
    private int population;
    private String countryCode;
    private String countryName;
    private String continent;
    private boolean isCapital;

    public CityExtend(int id, String cityName, int population, String countryCode, String countryName, String continent, boolean isCapital) {
        this.id = id;
        this.cityName = cityName;
        this.population = population;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.isCapital = isCapital;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getContinent() {
        return continent;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setIsCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }
}
