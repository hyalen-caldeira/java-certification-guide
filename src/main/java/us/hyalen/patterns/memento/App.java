package us.hyalen.patterns.memento;

import java.util.Stack;

public class App {
    Stack<Memento> stack;

    App() {
        stack = new Stack<>();
    }

    void beginTransaction() {
        stack.clear();
    }

    void commit() {

    }

    void rollback() {

    }

    public static void main(String... args) {
        App app = new App();

        // Begin Transaction
        app.beginTransaction();

        UserMemento user = new UserMemento("Hyalen", "Caldeira", 36);

        // Save First State
        app.stack.push(user.getMemento());

        user.setFirstName("Igor");
        app.stack.push(user.getMemento());

        user.setFirstName("Nicole");
        app.stack.push(user.getMemento());

        while (!app.stack.isEmpty()) {
            user.setMemento(app.stack.pop());
            System.out.println(user);
        }
    }
 }
