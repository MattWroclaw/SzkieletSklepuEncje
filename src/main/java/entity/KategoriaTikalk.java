package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "kategoria_drzewo")
@Data
public  class KategoriaTikalk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String opis;

    @OneToMany
    @OrderColumn
    @JoinColumn(name = "parent_id")
    private List<KategoriaTikalk> children = new LinkedList<KategoriaTikalk>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private KategoriaTikalk parent;

}
