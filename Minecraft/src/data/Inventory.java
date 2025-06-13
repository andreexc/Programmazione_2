package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import Tools.AlphabeticalBlockComparator;
import Tools.BlockComparator;
import data.Exceptions.BlockErrorException;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class Inventory {

    Collection<Block> Inventario;
    Comparator<Block> comparator;

    // L'inventario deve essere vuoto all'inizializzazione
    public Inventory() {
        this.Inventario = new ArrayList<>();
        this.comparator = new AlphabeticalBlockComparator();
    }

    // Metodo che stampa ogni oggetto dentro l'inventario
    public void stampaInventario() {
        System.out.println("stampa inventario");
        Iterator<Block> t = Inventario.iterator();
        while (t.hasNext()) {
            System.out.print(t.next() + " ");
        }
    }

    public void add_Block(Block b) {
        this.Inventario.add(b);
        this.ordinaInventario();
    }

    private boolean is_smeltable(int index) throws IndexOutOfBoundsException {
        if (this.Inventario.size() < index) { throw new IndexOutOfBoundsException(); }

        // Finché non raggiungo il mio blocco allora passo al prossimo in lista
        Block blocco = null;
        for (Iterator<Block> t = Inventario.iterator(); index >= 1 && t.hasNext(); index--) {
            blocco = t.next();
        }
        // qui sono obbligato a usare instanceof (?)
        return blocco instanceof SmeltableBlock;
    }

    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException {
        if (! this.is_smeltable(index)) { throw new BlockErrorException(); }
        Block blocco = null;
        Iterator<Block> t = Inventario.iterator();
        for (; index >= 1; index--) {
            blocco = t.next();
        }
        // alla fine lo sposto definitivamente dall'inventario quindi rimuovo
        Inventario.remove(blocco);

        return (SmeltableBlock) blocco; // Faccio il cast perché SONO SICURO che il blocco è in realtà uno SmeltableBlock
    }

    private void ordinaInventario() {
        ((ArrayList<Block>)this.Inventario).sort(this.comparator);
    }

    public void toggleComparator() {
        if (this.comparator instanceof AlphabeticalBlockComparator) {
            this.comparator = new BlockComparator();
        }
        else if (this.comparator instanceof BlockComparator) {
            this.comparator = new AlphabeticalBlockComparator();
        }
    }
}
