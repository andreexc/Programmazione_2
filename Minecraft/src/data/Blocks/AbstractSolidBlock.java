package data.Blocks;

import data.Interfaces.Block;

public abstract class AbstractSolidBlock extends AbstractBlock {

    public AbstractSolidBlock() {
        super();
        this.pickable = true;
        this.falls_with_gravity = false;
        this.fall_through = false;
    }
}
