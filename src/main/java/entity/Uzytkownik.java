package entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "uzytkownik")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String loginMail;

    private String haslo;

    private String role;

    private String miasto;


}
