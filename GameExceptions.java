// Власні виключення
class InvalidGameModeException extends Exception {
    public InvalidGameModeException(String message) {
        super(message);
    }
}

class InvalidPlayerNameException extends Exception {
    public InvalidPlayerNameException(String message) {
        super(message);
    }
}

class InvalidCoordinateFormatException extends Exception {
    public InvalidCoordinateFormatException(String message) {
        super(message);
    }
}

class InvalidCoordinateRangeException extends Exception {
    public InvalidCoordinateRangeException(String message) {
        super(message);
    }
}

public class GameExceptions {

    // Метод валідації режиму гри
    public static boolean validateGameMode(String choice) throws InvalidGameModeException {
        if (choice == null || choice.isEmpty()) {
            throw new InvalidGameModeException("Вибір режиму не може бути порожнім");
        }

        if (!choice.equals("1") && !choice.equals("2")) {
            throw new InvalidGameModeException("Невірний режим гри. Обирайте 1 або 2");
        }

        return choice.equals("2");
    }

    // Метод валідації імені гравця (використовує масив)
    public static String validatePlayerName(String name, int playerNumber) throws InvalidPlayerNameException {
        if (name == null) {
            throw new InvalidPlayerNameException("Ім'я гравця " + playerNumber + " не може бути null");
        }

        if (name.isEmpty()) {
            return "User " + playerNumber;
        }

        if (name.length() > 50) {
            throw new InvalidPlayerNameException("Ім'я гравця " + playerNumber + " занадто довге (максимум 50 символів)");
        }

        // Перевірка на тільки порожні символи (використовуємо масив)
        char[] chars = name.toCharArray();
        boolean hasNonSpace = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i] != '\t') {
                hasNonSpace = true;
                break;
            }
        }

        if (!hasNonSpace) {
            throw new InvalidPlayerNameException("Ім'я гравця " + playerNumber + " не може бути порожнім");
        }

        return name;
    }

    // Метод парсингу координат (використовує масив)
    public static int[] parseCoordinates(String input) throws InvalidCoordinateFormatException, InvalidCoordinateRangeException {
        if (input == null || input.isEmpty()) {
            throw new InvalidCoordinateFormatException("Координати не може бути порожними");
        }

        if (input.length() != 2) {
            throw new InvalidCoordinateFormatException("Формат: Літера з цифрою (типу A1)");
        }

        char letter = input.charAt(0);
        char digit = input.charAt(1);

        // Перевірка літери (використовуємо масив)
        char[] validLetters = {'A', 'B', 'C'};
        boolean validLetter = false;
        for (int i = 0; i < validLetters.length; i++) {
            if (letter == validLetters[i]) {
                validLetter = true;
                break;
            }
        }

        if (!validLetter) {
            throw new InvalidCoordinateFormatException("Літера повинна бути A, B або C");
        }

        // Перевірка цифри (використовуємо масив)
        char[] validDigits = {'1', '2', '3'};
        boolean validDigit = false;
        for (int i = 0; i < validDigits.length; i++) {
            if (digit == validDigits[i]) {
                validDigit = true;
                break;
            }
        }

        if (!validDigit) {
            throw new InvalidCoordinateFormatException("Цифра повинна бути 1, 2 або 3");
        }

        int col = letter - 'A';
        int row = digit - '1';

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new InvalidCoordinateRangeException("Координати поза полем");
        }

        return new int[]{col, row};
    }
}
