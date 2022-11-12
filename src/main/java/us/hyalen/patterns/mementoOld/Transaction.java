package us.hyalen.patterns.mementoOld;

import java.util.Stack;

public class Transaction<T extends DtoMemento> {
    private Stack<Memento> stack;
    private T memento;

    public Transaction() {
        this.stack = new Stack<>();
    }

    public void beginTransaction(T memento) {
        stack.clear();
        this.memento = memento;
        stack.push(memento.getMemento());
    }

    public void updateState() {
        stack.push(memento.getMemento());
    }

    public void commit() {
        memento.setMemento(stack.pop());
    }

    public void rollback() {
        stack.pop();
        memento.setMemento(stack.pop());
    }
}
