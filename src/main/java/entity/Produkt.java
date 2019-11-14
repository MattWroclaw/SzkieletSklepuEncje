package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produkt")
@NoArgsConstructor
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tytul;

    private String opis;

   String urlObrazka;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "kategoria_id")
//   private Kategoria kategoria;
   private Kategoria kategoria;

   private double cena;

   private TypProduktu typProduktu;

    public Produkt(String tytul, String opis, String urlObrazka, Kategoria kategoria, double cena, TypProduktu typProduktu) {
        this.tytul = tytul;
        this.opis = opis;
        this.urlObrazka = urlObrazka;
        this.kategoria = kategoria;
        this.cena = cena;
        this.typProduktu = typProduktu;
    }
}
