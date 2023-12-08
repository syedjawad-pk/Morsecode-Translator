import java.awt.Toolkit;
import java.util.Scanner;

public class MorseCodeTranslator {
    private static final int DOT_DURATION = 200; // Duration of a dot in milliseconds
    private static final int DASH_DURATION = 3 * DOT_DURATION; // Duration of a dash (3 times the dot duration)
    private static final int SPACE_DURATION = DOT_DURATION; // Duration of space between dots and dashes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        scanner.close();

        String morseCode = translateToMorseCode(text);
        System.out.println("Text: " + text);
        System.out.println("Morse Code: " + morseCode);
        playMorseCode(morseCode);
    }

    public static String translateToMorseCode(String text) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                result.append("/");
            } else {
                String morseCode = getMorseCode(c);
                if (morseCode != null) {
                    result.append(morseCode).append(" ");
                }
            }
        }

        return result.toString();
    }

    public static String getMorseCode(char c) {
        switch (c) {
            case 'A':
                return ".-";
            case 'B':
                return "-...";
            case 'C':
                return "-.-.";
            case 'D':
                return "-..";
            case 'E':
                return ".";
            case 'F':
                return "..-.";
            case 'G':
                return "--.";
            case 'H':
                return "....";
            case 'I':
                return "..";
            case 'J':
                return ".---";
            case 'K':
                return "-.-";
            case 'L':
                return ".-..";
            case 'M':
                return "--";
            case 'N':
                return "-.";
            case 'O':
                return "---";
            case 'P':
                return ".--.";
            case 'Q':
                return "--.-";
            case 'R':
                return ".-.";
            case 'S':
                return "...";
            case 'T':
                return "-";
            case 'U':
                return "..-";
            case 'V':
                return "...-";
            case 'W':
                return ".--";
            case 'X':
                return "-..-";
            case 'Y':
                return "-.--";
            case 'Z':
                return "--..";
            case '0':
                return "-----";
            case '1':
                return ".----";
            case '2':
                return "..---";
            case '3':
                return "...--";
            case '4':
                return "....-";
            case '5':
                return ".....";
            case '6':
                return "-....";
            case '7':
                return "--...";
            case '8':
                return "---..";
            case '9':
                return "----.";
            default:
                return null;
        }
    }    

    public static void playMorseCode(String morseCode) {
        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                playSound(DOT_DURATION);
            } else if (c == '-') {
                playSound(DASH_DURATION);
            } else if (c == '/') {
                sleep(SPACE_DURATION);
            } else if (c == ' ') {
                sleep(SPACE_DURATION);
            }
        }
    }

    public static void playSound(int duration) {
        Toolkit.getDefaultToolkit().beep();
        sleep(duration);
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
