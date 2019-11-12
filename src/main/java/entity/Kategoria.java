package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kategoria")
public class Kategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazwa;

    private long idRodzica;

    private long idDziecka;
}
