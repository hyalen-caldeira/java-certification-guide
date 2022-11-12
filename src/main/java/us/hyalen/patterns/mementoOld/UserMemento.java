package us.hyalen.patterns.mementoOld;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserMemento implements DtoMemento {
    private String firstName;
    private String lastName;
    private int age;

    public UserMemento(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public Memento getMemento() {
        var state = new UserMementoInternal(firstName, lastName, age);

        return state;
    }

    @Override
    public void setMemento(Memento memento) {
        var state = (UserMementoInternal) memento;

        this.firstName = state.firstName;
        this.lastName = state.lastName;
        this.age = state.age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age + " years old.";
    }

    @Data
    @AllArgsConstructor
    private static class UserMementoInternal implements Memento {
        private String firstName;
        private String lastName;
        private int age;
    }
}
