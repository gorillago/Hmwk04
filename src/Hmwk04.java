public class Hmwk04 {
    public static void main(String[] args) {
        Password password = new Password("");
        System.out.println(password.containsLowercaseCharacters() + " " + password.containsUppercaseCharacters() + " " + password.specialCharacters());
    }


    private void printOutput() {
        System.out.printf("Number        User Password  Length  Lower  Upper  Digit  Special  Range");

    }
}
