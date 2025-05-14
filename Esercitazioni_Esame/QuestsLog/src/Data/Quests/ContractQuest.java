package Data.Quests;

import Data.Exceptions.EmptyMonsterListException;
import Data.Exceptions.NonCompletableQuestException;
import Data.Personaggi.Mostro;
import java.util.ArrayList;

public class ContractQuest extends Quest {

    protected ArrayList<Mostro> mostri;

    public ContractQuest(String nome, String tipologia, int lvlmin, int ricompensa, ArrayList<Mostro> mostri) throws NonCompletableQuestException {
        super(nome, tipologia, lvlmin, ricompensa+(ricompensa*20/100));
        this.mostri = mostri;
        if (this.mostri.isEmpty()) { throw new EmptyMonsterListException("Error. Empty Monster List!"); }
    }

    public ArrayList<Mostro> listaMostri() { return this.mostri; }
}
