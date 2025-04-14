import javax.swing.*;

//login class

public class Login {

//Declarations for registration methods

    static String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String allDigits = "0123456789";
    static String setRegistrationUsername;
    static String setRegistrationPassword;
    static String setRegistrationNumber;

    // Method to check if username contains an underscore and is no more than five characters long

    static boolean checkUsername(String jtuser) {

        if ((jtuser.contains("_")) && (jtuser.length() <= 5)) {
            JOptionPane.showMessageDialog(null, "Username captured successfully.");
            return true;

        }
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted please ensure that your usernmae contains an underscore and is no more than five characters in length.");
        return false;

    }

    // Method to check if password has more than 8 characters, has an uppercase and has a special character

    static boolean checkPasswordComplexity(String Password) {

        if (Password.length() > 8 && isUpperCase(Password) && isDigit(Password) && isSymbol(Password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }
        return false;


    }

    // Method to check if at least one uppercase character exists in the password

    static Boolean isUpperCase(String password) {

        char letterInABC;

        for (int i = 0; i < allLetters.length(); i = i + 1) {
            letterInABC = allLetters.charAt(i);

            String convertedLetter = Character.toString(letterInABC);
            if (password.contains(convertedLetter)) {

                return true;
            }


        }

        return false;
    }

    // Method that returns a special character by running through all alphabets and numbers

    static Boolean isSymbol(String password) {

        char letterInABC;

        for (int i = 0; i < password.length(); i = i + 1) {
            letterInABC = password.charAt(i);

            if (!Character.isLetterOrDigit(letterInABC)) {

                return true;
            }
        }

        return false;
    }

    // Method to check if the cellphone number has the South African international code and is 10 characters long

    static boolean checkCellphoneNumber(String cellnumber) {


        if (cellnumber.contains("+27") && (cellnumber.length() == 12)) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number incorrectly formated or does not contain international code");
            return false;
        }


    }

    //Method to prompt user to enter username, password and number for registration 

    static void registerUser() {

        setRegistrationUsername = JOptionPane.showInputDialog("Enter Username:");

        boolean username = checkUsername(setRegistrationUsername);


        setRegistrationPassword = JOptionPane.showInputDialog("Enter Password");

        boolean password = checkPasswordComplexity(setRegistrationPassword);

        setRegistrationNumber = JOptionPane.showInputDialog("Enter Number");

        boolean Number = checkCellphoneNumber(setRegistrationNumber);


    }


    //Method to loop through all the digits 

    static boolean isDigit(String character) {


        char DigitIn012;


        for (int i = 0; i < allDigits.length(); i = i + 1) {
            DigitIn012 = allDigits.charAt(i);

            String convertedDigit = Character.toString(DigitIn012);
            if (character.contains(convertedDigit)) {


                return true;
            }

        }

        return false;

    }

    //Method that prompts for user to enter username and password 

    static boolean loginUser() {
        String jtuser = JOptionPane.showInputDialog(null, "Enter Username:");

        String Password = JOptionPane.showInputDialog(null, "Enter Password");


        if (jtuser.equals(setRegistrationUsername)
                &&
                Password.equals(setRegistrationPassword)
        ) return true;

        else return false;

    }

    //Method to prompt user if log in was successful or not

    static String returnLoginStatus(boolean isLogin) {

        if (isLogin) {
            return "A successful login";
        }
        return "A failed login";

    }
// Main Program

    public static void main(String[] args) {


        registerUser();

// if statement used to check if the login requirements have been met, shows a prompt message

        if (loginUser()) {
            JOptionPane.showMessageDialog(null, returnLoginStatus(true));

            JOptionPane.showMessageDialog(null, "Welcome " + setRegistrationUsername + " its great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, returnLoginStatus(false));
            JOptionPane.showMessageDialog(null, "Username or password incorrect.");

        }
    }

}
