package Main;
import Tools.MapCoordinates;
import java.util.Scanner;
import UserInterface.MainView;
import data.Blocks.TorchBlock;

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
        mv.display_all();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Inserisci le coordinate del blocco da mettere nell'inventario:");
            MapCoordinates c = new MapCoordinates(sc.nextInt(), sc.nextInt());

            mv.change_cell(c, new TorchBlock());
            mv.display_all();
        }

        /*
        System.out.println("pick-up");
        mv.pick_up_block(c);
        mv.display_all();

        System.out.println("pick-up");
        mv.pick_up_block(c);
        mv.display_all();

        System.out.println("smelt");
        mv.Inventory_to_Furnace(1);
        mv.Furnace_to_Inventory();
        mv.display_all();
        */

    }
}
