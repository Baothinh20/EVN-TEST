package exportbill;

import java.util.Date;
import java.util.List;

public class Bill {
    private int id;
    private int staffId;
    private int customerID;
    private List merchandise;
    private float total;
    private Date date;

    public Bill(int id, int staffId, int customerID, List merchandise, float total, Date date) {
        this.id = id;
        this.staffId = staffId;
        this.customerID = customerID;
        this.merchandise = merchandise;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public List getMerchandise() {
        return merchandise;
    }

    public float getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setMerchandise(List merchandise) {
        this.merchandise = merchandise;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
