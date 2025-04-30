package data.Blocks;
import data.Interfaces.Block;

public abstract class AbstractBlock implements Block {

    // attributi
    protected static final char DEFAULT_BLOCK = '.';
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockname;

    // getter del contenuto
    public char display() {
        return this.contenuto;
    }

    public boolean get_falls_with_gravity() {
        return this.falls_with_gravity;
    }

    public boolean get_fall_through() {
        return this.fall_through;
    }

    @Override
    public String toString() {
        return this.blockname + " ["+this.contenuto+"]";
    }

    @Override
    public String display_in_inventory() {
        return "["+this.contenuto+"]";
    }
}
