package exportbill;

import java.util.Date;

public class Sales {
    private int id;
    private Gender gender;
    private Date work_date;
    private String work_shift;

    public Sales(int id, Gender gender, Date work_date, String work_shift) {
        this.id = id;
        this.gender = gender;
        this.work_date = work_date;
        this.work_shift = work_shift;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getWork_date() {
        return work_date;
    }

    public String getWork_shift() {
        return work_shift;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public void setWork_shift(String work_shift) {
        this.work_shift = work_shift;
    }
}
