package data.Blocks;

import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock() {
        super();
        this.contenuto = 'R';
        this.blockname = "Raw Iron";
    }

    @Override
    public Block smelt() {
        // non uso la factory perché voglio che questo sia l'unico
        // modo dove posso ottenere un oggetto IronSwordBlock
        return new IronSwordBlock();
    }
}
