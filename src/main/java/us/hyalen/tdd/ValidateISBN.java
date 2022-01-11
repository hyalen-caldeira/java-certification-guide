package us.hyalen.tdd;

public class ValidateISBN {
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_INSBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn) {
        int length = isbn.length();

        if (length == SHORT_ISBN_LENGTH)
            return isThisAValidShortISBN(isbn);
        else if (length == LONG_ISBN_LENGTH)
            return isThisAValidLongISBN(isbn);

        throw new NumberFormatException("ISBN must contains 10 or 13 digits.");
    }

    private boolean isThisAValidShortISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            char c = isbn.charAt(i);

            if (!Character.isDigit(c)) {
                if (i == SHORT_ISBN_LENGTH - 1 && c != 'X')
                    throw new NumberFormatException("ISBN must only contains digits.");
                else
                    total += 10;
            } else
                total += Character.getNumericValue(c) * (SHORT_ISBN_LENGTH - i);
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isThisAValidLongISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            char digit = isbn.charAt(i);

            if (!Character.isDigit(digit)) {
                if (i == LONG_ISBN_LENGTH - 1 && digit != 'X')
                    throw new NumberFormatException("ISBN must only contains digits.");
                else {
                    if (i % 2 == 0)
                        total += Character.getNumericValue(digit);
                }
            } else {
                if (i % 2 == 0)
                    total += Character.getNumericValue(digit);
                else
                    total += Character.getNumericValue(digit) * 3;
            }
        }

        return total % LONG_INSBN_MULTIPLIER == 0;
    }
}
