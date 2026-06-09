public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("EmailFactory enviando: \"" + message + "\"");
    }
}
