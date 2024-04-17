package exportbill;

import java.util.Date;

public class ImportStaff {
    private int id;
    private Gender gender;
    private Date work_date;
    private int seniority;

    public ImportStaff(int id, Gender gender, Date work_date, int seniority) {
        this.id = id;
        this.gender = gender;
        this.work_date = work_date;
        this.seniority = seniority;
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

    public int getSeniority() {
        return seniority;
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

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }
}
