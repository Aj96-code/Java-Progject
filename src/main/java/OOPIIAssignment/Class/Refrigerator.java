package OOPIIAssignment.Class;

import java.io.Serializable;
import java.util.Date;

public class Refrigerator implements Serializable {
    private int RefrigeratorId;
    private String Brand;
    private String Model;
    private Date ManufactureDate;
    private float Price;
    private int Quantity;

    public Refrigerator(int refrigeratorId, String brand, String model,
                        Date manufactureDate, float price, int quantity) {
        RefrigeratorId = refrigeratorId;
        Brand = brand;
        Model = model;
        ManufactureDate = manufactureDate;
        Price = price;
        Quantity = quantity;
    }

    public int getRefrigeratorId() {
        return RefrigeratorId;
    }

    public void setRefrigeratorId(int refrigeratorId) {
        RefrigeratorId = refrigeratorId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Date getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        ManufactureDate = manufactureDate;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "RefrigeratorId=" + RefrigeratorId +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", ManufactureDate=" + ManufactureDate +
                ", Price=" + Price +
                ", Quantity=" + Quantity +
                '}';
    }
}
