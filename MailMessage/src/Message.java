/**
 * Purpose: This class holds all the getters, and setters for a message
 * thi class has no methods outside of the getters and setters.
 * @author zudou280
 *
 */
public class Message {

    /*----------------------DATA----------------------------*/

    private int messageNumber;
    private char messageStatus;
    private String sender;
    private String recipient;
    private String subject;
    private String body;

    /*-----------------------CONSTRUCTORS----------------------*/

    /**
     * Purpose: This is the default constructor.
     */
    public Message() {
        super();
        this.messageNumber = 0;
        this.messageStatus = ' ';
        this.sender = "";
        this.recipient = "";
        this.subject = "";
        this.body = "";
    }

    /**
     * Purpose: This is a paramaterized constructor.
     * @param messageNumber This is the number of the message.
     * @param messageStatus This is the status of the message.
     * @param sender This is the sender of the message.
     * @param recipient This is the recipient of the message.
     * @param subject this is the subject of the message.
     * @param body This is the body of the message.
     */
    public Message(int messageNumber, char messageStatus, String sender,
            String recipient, String subject, String body) {
        super();
        this.messageNumber = messageNumber;
        this.messageStatus = messageStatus;
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Purpose: This is the copy constructor.
     * @param message This is a message object.
     */
    public Message(Message message)
    {
        this.messageNumber = message.getMessageNumber();
        this.messageStatus = message.getMessageStatus();
        this.sender = message.getSender();
        this.recipient = message.getRecipient();
        this.subject = message.getSubject();
        this.body = message.getBody();
    }

    /*--------------------------GETTERS-----------------------*/

    public int getMessageNumber() {
        return messageNumber;
    }

    public char getMessageStatus() {
        return messageStatus;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    /*---------------------SETTERS-------------------------------*/

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public void setMessageStatus(char messageStatus) {
        this.messageStatus = messageStatus;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
