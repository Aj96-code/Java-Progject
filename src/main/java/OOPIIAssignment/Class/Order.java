package OOPIIAssignment.Class;

import java.io.Serializable;

public class Order implements Serializable {
    private int Id;
    private String CustomerName;
    private int ProductId;
    private String ProductBrand;
    private String ProductModel;
    private float ProductPrice;
    private int Quantity;

    public Order(int id, String customerName, int productId, String productBrand,
                 String productModel, float productPrice, int quantity) {
        Id = id;
        CustomerName = customerName;
        ProductId = productId;
        ProductBrand = productBrand;
        ProductModel = productModel;
        ProductPrice = productPrice;
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(String productBrand) {
        ProductBrand = productBrand;
    }

    public String getProductModel() {
        return ProductModel;
    }

    public void setProductModel(String productModel) {
        ProductModel = productModel;
    }

    public float getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(float productPrice) {
        ProductPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", CustomerName='" + CustomerName + '\'' +
                ", ProductId=" + ProductId +
                ", ProductBrand='" + ProductBrand + '\'' +
                ", ProductModel='" + ProductModel + '\'' +
                ", ProductPrice=" + ProductPrice +
                ", Quantity=" + Quantity +
                '}';
    }
}
