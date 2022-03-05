package sr.unasat.retailShop.entities;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "leverancier_id")
    private Long id;
    @Column(name = "leverancier_naam")
    private String leverancierNaam;
    private String leveringshoeveelheid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeverancierNaam() {
        return leverancierNaam;
    }

    public void setLeverancierNaam(String leverancierNaam) {
        this.leverancierNaam = leverancierNaam;
    }

    public String getLeveringshoeveelheid() {
        return leveringshoeveelheid;
    }

    public void setLeveringshoeveelheid(String leveringshoeveelheid) {
        this.leveringshoeveelheid = leveringshoeveelheid;
    }

    @Override
    public String toString() {
        return "Supplier: " +
                "\n id=" + id +
                "\n leverancierNaam='" + leverancierNaam + '\'' +
                "\n leveringshoeveelheid='" + leveringshoeveelheid + "\n";

    }
}
