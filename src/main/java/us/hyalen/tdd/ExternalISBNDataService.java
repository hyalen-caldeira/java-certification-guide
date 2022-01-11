package us.hyalen.tdd;

// This interface was create to Stub test scenario
@FunctionalInterface
public interface ExternalISBNDataService {
    Book lookup(String isbn);
}
