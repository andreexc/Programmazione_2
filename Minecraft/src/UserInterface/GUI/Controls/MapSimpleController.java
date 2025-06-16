package UserInterface.GUI.Controls;

import Tools.MapCoordinates;
import UserInterface.CLI.Map;
import UserInterface.GUI.MapPane;

public class MapSimpleController implements SimpleController {

    private Map map;
    private MapPane mapPane;

    public MapSimpleController(Map map, MapPane mapPane) {
        this.map = map;
        this.mapPane = mapPane;
        redraw();
    }

    @Override
    public void redraw() {
        mapPane.getChildren().clear();

        for (int i = 0; i < MapCoordinates.ROWS; i++) {
            for (int j = 0; j < MapCoordinates.COLS; j++) {
                MapCoordinates coord_cella = new MapCoordinates(i, j);
                mapPane.setCell(coord_cella, map.getblock(coord_cella));
            }
        }
    }
}
