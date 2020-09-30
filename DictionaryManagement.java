import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionarys;

    public DictionaryManagement() {
        dictionarys = new Dictionary();
    }

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i =0; i < n; i++) {
            String word_target = scanner.nextLine();
            String word_explain = scanner.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionarys.addWord(word);
        }
    }

    public void showAllWords() {
        System.out.printf("%-5s|%-15s|%s\n","No","English","Vietnamese");
        for (int i = 0; i < dictionarys.getNumberOfWord(); i++) {
            System.out.printf("%-5d|%-15s|%s\n",i+1,dictionarys.getWord_target(i),dictionarys.getWord_explain(i));
        }
    }
}
