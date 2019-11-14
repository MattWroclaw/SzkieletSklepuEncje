package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "zamowienie")
@NoArgsConstructor
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    private double cenaTotal;

    @OneToOne
    @JoinColumn(name = "adres_dostawy")
    private Adres adres;

    private LocalDate dataZlozenia;

    @OneToOne
    @JoinColumn(name = "koszyk_id")
    private Koszyk koszyk;

    private StatusZamowienia statusZamowienia;

    public Zamowienie(Uzytkownik uzytkownik, double cenaTotal, Adres adres, LocalDate dataZlozenia, Koszyk koszyk, StatusZamowienia statusZamowienia) {
        this.uzytkownik = uzytkownik;
        this.cenaTotal = cenaTotal;
        this.adres = adres;
        this.dataZlozenia = dataZlozenia;
        this.koszyk = koszyk;
        this.statusZamowienia = statusZamowienia;
    }
}
