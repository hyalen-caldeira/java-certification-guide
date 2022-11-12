package us.hyalen.patterns.memento;

public class UserMemento {
    private String firstName;
    private String lastName;
    private int age;

    public UserMemento(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Memento getMemento() {
        var state = new UserMementoInternal(firstName, lastName, age);

        return state;
    }

    public void setMemento(Memento memento) {
        var state = (UserMementoInternal) memento;

        firstName = state.firstName;
        lastName = state.lastName;
        age = state.age;
    }

    public String toString() {
        return firstName + " " + lastName + ", " + age + " Years Old.";
    }

    private static class UserMementoInternal implements Memento {
        String firstName;
        String lastName;
        int age;

        UserMementoInternal(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }
}
