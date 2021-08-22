import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your input text:");
        String myText = keyboard.nextLine();
        while (myText.matches(".*(.)\\1.*")) {
            myText = removeArticles(myText);
            myText = removeOrReplaceC(myText);
            myText = removeOrReplaceDoubleLetter(myText);
            myText = removeE(myText);
        }
        System.out.println(myText);
    }

    private static String removeOrReplaceC(String myText) {
        String resultText;
        if (myText.contains("ce")) {
            resultText = myText.replace("ce", "se");
            return removeOrReplaceC(resultText);
        } else if (myText.contains("ci")) {
            resultText = myText.replace("ci", "si");
            return removeOrReplaceC(resultText);
        } else if (myText.contains("ck")) {
            resultText = myText.replace("ck", "k");
            return resultText;
        }
        return myText.replace("c", "k");

    }

    private static String removeOrReplaceDoubleLetter(String myText) {
        String resultText;
        if (myText.contains("ee")) {
            resultText = myText.replace("ee", "i");
            return resultText;
        } else if (myText.contains("oo")) {
            resultText = myText.replace("oo", "u");
            return resultText;
        }
        return myText.replaceAll("(.)\\1", "$1");

    }

    private static String removeE(String myText) {

        return myText.replaceAll("(?<!\\b)e\\b", "");
    }

    private static String removeArticles(String myText) {
        return myText.replaceAll("/(?:(the|a|an) +)/g", "");
    }
}