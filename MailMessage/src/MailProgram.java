/**
 *
 * @author zudou280
 *
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Purpose: This class is essentially the "main" for the program. It runs the program
 * and the main method "makeProgram" is called by the main off the class RunProgram.
 * @author zudou280 Zachary Udoumoren
 *
 */
public class MailProgram {
	
	private final static String fileName = "mail.txt";
    private String userName;

    /**
     * Purpose: This method creates, and runs the program.
     * @throws IOException Throws exception
     */
    public void makeProgram() throws IOException{

    	PrintToScreen printer = new PrintToScreen();
        MailSystem mailSystem = new MailSystem();

        File tempFile = new File(fileName);
       // PrintWriter outToFile = new PrintWriter(tempFile);
        PrintWriter out = new PrintWriter(System.out, true);
        
        Scanner scanner = new Scanner(System.in);
        Scanner inFromFile = new Scanner(tempFile);
        //Scanner toFile = new Scanner(tempFile);
        
        char usersChoice;
        boolean flag = true;
        
        mailSystem.loadFromFile(out, inFromFile);
        inFromFile.close();
        this.setUserName(printer.welcomeMessage(out, scanner, fileName));
        
        printer.amountOfUnreadMessagesPrinter(out, this.getUserName(),
                mailSystem.amountOfUnreadMessages(this.getUserName()));
        while (flag)
        {
            usersChoice = printer.menu(out, scanner);
            char upperUserChoice = Character.toUpperCase(usersChoice);
            
            switch (upperUserChoice) {
                case 'L': mailSystem.listMessages(out, this.getUserName());
                        break;
                case 'V': mailSystem.viewMessageUser(scanner, this.getUserName(), out);
                        break;
                case 'C': mailSystem.composeMessage(out,scanner,this.getUserName());
                        break;
                case 'S': scanner.nextLine(); 
                	out.println("Enter your name (be honest):");
                	this.userName =	scanner.nextLine();
                	out.print(this.getUserName());
                     printer.amountOfUnreadMessagesPrinter(out, this.getUserName(),
                              mailSystem.amountOfUnreadMessages(this.getUserName()));
                        break;
                case 'Q': PrintWriter outToFile = new PrintWriter(tempFile);
                		printer.quitProgram(out, scanner, fileName);
                        mailSystem.writeToFile(outToFile);
                        flag = false;
                        break;

            }
            out.flush();
        }
        out.close();
        scanner.close();
    }

    /*----------------------------GETTERS--------------------*/

    public String getUserName() {
        return userName;
    }

    /*------------------SETTERS-----------------------------*/

    public void setUserName(String userName) {
        this.userName = new String(userName);
    }

}
