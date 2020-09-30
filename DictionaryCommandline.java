public class DictionaryCommandline {
    private static DictionaryManagement dictionaryManagements = new DictionaryManagement();

    public static void dictionaryBasic() {
        dictionaryManagements.insertFromCommandline();
        dictionaryManagements.showAllWords();
    }

    public static void main(String[] args) {
        dictionaryBasic();
    }
}
