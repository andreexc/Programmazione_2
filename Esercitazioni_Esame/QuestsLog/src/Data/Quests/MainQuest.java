package Data.Quests;

public class MainQuest extends Quest {

    private String luogoquest;
    private String prossima;

    public MainQuest(String nome, String tipologia, int lvlmin, String luogoquest, String prossima) {
        super(nome, tipologia, lvlmin, 10);
        this.luogoquest = luogoquest;
        this.prossima = prossima;
    }

    public String getLuogoQuest() { return this.luogoquest; }
    public String getProssimaQuest() { return this.prossima; }
}
