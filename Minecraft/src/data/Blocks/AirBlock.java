package data.Blocks;

public class AirBlock extends AbstractBlock {

    // costruttore di default
    public AirBlock() {
        this.contenuto = DEFAULT_BLOCK;
        this.falls_with_gravity = false;
        this.fall_through = true;
        this.blockname = "Air";
    }
}