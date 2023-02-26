package sr.unasat.retailShop.entities;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int delId;
    @Column(name = "product_title")
    private String productTitle;
    @Column
    private String price;

    public Delivery(int delId, String productTitle, String price) {
        this.delId = delId;
        this.productTitle = productTitle;
        this.price = price;
    }

    public Delivery(){}

    public int getDel_id() {
        return delId;
    }

    public void setDel_id(int del_id) {
        this.delId = delId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delId=" + delId +
                ", productTitle='" + productTitle + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
