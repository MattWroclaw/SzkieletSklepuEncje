package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "uzytkownik")
@NoArgsConstructor
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String loginMail;

    private String haslo;

    private String role;

    private String miasto;


    public Uzytkownik(String loginMail, String haslo, String role, String miasto) {
        this.loginMail = loginMail;
        this.haslo = haslo;
        this.role = role;
        this.miasto = miasto;
    }
}
