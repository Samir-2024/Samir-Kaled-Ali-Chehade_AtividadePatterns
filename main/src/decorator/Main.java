// Interface Base
interface Notifier {
    void send(String message);
}

// Implementação Concreta
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Enviando EMAIL: " + message);
    }
}

// Decorator Base
abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

// Decorator Concreto - SMS
class SmsDecorator extends NotifierDecorator {
    public SmsDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Enviando SMS: " + message);
    }
}

// Decorator Concreto - Slack
class SlackDecorator extends NotifierDecorator {
    public SlackDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Enviando SLACK: " + message);
    }
}

// Classe Principal de Teste
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Teste 1: Apenas Email ---");
        Notifier n1 = new EmailNotifier();
        n1.send("Olá");

        System.out.println("\n--- Teste 2: Email + Slack ---");
        Notifier n2 = new SlackDecorator(new EmailNotifier());
        n2.send("Promoção");

        System.out.println("\n--- Teste 3: Email + SMS + Slack ---");
        Notifier n3 = new SlackDecorator(new SmsDecorator(new EmailNotifier()));
        n3.send("Sistema fora");
    }
}