import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<Word>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public void removeWord(String word_target) {
        words.remove(getWordByword_target(word_target));
    }

    public Word getWordByword_target(String word_target) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord_target() == word_target) {
                return words.get(i);
            }
        }
        return null;
    }

    public int getNumberOfWord() {
        return words.size();
    }

    public String getWord_explain(int i) {
        return words.get(i).getWord_explain();
    }

    public String getWord_target(int i) {
        return words.get(i).getWord_target();
    }
}
