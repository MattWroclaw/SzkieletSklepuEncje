package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adres")
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
}
