package UserInterface.CLI;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Blocks.SandBlock;
import data.Blocks.TorchBlock;
import data.Exceptions.BlockErrorException;
import data.Exceptions.WrongCoordinatesException;
import data.Interfaces.Block;
import java.util.Random;

public class Map {

    // attributi
    private Block[][] mappa;
    private static final int BLOCCHI_DA_AGGIUNGERE = MapCoordinates.ROWS * MapCoordinates.COLS / 5;

    // costruttore di default, inizializza
    // la mappa con blocchi default
    public Map() {
        // inizializzo prima la matrice
        mappa = new Block[MapCoordinates.ROWS][MapCoordinates.COLS];

        // ora inizializzo ogni blocco della mappa
        for (int r = 0; r < MapCoordinates.ROWS; r++) {
            for (int c = 0; c < MapCoordinates.COLS; c++) {
                // generazione vuota
                this.mappa[r][c] = BlockCreator.defaultBlock();
            }
        }

        this.addRiver();
        this.add_randomBlocks();

        // applico la gravità su tutta la mappa
        for (int r = MapCoordinates.ROWS - 2; r >= 0; r--) {
            for (int c = 0; c < MapCoordinates.COLS; c++) {
                if (mappa[r][c].get_falls_with_gravity()) {
                    applyGravity(new MapCoordinates(r, c));
                }
            }
        }
    }

    // metodo che stampa a video la mappa
    public void display_on_out() {
        for (int r = 0; r < MapCoordinates.ROWS; r++) {
            for (int c = 0; c < MapCoordinates.COLS; c++) {
                System.out.print(this.mappa[r][c].display() + " ");
            }
            System.out.println();
        }
    }

    // DEBUG
    public Block getblock(MapCoordinates coord) {
        return this.mappa[coord.getX()][coord.getY()];
    }

    // metodo che mi permette di cambiare un determinato
    // blocco con un altro
    public void change_cell(MapCoordinates c, Block newBlock) throws WrongCoordinatesException {
        // controllo che le coordinate siano valide
        if (!c.isInbound()) {
            throw new WrongCoordinatesException();
        }

        // faccio puntare al nuovo blocco
        // (al vecchio ci penserà il garbage collector)
        this.mappa[c.getX()][c.getY()] = newBlock;

        //applico la gravità su tutta la colonna soprastante
        for (int r = c.getX(); r >= 0; r--) {
            applyGravity(new MapCoordinates(r, c.getY()));
        }
    }

    private void applyGravity(MapCoordinates c) {
        //applyGravityIter(c);
        applyGravityRec(c);
    }

    private void applyGravityRec(MapCoordinates c) {
        if (!c.isInbound()) return;

        int x = c.getX();
        int y = c.getY();

        // sanity check
        if (x + 1 >= MapCoordinates.ROWS) return;

        if (!this.mappa[x][y].get_falls_with_gravity()) return;
        if (!this.mappa[x+1][y].get_fall_through()) return;
        swap(c);
        applyGravityRec(new MapCoordinates(x+1, y));
    }

    private void swap(MapCoordinates c) {
        if (!c.isInbound()) return;

        int x = c.getX();
        int y = c.getY();
        if (this.mappa[x+1][y] instanceof TorchBlock) {
            if (this.mappa[x][y] instanceof SandBlock) {
                this.mappa[x][y] = BlockCreator.defaultBlock();
            }
        }
        else {
            Block tmp = this.mappa[x][y];
            this.mappa[x][y] = this.mappa[x+1][y];
            this.mappa[x+1][y] = tmp;
        }
    }

    private void addRiver() {
        addRowsOfWater(1);
    }

    private void addSea() {
        addRowsOfWater(3);
    }

    private void addRowsOfWater(int strati) {
        for (int i = 0; i < strati; i++) {
            for (int c = 0; c < MapCoordinates.COLS; c++) {
                change_cell(new MapCoordinates(0, c), BlockCreator.WaterBlock());
            }
        }
    }

    private void add_randomBlocks() {
        Random rnd = new Random();
        for (int i = 0; i < BLOCCHI_DA_AGGIUNGERE; i++) {
            int r = rnd.nextInt(MapCoordinates.ROWS);
            int c = rnd.nextInt(MapCoordinates.COLS);
            change_cell(new MapCoordinates(r, c), BlockCreator.getRandomBlock());
        }
    }

    private boolean is_pickable(MapCoordinates c) throws WrongCoordinatesException {
        if (!c.isInbound()) throw new WrongCoordinatesException();
        if (mappa[c.getX()][c.getY()].is_pickable()) return true;
        return false;
    }

    public Block gimme_pickable(MapCoordinates c) throws WrongCoordinatesException, BlockErrorException {
        if (!c.isInbound()) throw new WrongCoordinatesException();
        if (this.is_pickable(c)) return this.mappa[c.getX()][c.getY()];
        else throw new BlockErrorException();
    }
}
