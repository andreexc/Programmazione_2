package data.Blocks;

import data.BlockCreator;
import data.Interfaces.SmeltableBlock;
import data.Interfaces.Block;

public class Furnace {

    private SmeltableBlock SmeltableInput;
    private Block SmeltableOutput;

    public Furnace() {
        this.SmeltableInput = BlockCreator.NullBlock();
        this.SmeltableOutput = BlockCreator.NullBlock();
    }

    public void display_on_out() {
        System.out.println("| " + this.SmeltableInput.display() + " --> "
                                + this.SmeltableOutput.display()
                                                                 + " |");
    }

    private void smelt() {
        this.SmeltableOutput = this.SmeltableInput.smelt();
        this.SmeltableInput = BlockCreator.NullBlock();
    }

    public void setInput(SmeltableBlock to_smelt) {
        this.SmeltableInput = to_smelt;
        smelt();
    }

    private void reset_furnace() {
        this.SmeltableInput = BlockCreator.NullBlock();
        this.SmeltableOutput = BlockCreator.NullBlock();
    }

    public Block getSmeltedBlock() {
        Block out = this.SmeltableOutput;
        this.reset_furnace();
        return out;
    }

    public SmeltableBlock get_input() { return this.SmeltableInput; }
}
