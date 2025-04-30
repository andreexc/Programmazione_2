package data;

import data.Blocks.*;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

import java.util.Random;

public abstract class BlockCreator {

    private static final int BlocksUpperBound = 2;
    public static Block getRandomBlock() {
        int seed = new Random().nextInt(BlocksUpperBound);
        switch (seed) {
            case 0:
                return new SandBlock();
            case 1:
                return RawIronBlock();
            default:
                return defaultBlock();
        }
    }

    public static Block defaultBlock() {
        return new AirBlock();
    }

    public static SmeltableBlock SandBlock() {
        return new SandBlock();
    }

    public static Block WaterBlock() {
        return new WaterBlock();
    }

    public static SmeltableBlock NullBlock() {
        return new NullBlock();
    }

    public static Block AirBlock() {
        return new AirBlock();
    }

    public static Block GlassBlock() { return new GlassBlock(); }

    public static SmeltableBlock RawIronBlock() { return new RawIronBlock(); }

    // public static Block IronSwordBlock() { return new IronSwordBlock(); }

}
