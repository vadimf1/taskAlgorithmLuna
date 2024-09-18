import java.util.Scanner;

public class Menu {
    public void start() {
        String cardNumber = getCardNumber();

        Card card = createCard(cardNumber);

        if (!isLengthValid(card)) {
            return;
        }

        if (!getCardType(card)) {
            return;
        }

        isLuhnValid(card);
    }

    private String getCardNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();
        scanner.close();

        return cardNumber;
    }

    private Card createCard(String cardNumber) {
        Validator validator = new Validator();

        return new Card(cardNumber, validator.getTypeOfCard(cardNumber));
    }

    private boolean isLengthValid(Card card) {
        Validator validator = new Validator();

        if (!validator.isLengthValid(card.number)) {
            System.out.println("Неверное количество цифр!");
            return false;
        }

        return true;
    }

    private boolean getCardType(Card card) {
        if (card.type == Type.INVALID) {
            System.out.println("Неверный тип карты");
            return false;
        } else {
            System.out.println(card.type);
            return true;
        }
    }

    private boolean isLuhnValid(Card card) {
        Validator validator = new Validator();

        if (validator.isLuhnValid(card.number)) {
            System.out.println("Карта валидна");
            return true;
        }
        else {
            System.out.println("Карта невалидна");
            return false;
        }
    }
}
