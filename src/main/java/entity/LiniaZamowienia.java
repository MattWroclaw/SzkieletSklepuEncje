package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "linia_zamowienia")
@NoArgsConstructor
public class LiniaZamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_produktu")
    private Produkt produkt;

    private int liczbaPoduktow;

    private double cenaProduktu;

    public LiniaZamowienia(Produkt produkt, int liczbaPoduktow, double cenaProduktu) {
        this.produkt = produkt;
        this.liczbaPoduktow = liczbaPoduktow;
        this.cenaProduktu = cenaProduktu;
    }
}
