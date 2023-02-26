package sr.unasat.retailShop.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "prod_id")
    private Long id;
    @Column(name = "product_naam")
    private String naam;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "groep_id")
    private ProductGroup productGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    @Override
    public String toString() {
        return "Product: " +
                "\n id=" + id +
                "\n naam='" + naam + "\n";

    }
}
