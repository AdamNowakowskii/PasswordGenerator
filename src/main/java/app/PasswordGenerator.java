package app;
import java.util.ArrayList;
import java.util.Random;
public class PasswordGenerator {
    private static final Random random = new Random();
    //method for Lists
    public static String[] creatTabAlphabet() {
        String[] alphabet = new String[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = Character.toString((char) ('a' + i));
        }
        return alphabet;
    }

    public static String[] createTabDigit(){
        return "0123456789".split("");
    }

    public static String[] createTabSpecialCharacter(){
        return "!@#$%^&*()".split("");
    }
    //create password with tabMethods
public static String createPassword(int userLenght, ArrayList<String> list) {
    String[] tabDigit = createTabDigit();
    String[] tabSpecialCharacter = createTabSpecialCharacter();
    String[] tabAlphabet = creatTabAlphabet();
    StringBuilder password = new StringBuilder();
        while (userLenght != password.length()) {
            if (list.contains("uppercase"))
                password.append(tabAlphabet[random.nextInt(26)].toUpperCase());
            if (list.contains("lowercase") && userLenght != password.length())
                password.append(tabAlphabet[random.nextInt(26)]);
            if (list.contains("numbers") && userLenght != password.length())
                password.append(tabDigit[random.nextInt(10)]);
            if (list.contains("symbols") && userLenght != password.length())
                password.append(tabSpecialCharacter[random.nextInt(10)]);
        }
        return String.valueOf(password);
    }
    
}




