package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tytul;

    private String opis;


   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "kategoria_id")
//   private Kategoria kategoria;
    private KategoriaTikalk kategoriaTikalk;

   TypProduktu typProduktu;



}
