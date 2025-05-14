package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class Inventory {

    Collection<Block> Inventario;

    // L'inventario deve essere vuoto all'inizializzazione
    public Inventory() {
        this.Inventario = new ArrayList();
    }

    // Metodo che stampa ogni oggetto dentro l'inventario
    public void stampaInventario() {
        Iterator<Block> t = Inventario.iterator();
        while (t.hasNext()) {
            System.out.print(t.next() + " ");
        }
    }

    public void add_Block(Block b) {
        this.Inventario.add(b);
    }

    private boolean is_smeltable(int index) {
        if (this.Inventario.size() < index) { throw new IndexOutOfBoundsException(); }

        // Finchè non raggiungo il mio blocco allora passo al prossimo in lista
        Block blocco = null;
        Iterator<Block> t = Inventario.iterator();
        for (; index >= 1; index--) {
            blocco = t.next();
        }
        // qui sono obbligato a usare instanceof (?)
        return blocco instanceof SmeltableBlock;
    }

    public SmeltableBlock get_smeltable_item(int index) {
        if (! this.is_smeltable(index)) { return BlockCreator.NullBlock(); }
        Block blocco = null;
        Iterator<Block> t = Inventario.iterator();
        for (; index >= 1; index--) {
            blocco = t.next();
        }
        // alla fine lo sposto definitivamente dall'inventario quindi rimuovo
        Inventario.remove(index);

        return (SmeltableBlock) blocco; // Faccio il cast perché SONO SICURO che il blocco in indice
                                        // index è in realtà uno SmeltableBlock
    }
}
