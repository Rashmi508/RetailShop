package sr.unasat.retailShop.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    @Column(name = "address_id")
    private int addressId;
    @Column(name = "straat_naam")
    private String straatNaam;
    @Column
    private int nummer;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    @Column
    private Set<Customer> customers;


    public Address( String straatNaam, int nummer) {
        this.straatNaam = straatNaam;
        this.nummer = nummer;
    }

    public Address() {

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Address: " +
                "\n addressId=" + addressId +
                "\n straatNaam='" + straatNaam  +
                "\n nummer=" + nummer + "\n";

    }
}
