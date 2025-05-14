package Data.Personaggi;

public class Personaggio {

    private int livello;
    private int soldi;
    private static final String name = "Geraldo";

    public Personaggio() {
        this.livello = 0;
        this.soldi = 0;
    }

    public int getLivello() { return this.livello; }
    public int getSoldi() { return this.soldi; }

    public void incrementaLivello() { this.livello++; }
    public void ottieniRicompensa(int soldi) { this.soldi += soldi; }
}
