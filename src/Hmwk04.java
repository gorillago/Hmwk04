public class Hmwk04 {
    public static void main(String[] args) {
        String password = "Testing $*%&&#*";
        String passwords[] = new String[1];
        passwords[0] = password;
        printOutput(passwords);
        System.out.print(containsLowercaseCharacters(password) + " " + containsUppercaseCharacters(password) + " " + specialCharacters(password));
    }


    private static void printOutput(String[] passwords) {
        System.out.printf("Number        User Password  Length  Lower  Upper  Digit  Special  Range");
        for (int i = 0; i < passwords.length; i++) {
            String password = passwords[i];
            System.out.printf("\n%6d%21s%8d%7s%7s%7s", i+1, password, password.length(),
                    containsLowercaseCharacters(password), containsUppercaseCharacters(password),
                    containsDigits(password), specialCharacters(password));
        }
    }
    public static boolean containsLowercaseCharacters(String password) {
        char[] passwordCharacters = password.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'a') && (passwordCharacters[count] <= 'z'));
            count++;
        }
        return found;
    }

    public static boolean containsUppercaseCharacters(String password) {
        char[] passwordCharacters = password.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'A') && (passwordCharacters[count] <= 'Z'));
            count++;
        }
        return found;
    }

    public static boolean containsDigits(String password) {
        boolean found = false;
        char ch = '0';

        while (ch <= '9' && !found) {
            found = password.indexOf(ch) > -1;
            ch++;
        }
        return found;
    }

    public static int specialCharacters(String password) {
        String characters = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int count = 0;
        for (char compareChar : characters.toCharArray()) {
            if (password.contains(Character.toString(compareChar))) {
                count++;
            }
        }
        return count;
    }
}
