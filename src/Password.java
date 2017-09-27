public class Password {
    String userPassword;
    public Password(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean containsLowercaseCharacters() {
        char[] passwordCharacters = userPassword.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'a') && (passwordCharacters[count] <= 'z'));
            count++;
        }
        return found;
    }

    public boolean containsUppercaseCharacters() {
        char[] passwordCharacters = userPassword.toCharArray();
        boolean found = false;
        int count = 0;

        while (!found && count < passwordCharacters.length) {
            found = ((passwordCharacters[count] >= 'A') && (passwordCharacters[count] <= 'Z'));
            count++;
        }
        return found;
    }

    public int specialCharacters() {
        String characters = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int count = 0;

        for (char passChar : userPassword.toCharArray()) {
            for (char compareChar : characters.toCharArray()) {
                if (passChar == compareChar) {
                    count++;
                }
            }
        }
        return count;
    }
}
