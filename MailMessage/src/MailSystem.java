import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Purpose:This class holds the array of messages. It holds the methods that allow
 * the user to create, look at, and list messages. It also holds the method to change the
 * user name. And counting the amount of unread messages
 * @author zudou280 Zachary Udoumoren
 *
 */
public class MailSystem {

    /*-----------------------DATA--------------------------------*/

    final private static int amountOfMessages = 500;
    private Message[] messageArray;
    private int messageCount;

    /*-------------------CONSTRUCTORS----------------------------*/

    /**
     * Purpose: Default constructor.
     */
    public MailSystem() {
        super();
        this.messageArray = new Message[amountOfMessages];
        this.messageCount = 0;
    }


    /*-----------------------GETTERS---------------------------*/

    public static int getAmountOfMessages() {
        return amountOfMessages;
    }

    public Message[] getMessageArray() {
        return messageArray;
    }

    public int getMessageCount() {
        return messageCount;
    }

    /*------------------SETTERS----------------------------------*/

    public void setMessageArray(Message[] messageArray) {
        this.messageArray = messageArray;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    /*----------------------METHODS----------------------------*/

    /**
     * Purpose: This method finds and counts the number of unread messages for the user.
     * @param userName This is the name of the user
     * @return unread This is the amount of unread messages for the user
     */
    public int amountOfUnreadMessages(String userName)
    {
        int unread = 0;
        int index = 0;

        while (index < this.getMessageCount())
        {
            if (this.getMessageArray()[index].getMessageStatus() == 'N'
                    && this.getMessageArray()[index].getRecipient().equals(userName))
            {
                unread++;
            }
            index++;
        }
        return unread;
    }

    /**
     * Purpose: This method loads the messages from the files.
     * @param fileName This is the name of the file that is going to be read from
     * @param out Allows me to print if catch block is entered
     * @throws Exception If the file is not found, an exception is thrown
     */
    public void loadFromFile(PrintWriter out, Scanner scanner)
    {

     
   
            while (scanner.hasNextLine() && this.getMessageCount() < 500)
            {
                int number = scanner.nextInt();
                char status = scanner.next().charAt(0);
                String holder = scanner.nextLine();
                String sender = scanner.nextLine();
                String recipient = scanner.nextLine();
                String subject = scanner.nextLine();
                String tempBody = scanner.nextLine() + "\r\n";
                while (!tempBody.contains("EOF"))
                {
                    tempBody += scanner.nextLine();
                    tempBody += "\r\n";
                }
                this.getMessageArray()[this.getMessageCount()] =
                        new Message(number, status, sender, recipient, subject, tempBody);
                this.messageCount++;
            }
            //scanner.close();
        
    }


    /**
     * purpose: THIS IS A STUB, METHOD MUST BE FINISHED.
     * @param out THIS IS A PRINTWRITER, THIS IS JUST A PLACE HOLDER TO TEST FUNCTIONALITY AS METHOD IS NOT DONE
     */
    public void listMessages(PrintWriter out, String userName)
    {
      int index = 0;

        out.printf("%3s", "  #");
        out.printf("%2s", " S");
        out.printf("%4s", " From");
        out.printf("%7s", "              Subject\n");
        out.println("----------------------------------------");

        while(index < this.getMessageCount())
        {
          if(this.getMessageArray()[index].getRecipient().equals(userName))
          {
            out.format("%3s", this.getMessageArray()[index].getMessageNumber());
            if(this.getMessageArray()[index].getMessageStatus() == 'N')
            {
              out.format("%2s", " N ");
            }
            else
            {
              out.format("%2s", "   ");
            }
            out.printf("%-15.15s", this.getMessageArray()[index].getSender());
            out.print("   ");
            out.format("%-30.30s", this.getMessageArray()[index].getSubject());
            out.print('\n');
          }
        index++;
        }
    }

    /**
     * Purpose: This method print out the chosen message to the user. If the message is not addressed to the user then
     * a message is printed out to the screen.
     * @param scanner This allows input to be read from the user
     * @param userName This is the name of the user
     * @param out This allows me to print to the console
     */
    public void viewMessageUser(Scanner scanner, String userName, PrintWriter out)
    {

        int userChoice;
        int index = 0;

        out.println("Which message would you like to view:");
        userChoice = scanner.nextInt();
        
      /*  while (this.getMessageArray()[index].getMessageNumber() != userChoice)
        {
            index++;
        }*/
       // out.println(index);
        //out.print(this.getMessageArray()[index].getBody());
        if (this.getMessageArray()[userChoice -1].getRecipient().equals(userName))
        {
            out.print("\nMessage #");
            out.print(this.getMessageArray()[userChoice-1].getMessageNumber());
            if (this.getMessageArray()[userChoice-1].getMessageStatus() == 'N')
            {
                out.print(" (New)\n");
                this.getMessageArray()[userChoice-1].setMessageStatus('R');
            }
            else
            {
                out.print('\n');
            }
            out.println("From: " + this.getMessageArray()[userChoice-1].getSender());
            out.println("Subject: " + this.getMessageArray()[userChoice-1].getSubject());
            out.println("----------");
            out.println(this.getMessageArray()[userChoice-1].getBody());
            out.println("----------");
        }
        else
        {
            out.println("I'm sorry; message #" + userChoice + " is not addressed to you or does not exist");
        }
    }


    /**
     * Purpose: THIS IS A STUB, METHOD MUST BE FINISHED.
     * @param out THIS IS A PRINTWRITER, THIS IS JUST A PLACE HOLDER TO TEST FUNCTIONALITY AS METHOD IS NOT DONE
     */
    public void composeMessage(PrintWriter out, Scanner scanner, String userName)
    {
    	if(this.getMessageCount() <= 500)
    	{
    		int index = this.getMessageCount();
    		int messageNumber = this.getMessageCount() +1;
    		this.messageCount++;
    		
    		String recipient;
    		String subject;

       
    		out.print("\n\n");
    		out.println("Recipient:");
    		scanner.nextLine();
    		recipient = scanner.nextLine();
    	

    		out.println("Subject:");
    		subject = scanner.nextLine();
    		
        
    		out.println("Body(enter EOF to end body):");
    		String body = scanner.next();
    		if(!body.equals("EOF"))
    		{
    			scanner.useDelimiter("EOF");
    			body += scanner.next();  
    		}	 
    		else 
    		{
    			body = "";
    		}
    		body += "\nEOF";
    		scanner.reset();
    		scanner.nextLine();
    		this.getMessageArray()[index] = new Message(messageNumber, 'N', userName,
    				recipient, subject, body);
        
    		out.println(this.getMessageArray()[index].getMessageNumber());
    	}
       
    }

    /**
     * Purpose: This method writes the contents of the message array to a text file.
     * @param out This is a printwriter that writes to a file.
     * @throws IOException If the file to be written to is not found, then it throws an exception
     */
    public void writeToFile(PrintWriter out) throws IOException
    {
        int index = 0;

        while (index < this.getMessageCount())
        {
            out.print(this.getMessageArray()[index].getMessageNumber());
            out.print(' ');
            out.println(this
                    .getMessageArray()[index]
                    .getMessageStatus());
            out.println(this
                    .getMessageArray()[index]
                    .getSender());
            out.println(this
                    .getMessageArray()[index]
                    .getRecipient());
            out.println(this
                    .getMessageArray()[index]
                    .getSubject());
            out.print(this
                    .getMessageArray()[index]
                    .getBody());
            index++;
        }
        out.close();
    }
}
