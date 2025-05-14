package Data.Quests;
import Data.Exceptions.NonCompletableQuestException;
import Data.Personaggi.Personaggio;

public abstract class Quest implements Questable {
    protected String nome;
    protected String tipologia;
    protected int lvlmin;
    protected int ricompensa;
    protected boolean risolta;

    public Quest(String nome, String tipologia, int lvlmin, int ricompensa) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.lvlmin = lvlmin;
        this.ricompensa = ricompensa;
        this.risolta = false;
    }

    public String getNome() { return this.nome; }
    public String getTipologia() { return this.tipologia; }
    public int getLvlmin() { return this.lvlmin; }
    public int getRicompensa() { return this.ricompensa; }
    public boolean getRisolta() { return this.risolta; }
    public void risolvi(Personaggio pg) throws NonCompletableQuestException {
        this.risolta = true;
        pg.incrementaLivello();
        pg.ottieniRicompensa(this.ricompensa);
    }

}