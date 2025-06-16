package Data.Ventilatori;

public abstract class Ventilatore {

    protected String marca;
    protected int costo;
    protected String alimentazione;
    protected boolean abbonato;
    protected String tipologia;

    public Ventilatore(String marca) {
        this.marca = marca;
        this.costo = 10;
        this.abbonato = false;
    }

    public String getMarca() {
        return marca;
    }

    public int getCosto() {
        return costo;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public String getTipologia() {
        return tipologia;
    }

    public boolean isAbbonato() {
        return abbonato;
    }

    public void Abbona() {
        this.abbonato = true;
    }

    public void DisAbbona() {
        this.abbonato = false;
    }

    @Override
    public String toString() {
        return this.getMarca() + "\n" + "Tipo: " + this.getTipologia() + " | Alimentazione: " + this.getAlimentazione() + "\n" + "Costo: " + this.getCosto();
    }
}
