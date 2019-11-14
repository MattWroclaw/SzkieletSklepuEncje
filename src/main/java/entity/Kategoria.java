package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "kategoria_drzewo")
@Data
@NoArgsConstructor
public  class Kategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String opis;

    @OneToMany
    @OrderColumn
    @JoinColumn(name = "parent_id")
    private List<Kategoria> children = new LinkedList<Kategoria>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Kategoria parent;

}
