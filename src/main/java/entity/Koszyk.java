package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "koszyk")
@NoArgsConstructor
public class Koszyk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    @OneToMany
    @JoinColumn(name = "liniaZamowienia_id")
    private List<LiniaZamowienia> linieZamowienia;

    public Koszyk(Uzytkownik uzytkownik, List<LiniaZamowienia> linieZamowienia) {
        this.uzytkownik = uzytkownik;
        this.linieZamowienia = linieZamowienia;
    }
}
