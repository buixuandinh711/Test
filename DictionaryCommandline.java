import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    private static DictionaryManagement dictionaryManagements = new DictionaryManagement();

    public static void dictionaryBasic() {
        dictionaryManagements.insertFromCommandline();
        dictionaryManagements.showAllWords();
    }

    public static void dictionaryAdvanced() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            scanner.nextLine();
            switch (n) {
                case 1:
                    dictionaryManagements.insertFromFile();
                    dictionaryManagements.showAllWords();
                    break;
                case 2:
                    String word = scanner.nextLine();
                    dictionaryManagements.dictionaryLookup(word);
                    break;
            }
            if (n == 0) break;
        }
    }

    public static void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        String wordSearcher = scanner.nextLine();
        dictionaryManagements.Searcher(wordSearcher);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            scanner.nextLine();
            switch (n) {
                case 1:
                    dictionaryBasic();
                    break;
                case 2:
                    dictionaryAdvanced();
                    break;
                case 3:
                    dictionarySearcher();
                    break;
                case 4:
                    dictionaryManagements.dictionaryExportToFile();
                    break;
                case 5:
                    String word_target = scanner.nextLine();
                    dictionaryManagements.removeWord(word_target);
                    dictionaryManagements.showAllWords();
                    break;
            }
            if (n == 0) break;
        }
    }
}
