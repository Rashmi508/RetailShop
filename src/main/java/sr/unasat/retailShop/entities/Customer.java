package sr.unasat.retailShop.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    private String voornaam;
    private String achternaam;
    private LocalDate bestelling;

    @Column(name = "telefoon_nummer", unique = true)
    private String telefoonNummer;
    @Column(name = "email_adres")
    private String emailAdres;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(String voornaam, String achternaam, String telefoonNummer, String emailAdres, LocalDate bestelling) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.telefoonNummer = telefoonNummer;
        this.emailAdres = emailAdres;
        this.bestelling = bestelling;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBestelling() {
        return bestelling;
    }

    public void setBestelling(LocalDate bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "\n id=" + id  +
                "\n voornaam='" + voornaam   +
                "\n achternaam='" + achternaam   +
                "\n telefoonNummer='" + telefoonNummer   +
                "\n bestelling='" + bestelling +
                "\n emailAdres='" + emailAdres  + "\n" +
                "\n address='" + address + "\n";
    }
}
