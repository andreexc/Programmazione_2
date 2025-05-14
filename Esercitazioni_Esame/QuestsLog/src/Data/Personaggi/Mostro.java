package Data.Personaggi;

public class Mostro implements Comparable<String> {

    private String tipologia;

    public Mostro(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTipologia() { return this.tipologia; }

    @Override
    public String toString() { return this.tipologia; }

    // compara per nome
    @Override
    public int compareTo(String o) {
        return this.tipologia.compareTo(o);
    }
}
