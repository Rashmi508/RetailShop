package sr.unasat.retailShop.entities;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String address;
    @Column
    private int number;

    public Orders(int orderId, String firstname, String lastname, String address, int number) {
        this.orderId = orderId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.number = number;
    }

    public Orders(){}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
