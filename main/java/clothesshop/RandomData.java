package clothesshop;

import java.util.Random;

public class RandomData {
    String[] fnames = {"Joe", "Sam", "Ann", "Jim", "Cam", "Linn", "Pam"};
    String[] countries = {"India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"};
    String[] streets = {"Street", "Drive", "Road"};

    public String generateStartLetter() {
        // characters to choose from:
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        // specifies the string length
        int stringLength = 5;
        
        for (int i = 0; i < stringLength; i++) {
            // generates random index number
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public String generateString(int length) {
        String alphabet = "abcdefghijklmnopqrstuwyxz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();	
    }

    public int generateNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }

}
    