package us.hyalen.ocp_two.JavaFundamentals.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import us.hyalen.tdd.Book;
import us.hyalen.tdd.ExternalISBNDataService;
import us.hyalen.tdd.StockManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class StockManagementTest {
    private static final String VALID_ISBN = "0140177396";

    private ExternalISBNDataService webService;
    private ExternalISBNDataService dbService;
    StockManagement stockManagement;
    @Spy
    StockManagement spyStockManagement;

    @BeforeEach
    public void setup() {
        webService = mock(ExternalISBNDataService.class);
        dbService = mock(ExternalISBNDataService.class);

        stockManagement = new StockManagement();

        stockManagement.setDbService(dbService);
        stockManagement.setWebService(webService);
    }

    @Test
    @DisplayName("Check if Locator is corrected")
    void checkIfLocatorCodeIsCorrect() {
        // Manual stub simulating mock from Mockito
        ExternalISBNDataService webService = isbn -> new Book(isbn, "Of Mice And Men", "J. Steinbeck");
        ExternalISBNDataService dbService = isbn -> null;

        StockManagement stockManagement = new StockManagement();

        stockManagement.setDbService(dbService);
        stockManagement.setWebService(webService);

        String locatorCode = stockManagement.getLocatorCode(VALID_ISBN);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    @DisplayName("Database is used if data is present")
    void databaseIsUsedIfDataIsPresent() {
        when(dbService.lookup(VALID_ISBN)).thenReturn(new Book(VALID_ISBN, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManagement.getLocatorCode(VALID_ISBN);

        // Instead of "times" we can also use atLeast or atMost.
        // Observe that times(1) is the default, so, no need to inform
        verify(dbService, times(1)).lookup(VALID_ISBN);
        // In case you need, you can also use any(yourClass.class)
        verify(webService, never()).lookup(anyString());
    }

    @Test
    @DisplayName("Check if webservice is used if data is not present in database")
    void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        when(dbService.lookup(VALID_ISBN)).thenReturn(null);
        when(webService.lookup(VALID_ISBN)).thenReturn(new Book(VALID_ISBN, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManagement.getLocatorCode(VALID_ISBN);

        verify(dbService, times(1)).lookup(VALID_ISBN);
        verify(webService, times(1)).lookup(VALID_ISBN);
    }

    @Test
    @DisplayName("Testing example using Spy")
    void exampleUsingSpy() {
        spyStockManagement = spy(new StockManagement());
        doReturn("Testing spy ...").when(spyStockManagement).getLocatorCode(VALID_ISBN);

        assertEquals("Testing spy ...", spyStockManagement.getLocatorCode(VALID_ISBN));
    }
}
