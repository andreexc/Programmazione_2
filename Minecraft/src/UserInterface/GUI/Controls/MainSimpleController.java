package UserInterface.GUI.Controls;

import Tools.MapCoordinates;
import UserInterface.CLI.MainView;
import UserInterface.GUI.FurnacePane;
import UserInterface.GUI.InventoryPane;
import UserInterface.GUI.MainGui;
import UserInterface.GUI.MapPane;

import javax.naming.ldap.Control;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class MainSimpleController implements SimpleController {

    private MainView mainView;
    private MainGui mainGui;

    private Collection<SimpleController> ControllerCollection;

    public MainSimpleController(MainView mainView) {
        this.mainView = mainView;
        this.mainGui = new MainGui(this);
        ControllerCollection = new ArrayList<SimpleController>();

        MapSimpleController mapSimpleController = new MapSimpleController(mainView.getMap(), (MapPane) mainGui.getCenter());
        InventorySimpleController inventorySimpleController = new InventorySimpleController(mainView.getInventario(), (InventoryPane) mainGui.getBottom());
        FurnaceSimpleController furnaceSimpleController = new FurnaceSimpleController(mainView.getFornace(), (FurnacePane) mainGui.getRight());

        ControllerCollection.add(mapSimpleController);
        ControllerCollection.add(inventorySimpleController);
        ControllerCollection.add(furnaceSimpleController);
    }

    public void redraw() {
        for (SimpleController controller : ControllerCollection) {
            controller.redraw();
        }
    }

    public void smelt() {
        this.mainView.getFornace().smelt();
        this.redraw();
    }

    public void move_into_inventory_from_furnace() {
        this.mainView.Furnace_to_Inventory();
        mainView.display_inventory();
        this.redraw();
    }

    public void move_into_furnace_from_inventory(int slot) {
        this.mainView.Inventory_to_Furnace(slot);
        this.redraw();
    }

    public void pick_up_block(MapCoordinates c) {
        this.mainView.pick_up_block(c);
        this.redraw();
    }

    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
        this.redraw();
    }

    public MainGui getMainGui() {
        return mainGui;
    }

}
