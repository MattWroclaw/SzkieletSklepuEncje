package entity;

import lombok.Data;

@Data
public class ListaZamowienia {


    private Produkt produkt;

    private int liczbaPoduktow;

    private int cenaProduktu;
}
