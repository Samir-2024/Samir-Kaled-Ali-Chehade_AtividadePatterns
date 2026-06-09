public class NotificationService {
    private final NotificationFactory factory;

    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void notify(String message) {
        // O serviço não sabe qual tipo de notificação está criando
        Notification notification = factory.createNotification();
        notification.send(message);
    }
}
