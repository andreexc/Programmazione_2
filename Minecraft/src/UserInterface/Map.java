package UserInterface;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Blocks.NullBlock;
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

    public Block getBlockCell(MapCoordinates c) {
        if (!c.isInbound()) return BlockCreator.NullBlock();
        return mappa[c.getX()][c.getY()];
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

    // metodo che mi permette di cambiare un determinato
    // blocco con un altro
    public void change_cell(MapCoordinates c, Block newBlock) {
        // controllo che le coordinate siano valide
        if (!c.isInbound()) {
            // meglio lanciare una exception ?
            return;
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

        Block tmp = this.mappa[x][y];
        this.mappa[x][y] = this.mappa[x+1][y];
        this.mappa[x+1][y] = tmp;
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

    public boolean is_pickable(MapCoordinates c) {
        if (!c.isInbound()) return false;
        if (mappa[c.getX()][c.getY()].is_pickable()) return true;
        return false;
    }

    public Block gimme_pickable(MapCoordinates c) {
        if (!c.isInbound()) return null;
        return mappa[c.getX()][c.getY()]; // ASSUMO CHE SIA PICKABLE !!!!
    }
}
