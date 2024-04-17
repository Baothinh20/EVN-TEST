package exportbill;

public class Merchandise {
    private int id;
    private String name;
    private String catagory;
    private float price;

    public Merchandise(int id, String name, String catagory, float price) {
        this.id = id;
        this.name = name;
        this.catagory = catagory;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() {
        return catagory;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
