import java.io.IOException;

/**
 * Purpose: This class runs the program.
 * @author zudou280 Zachary Udoumoren
 *
 */

public class RunProgram {

    /**
     * Purpose: This is the main method. It calls the method makeProgram from the MailProgram class.
     * @param args Not used
     * @throws IOException This exception is thrown by the method that prints to the file
     */
    public static void main(String[] args)throws IOException {

        MailProgram program = new MailProgram();

        program.makeProgram();

    }
}
