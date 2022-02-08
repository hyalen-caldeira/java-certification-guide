package us.hyalen.patterns.singleton;

public class Singleton {
    // Uncomment in case you will use the synchronized version
    // private static volatile Singleton instance;
    private static Singleton instance;

    private Singleton() {}

    // public static synchronized Singleton getInstance() {
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    /*
    // Synchronized version with better performance
    public static Singleton getInstance() {
        if (instance == null)
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }

        return instance;
    }
    */
}
