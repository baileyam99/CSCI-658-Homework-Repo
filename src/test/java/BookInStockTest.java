import Homework_2.BookInStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookInStockTest {
    private final String isbn = "978-1-4028-9462-6";
    private final double price = 29.99;
    BookInStock bookInStock;

    @Test
    public void testVars() {
        bookInStock = new BookInStock(isbn, price);
        assertEquals(isbn, bookInStock.getIsbn());
        assertEquals(price, bookInStock.getPrice());
    }

    @Test
    public void testPriceAsString() {
        bookInStock = new BookInStock(isbn, price);
        assertEquals("$29.99", bookInStock.priceAsString());
    }

    @Test
    public void testEmptyIsnb() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BookInStock("", price);
        });
    }

    @Test
    public void testNullIsnb() {
        assertThrows(NullPointerException.class, () -> {
            new BookInStock(null, price);
        });
    }

    @Test
    public void testNullPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BookInStock(isbn, null);
        });
    }
}
