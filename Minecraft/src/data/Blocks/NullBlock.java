package data.Blocks;

import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {

    public NullBlock() {
        super();
        this.contenuto = 'N';
        this.blockname = "NULL";
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
