package Data.Quests;

import Data.Exceptions.NonCompletableQuestException;
import Data.Personaggi.Personaggio;

public interface Questable {
    public void risolvi(Personaggio pg) throws NonCompletableQuestException;
}
