package sr.unasat.retailShop.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "order_datum")
    private LocalDate orderDatum;
    private String verzendingsduur;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDatum() {
        return orderDatum;
    }

    public void setOrderDatum(LocalDate orderDatum) {
        this.orderDatum = orderDatum;
    }

    public String getVerzendingsduur() {
        return verzendingsduur;
    }

    public void setVerzendingsduur(String verzendingsduur) {
        this.verzendingsduur = verzendingsduur;
    }



    @Override
    public String toString() {
        return "Orders: " +
                "\n id=" + id +
                "\n orderDatum=" + orderDatum +
                "\n verzendingsduur='" + verzendingsduur + "\n" ;

    }
}
