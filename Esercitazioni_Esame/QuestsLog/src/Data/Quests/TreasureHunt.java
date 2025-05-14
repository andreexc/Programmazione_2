package Data.Quests;

import Data.Personaggi.Mostro;

import java.util.ArrayList;

public class TreasureHunt extends ContractQuest {

    private String luogobottino;

    public TreasureHunt(String nome, String tipologia, int lvlmin, int ricompensa, ArrayList<Mostro> mostri, String luogobottino) {
        super(nome, tipologia, lvlmin, ricompensa, mostri);
        this.luogobottino = luogobottino;
    }

    public String getLuogobottino() { return this.luogobottino; }
}
