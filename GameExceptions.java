// Виключення для недоступного вибору пунктів у меню або вибору кольору/режиму гри
class InvalidMenuOptionException extends Exception {
    public InvalidMenuOptionException(String message) { 
        super(message); 
    }
}

//виключення для неправильного формату ходу
class InvalidInputFormatException extends Exception {
    public InvalidInputFormatException(String message) { 
        super(message); 
    }
}

//Виключення для виходу за межі ігрового поля
class OutOfBoundsException extends Exception {
    public OutOfBoundsException(String message) { 
        super(message); 
    }
}

//виключення для спроби зробити хід у клітинку, яка вже зайнята Х або О
class CellOccupiedException extends Exception {
    public CellOccupiedException(String message) { 
        super(message); 
    }
}
