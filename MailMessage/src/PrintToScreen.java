
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Purpose: This class prints most of the messages to the screen.
 * @author zudou280 Zachary Udoumoren
 *
 */
public class PrintToScreen {

    /**
     * Purpose: This method returns the users name. And prints out the original message to the screen.
     * @param out This allows me to write to the terminal.
     * @param scanner This allows me to read input from the user.
     * @param fileName This is the name of the file we are reading from.
     * @return userName This is the users name.
     */
    public String welcomeMessage(PrintWriter out, Scanner scanner, String fileName) {
        out.println("Welcome to the Secure Corp. messaging system.");
        out.println("Reading mail from " + fileName + "... done.");
        out.println("Enter your name (be honest):");
        String userName = scanner.nextLine();

        return userName;
    }

    /**
     * Purpose: This method allows me to print out the amount of unread messages to the user.
     * @param out This allows me to print to the terminal
     * @param userName This is the users name
     * @param unreadMessages This is the amount of unread messages from thw user
     */
    public void amountOfUnreadMessagesPrinter(PrintWriter out, String userName, int unreadMessages) {
        out.println("\nHello, " + userName + ", you have " + unreadMessages + " unread messages.");
    }

    /**
     * Purpose: This method allows me to print out the menu to the user.
     * @param out This allows me to print to the terminal.
     * @param scanner This allows me to read in from the user.
     * @return userChoice This is a char value, it is the users choice of what they want to do.
     */
    public char menu(PrintWriter out, Scanner scanner) {

        out.println("\nAvailable Options");
        out.println("  L - List your messages");
        out.println("  V - View a message");
        out.println("  C - Compose a message");
        out.println("  S - Switch Users");
        out.println("  Q - Quit\n");
        out.println("Please enter your choice:");
        char usersChoice = scanner.next().charAt(0);

        return usersChoice;
    }

    /**
     * Purpose: This method prints the exit message to the screen.
     * @param out This is a printwriter it allows me to write to the terminal
     * @param scanner This is a scanner it allows me to read input from the user
     * @param fileName This is a string, it is the name of the file that the info is being written to
     */
    public void quitProgram(PrintWriter out, Scanner scanner, String fileName)
    {
        out.println("Thanks for using the Secure Corp. messaging system.");
        out.println("Writing mail to " + fileName + "... done.");
    }
}
