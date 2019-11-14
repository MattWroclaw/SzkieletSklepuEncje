package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adres")
@NoArgsConstructor

public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String panstwo;

    private String miasto;

    private String ulica;

    private String kodPocztowy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    public Adres(String panstwo, String miasto, String ulica, String kodPocztowy, Uzytkownik uzytkownik) {
        this.panstwo = panstwo;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.uzytkownik = uzytkownik;
    }
}
