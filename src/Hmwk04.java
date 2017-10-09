import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk04 {
    public static void main(String[] args) {
        File inputFile = new File(fetchFileName(args));
        int max = fetchMaximumSize(args);
        String[] passwords = new String[max];
        int count = readFromFile(passwords, inputFile);

        printOutput(passwords, count);

    }

    private static void printOutput(String[] passwords, int count) {
        System.out.printf("Number        User Password  Length  Lower  Upper  Digit  Special  Range");
        for (int i = 0; i < count; i++) {
            String password = passwords[i];
            System.out.printf("\n%6d%21s%8d%7s%7s%7s%9d%7d", i+1, password, password.length(),
                    containsLowercaseCharacters(password), containsUppercaseCharacters(password),
                    containsDigits(password), specialCharacters(password), getRange(password));
        }
    }

    private static boolean containsLowercaseCharacters(String password) {
        char[] passwordCharacters = password.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'a') && (passwordCharacters[count] <= 'z'));
            count++;
        }
        return found;
    }

    private static boolean containsUppercaseCharacters(String password) {
        char[] passwordCharacters = password.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'A') && (passwordCharacters[count] <= 'Z'));
            count++;
        }
        return found;
    }

    private static boolean containsDigits(String password) {
        boolean found = false;
        char ch = '0';

        while (ch <= '9' && !found) {
            found = password.indexOf(ch) > -1;
            ch++;
        }
        return found;
    }

    private static int readFromFile(String[] passwords, File inputFile) {
        int count = 0;
        int max = passwords.length;

        try {
            Scanner input = new Scanner(inputFile);
            if (input.hasNext()) {
                while ((count < max) && input.hasNext()) {
                    passwords[count] = input.next().trim();
                    count++;
                }
            } else {
                System.out.printf("File \"%s\" is empty.\n", inputFile);
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found.\n", inputFile);
            System.exit(1);
        }


        return count;
    }

    private static int specialCharacters(String password) {
        String characters = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int count = 0;
        for (char compareChar : characters.toCharArray()) {
            if (password.contains(Character.toString(compareChar))) {
                count++;
            }
        }
        return count;
    }

    private static int getRange(String password) {
        int range = 0;

        boolean digit = containsDigits(password);
        boolean lowerCase = containsLowercaseCharacters(password);
        boolean upperCase = containsUppercaseCharacters(password);
        int specialChars = specialCharacters(password);

        if(digit) {
            range += 10;
        }
        if (lowerCase) {
            range += 26;
        }
        if (upperCase) {
            range += 26;
        }
        range += specialChars;

        return range;
    }

    private static String fetchFileName(String[] args) {
        String result = "userpasswords.txt";
        if (args.length > 0) {
            result = args[0];
        }
        return result;
    }

    private static int fetchMaximumSize(String[] args) {
        int result = 100;
        if (args.length > 1) {
            try {
                result = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                System.out.printf("\"%s\" is not a valid integer.\n", args[1]);
                System.exit(1);
            }
        }
        return result;
    }
}
