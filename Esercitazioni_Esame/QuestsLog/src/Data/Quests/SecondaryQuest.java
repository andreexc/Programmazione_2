package Data.Quests;

import Data.Exceptions.NoNPCException;
import Data.Personaggi.NPC;
import Data.Personaggi.Personaggio;

public class SecondaryQuest extends Quest {

    private NPC Npc;

    public SecondaryQuest(String nome, String tipologia, int lvlmin, int ricompensa, NPC Npc) throws NoNPCException {
        super(nome, tipologia, lvlmin, ricompensa);
        this.Npc = Npc;
    }

    public String getNomeNPC() { return this.Npc.getNome(); }

    // nelle quest secondarie mi viene chiesto di incrementare il livello di 2
    // invece di 1 quindi riscrivo la funzione risolvi e chiamo la funzione
    // originale (che incrementa il livello) e poi incremento di nuovo
    @Override
    public void risolvi(Personaggio pg) {
        super.risolvi(pg);
        pg.incrementaLivello();
    }
}
