package Data.Comparators;

import Data.GUI.TitoloPane;

import java.util.Comparator;

public class NomeComparator implements Comparator<TitoloPane> {
    @Override
    public int compare(TitoloPane o1, TitoloPane o2) {
        return o1.getTitolo().getNome().compareTo(o2.getTitolo().getNome());
    }
}
