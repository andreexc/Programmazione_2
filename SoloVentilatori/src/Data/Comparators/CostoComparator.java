package Data.Comparators;

import Data.GUI.StackVentilatore;
import Data.Ventilatori.Ventilatore;

import java.util.Comparator;

public class CostoComparator implements Comparator<StackVentilatore> {

    // comparo per costo sennò per tipologia
    @Override
    public int compare(StackVentilatore o1, StackVentilatore o2) {
        int ris_compare = Integer.compare(o1.getVentilatore().getCosto(), o2.getVentilatore().getCosto());
        if (ris_compare == 0) {
            return o1.getVentilatore().getTipologia().compareTo(o2.getVentilatore().getTipologia());
        }
        return ris_compare * -1;
    }

}
