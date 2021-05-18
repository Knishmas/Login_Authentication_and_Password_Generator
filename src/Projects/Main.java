package Projects;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome! Please enter a username to be created: ");
        String username;
        String passwordChoice;
        String password;
        Scanner input = new Scanner(System.in);
        String usernameCheck;
        String passwordCheck;
        username = input.nextLine();

        System.out.println("Would you like to have a randomly generated password? Enter Y for Yes or N for no: ");
        passwordChoice = input.nextLine();
        if(passwordChoice.equals("Y")) {
            password = makePassword(randomWithRange(7, 12));
            System.out.println("Password Generated: " + password);
        }
      else {
            System.out.println("Please enter a password to be created: ");
            password = input.nextLine();
        }
        System.out.println("Your login information has been saved!");
        System.out.println("--------------------------------------");
        System.out.println("Please enter login info to continue ");
        System.out.println("Username: ");
        usernameCheck = input.nextLine();
        System.out.println("Password: ");
        passwordCheck = input.nextLine();

        if ((usernameCheck.equals(username) && (passwordCheck.equals(password)))) {
            System.out.println("Login Succesful! Welcome " + username);
        }
        else {
            System.out.println("Login information incorrect!");
        }

    }

        public static String randomCharacter (String characters){
            int n = characters.length();
            int r = (int) (n * Math.random());
            return characters.substring(r, r + 1);

        }

        public static String insertAtRandom (String str, String toInsert){
            int n = str.length();
            int r = (int) ((n + 1) * Math.random());
            return str.substring(0, r) + toInsert + str.substring(r);
        }

        public static int randomWithRange ( int min, int max){
            int range = (max - min) + 1;
            return (int) (Math.random() * range) + min;
        }
    public static String makePassword(int length) {
        String password = "";

        for (int i = 0; i < length - 2; i++) {
            int pathDecider = randomWithRange(1, 4);
            switch (pathDecider) {
                case 1:
                    password = password + randomCharacter("abcdefghijklmnopqrstuvwxyz");
                    break;
                case 2:
                    password = password + randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                case 3:
                    String randomNumber = randomCharacter("0123456789");
                    password = insertAtRandom(password, randomNumber);
                    break;
                case 4:
                    String randomSymbol = randomCharacter("*?!@$#-.+_");
                    password = insertAtRandom(password, randomSymbol);
                    break;
                default:
                    System.out.println("An error has occured! Please try Again!");
                    break;
            }

        }
        return password;
    }
    }
