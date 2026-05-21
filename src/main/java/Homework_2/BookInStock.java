package Homework_2;

import java.util.Objects;

public class BookInStock {
    private final String isbn;

    private final double price;

    public BookInStock(String isbn, Double price) {
        if (isbn.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (Objects.isNull(price)) {
            throw new IllegalArgumentException();
        }

        this.isbn = isbn;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String priceAsString() {
        return String.format("$%.2f", price);
    }
}
