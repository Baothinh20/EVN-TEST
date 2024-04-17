package exportbill;

public class Customer {
    private int id;
    private Gender gender;
    private int age;

    public Customer(int id, Gender gender, int age) {
        this.id = id;
        this.gender = gender;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
