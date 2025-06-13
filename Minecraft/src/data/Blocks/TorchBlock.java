package data.Blocks;

public class TorchBlock extends AbstractBlock {

    public TorchBlock() {
        super();
        this.contenuto = 'T';
        this.blockname = "Torch";
        this.fall_through = true;
    }
}
