package Tools;

import data.Interfaces.Block;
import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block o1, Block o2) {
        // comparo in ordine alfabetico (ordine naturale della classe String)
        return o1.toString().compareTo(o2.toString());
    }
}
