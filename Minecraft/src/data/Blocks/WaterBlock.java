package data.Blocks;

public class WaterBlock extends AbstractBlock {

    public WaterBlock() {
        super();
        this.contenuto = 'W';
        this.falls_with_gravity = true;
        this.fall_through = true;
        this.blockname = "Water";
    }
}
