package Data;

public class Utente {

    private int capitale;
    private int spesa_mensile;
    private int mesi_abbonamento;

    public Utente() {
        this.capitale = 100;
        this.spesa_mensile = 0;
        this.mesi_abbonamento = 0;
    }

    public int getCapitale() {
        return capitale;
    }

    public int getSpesaMensile() {
        return spesa_mensile;
    }

    public int getMesiAbbonato() {
        return mesi_abbonamento;
    }

    private void pagaAbbonamento() {
        this.capitale -= this.spesa_mensile;
    }

    public void AggiungiFondi() {
        this.capitale += 100;
    }

    public void prossimoMese() {
        this.pagaAbbonamento();
        ++this.mesi_abbonamento;
    }

    public void modificaSpesaMensile(int differenza) {
        this.spesa_mensile += differenza;
    }

    @Override
    public String toString() {
        return "Capitale: " + this.capitale + " Spesa Mensile: " + this.spesa_mensile + " Mesi Trascorsi: " + this.mesi_abbonamento;
    }
}
