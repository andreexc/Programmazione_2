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

    public void smelt() {
        System.out.println("SMEEELTTTT");
        System.out.println(this.SmeltableInput.toString());
        if (!this.SmeltableInput.isNull()) {
            System.out.println("OOOOO");
            this.SmeltableOutput = this.SmeltableInput.smelt();
            //this.SmeltableInput = BlockCreator.NullBlock();
        }
    }

    public void setInput(SmeltableBlock to_smelt) {
        this.SmeltableInput = to_smelt;
        System.out.println(to_smelt.toString());
        System.out.println(this.SmeltableInput.toString());
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
