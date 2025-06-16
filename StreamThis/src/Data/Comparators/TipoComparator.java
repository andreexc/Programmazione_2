package Data.Comparators;

import Data.GUI.TitoloPane;

import java.util.Comparator;

public class TipoComparator implements Comparator<TitoloPane> {
    @Override
    public int compare(TitoloPane o1, TitoloPane o2) {
        int ris = o1.getTitolo().getTipologia().compareTo(o2.getTitolo().getTipologia());
        if (ris == 0) {
            return new NomeComparator().compare(o1, o2);
        }
        return ris;
    }
}
