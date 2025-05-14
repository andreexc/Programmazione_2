import Lez8_Collections.*;
import Lez9_eq_cp.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*

        GiocoRamino.Gioca();
        StampaDadi.StampaCombinazioniDadi();

        Set<Element> s = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            s.add(new Element(r.nextInt(101)+1));
        }

        System.out.println("Contenuto del hashSet (value=>hashCode):");
        // scelgo di usare in modo esplicito gli iteratori per
        // prendere confidenza
        // si potevo anche usare la funzione toArray()
        Iterator<Element> i = s.iterator();
        System.out.print("[ ");
        while (i.hasNext()) {
            Element elem = i.next();
            System.out.print(elem.toString() + "=>" + elem.hashCode() + " ");
        }
        System.out.println("]");


        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un elemento da cercare: ");
        Element wanted = new Element(sc.nextInt());

        System.out.println("Cerchiamo l'elemento (tramite hashCode): " + wanted.toString() + "=>" + wanted.hashCode());

        if (s.contains(wanted)) {
            System.out.println("Elemento trovato.");
        }
        else {
            System.out.println("Elemento non trovato.");
        }

        System.out.println("Ora testiamo il nostro equals.");
        System.out.println("Insesci i valori del primo e secondo elemento:");
        Element elem1 = new Element(sc.nextInt());
        Element elem2 = new Element(sc.nextInt());
        if (elem1.equals(elem2)) {
            System.out.println("I due elementi sono uguali");
        }
        else {
            System.out.println("I due elementi sono differenti");
        }

        */

        List<NamedPoint> l = new ArrayList<>();
        NamedPoint p1 = new NamedPoint("C", 3, 5);
        NamedPoint p2 = new NamedPoint("A", -4, 13);
        NamedPoint p3 = new NamedPoint("A", -4, 5);
        l.add(p1); l.add(p2); l.add(p3);

        System.out.println("Unsorted: " + l);
        Collections.sort(l);
        System.out.println("Sorted by natural order (compareTo from NamedPoint class):");
        System.out.println(l);

        Collections.sort(l, new NamedPointComparator());
        System.out.println("Sorted by natural order (compareTo from NamedPoint class):");
        System.out.println(l);
    }
}