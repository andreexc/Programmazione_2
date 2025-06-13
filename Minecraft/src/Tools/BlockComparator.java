package Tools;

import data.Blocks.*;
import data.Interfaces.Block;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {


    @Override
    public int compare(Block o1, Block o2) {
        return Integer.compare(this.get_value_of_block(o1), this.get_value_of_block(o2));
    }

    public int get_value_of_block(Block b) {
        if (b instanceof NullBlock) {
            return 0;
        }
        else if (b instanceof AirBlock) {
            return 1;
        }
        else if (b instanceof WaterBlock) {
            return 2;
        }
        else if (b instanceof SandBlock) {
            return 4;
        }
        else if (b instanceof GlassBlock) {
            return 5;
        }
        else if (b instanceof RawIronBlock) {
            return 6;
        }
        else if (b instanceof IronSwordBlock) {
            return 7;
        }
        return 100;
    }

}
