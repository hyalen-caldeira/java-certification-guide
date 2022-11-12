package us.hyalen.patterns.mementoOld;

public class App {
    Transaction<UserMemento> transaction;

    App() {
        this.transaction = new Transaction<>();
    }

    public static void main(String... args) {
        App app = new App();

        // Initial State
        UserMemento user = new UserMemento("Hyalen", "Caldeira", 40);

        // Begin Transaction
        app.transaction.beginTransaction(user);

        System.out.println(user);

        user.setFirstName("Nicole");
        app.transaction.updateState();

        user.setFirstName("Igor");
        app.transaction.updateState();


        app.transaction.rollback();
        System.out.println(user);

        app.transaction.rollback();
        System.out.println(user);

        app.transaction.rollback();
        System.out.println(user);
    }
}
