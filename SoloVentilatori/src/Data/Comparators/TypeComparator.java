package Data.Comparators;

import Data.GUI.StackVentilatore;
import Data.Ventilatori.Ventilatore;

import java.util.Comparator;

public class TypeComparator implements Comparator<StackVentilatore> {

    // ordino secondo l'ordine alfabetico della tipologia dei ventilatori
    // sennò per costo
    @Override
    public int compare(StackVentilatore o1, StackVentilatore o2) {
        int ris_compare = o1.getVentilatore().getTipologia().compareTo(o2.getVentilatore().getTipologia());
        if (ris_compare == 0) {
            return Integer.compare(o1.getVentilatore().getCosto(), o2.getVentilatore().getCosto());
        }
        return ris_compare;
    }
}
