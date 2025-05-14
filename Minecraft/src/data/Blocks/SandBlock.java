package data.Blocks;

import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {

    public SandBlock() {
        super();
        this.pickable = true;
        this.contenuto = 'A';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockname = "Sand";
    }

    @Override
    public Block smelt() {
        // non uso la factory perché voglio che questo sia l'unico
        // modo dove posso ottenere un oggetto GlassBlock
        return new GlassBlock();
    }
}
