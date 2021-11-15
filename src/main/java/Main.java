import guru.springframework.norris.chuck.ChuckNorrisQuotes;

public class Main {
    public static void main(String[] args) {
        ChuckNorrisQuotes joke = new ChuckNorrisQuotes();
        System.out.println(joke.getRandomQuote());
    }
}
