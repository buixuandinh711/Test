import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;

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
        for (int i = 0; i < n; i++) {
            String word_target = scanner.nextLine();
            String word_explain = scanner.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionarys.addWord(word);
        }
    }

    public void showAllWords() {
        System.out.printf("%-5s|%-15s|%s\n", "No", "English", "Vietnamese");
        for (int i = 0; i < dictionarys.getNumberOfWord(); i++) {
            System.out.printf("%-5d|%-15s|%s\n", i + 1, dictionarys.getWord_target(i), dictionarys.getWord_explain(i));
        }
    }

    public void insertFromFile() throws IOException {
        Scanner scanner = new Scanner(
                Paths.get("C:\\Users\\HoatHT\\Desktop\\Test\\dictionaries.txt"), "UTF-8");
        while (scanner.hasNext()) {
            String word_target = scanner.next();
            String word_explain = scanner.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionarys.addWord(word);
        }
        scanner.close();
    }

    public void dictionaryLookup(String word_target) {
        for (int i = 0; i < dictionarys.getNumberOfWord(); i++) {
            if (dictionarys.getWord_target(i).equals(word_target)) {
                System.out.println(word_target + " : " + dictionarys.getWord_explain(i));
                break;
            }
        }
    }

    public void removeWord(String word_target) {
        dictionarys.removeWord(word_target);
    }

    public void Searcher(String wordSearcher) {
        for (int i = 0; i < dictionarys.getNumberOfWord(); i++) {
            int cnt = 0;
            String word = dictionarys.getWord_target(i);
            for (int j = 0; j < wordSearcher.length(); j++) {
                if(word.charAt(j) == wordSearcher.charAt(j)) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == wordSearcher.length()) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }

    public void dictionaryExportToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("tudien.txt", "UTF-8");
        for (int i = 0; i < dictionarys.getNumberOfWord(); i++) {
            printWriter.println(dictionarys.getWord_target(i) + " : " + dictionarys.getWord_explain(i));
        }
        printWriter.close();
    }
}
