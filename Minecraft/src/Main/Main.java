package Main;
import Tools.MapCoordinates;
import java.util.Scanner;
import UserInterface.MainView;

public class Main{

    private static final int INTERACTIONS = 100;

    /*
    private static void changeWithCoord() {
        Map m = new Map();
        Scanner in = new Scanner(System.in);

        m.display_on_out();
        for (int i = 0; i < INTERACTIONS; i++) {
            System.out.print("Enter row: ");
            int row = in.nextInt();

            System.out.print("Enter col: ");
            int col = in.nextInt();

            System.out.println("Changing: " + row + " - " + col);

            m.change_cell(new MapCoordinates(row, col), new SandBlock() );
            m.display_on_out();
        }
    }
    */

    public static void main(String[] args) {

        MainView mv = new MainView();
        mv.display_map();
        mv.display_furnace();

        System.out.println("Inserisci coordinate da smeltare");
        Scanner sc = new Scanner(System.in);
        MapCoordinates c = new MapCoordinates(sc.nextInt(), sc.nextInt());
        mv.move_into_furnace(c);

        mv.display_map();
        mv.display_furnace();

    }
}
