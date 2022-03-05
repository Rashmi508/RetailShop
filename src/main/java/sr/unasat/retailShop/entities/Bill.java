package sr.unasat.retailShop.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "bon_id")
    private Long id;
    @Column(name = "bon_datum")
    private LocalDate bonDatum;
    @Column(name = "betaald_bedrag")
    private String betaaldBedrag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBonDatum() {
        return bonDatum;
    }

    public void setBonDatum(LocalDate bonDatum) {
        this.bonDatum = bonDatum;
    }

    public String getBetaaldBedrag() {
        return betaaldBedrag;
    }

    public void setBetaaldBedrag(String betaaldBedrag) {
        this.betaaldBedrag = betaaldBedrag;
    }

    public Bill(LocalDate bonDatum, String betaaldBedrag) {
        this.bonDatum = bonDatum;
        this.betaaldBedrag = betaaldBedrag;
    }

    public Bill() {}

    @Override
    public String toString() {
        return "Bill: " +
                "\n id=" + id +
                "\n bonDatum=" + bonDatum +
                "\n betaaldBedrag=" + betaaldBedrag + "\n";

    }
}
