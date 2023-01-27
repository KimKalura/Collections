package spellChecker;

import java.util.List;
import java.util.Set;

public class SpellChecker {
    Set<String> dictionary;
    List<String> wordsFromText;

    public SpellChecker(Set<String> dictionary, List<String> wordsFromText) {
        this.dictionary = dictionary;
        this.wordsFromText = wordsFromText;
    }

    public Set<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> getWordsFromText() {
        return wordsFromText;
    }

    public void setWordsFromText(List<String> wordsFromText) {
        this.wordsFromText = wordsFromText;
    }
}




