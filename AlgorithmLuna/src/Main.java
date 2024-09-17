import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();
        String[] array = cardNumber.split("");

        char firstNumber = cardNumber.charAt(0);
        String typeOfCard = getTypeOfCard(firstNumber);
        if (typeOfCard.equals("Invalid")) {
            System.out.println("Неверный тип карты");
            return;
        } else {
            System.out.println(typeOfCard);
        }

        if (!validAmount(cardNumber)) {
            System.out.println("Неверное количество цифр!");
            return;
        }

        if (luna(array)) {
            System.out.println("Карта валидна");
        }
        else {
            System.out.println("Карта невалидна");
        }
    }

    public static String getTypeOfCard(char firstNumber) {
        switch (firstNumber) {
            case '4': return "Visa";
            case '5': return "Mastercard";
            case '3': return "Amex";
            default: return "Invalid";
        }
    }

    public static boolean validAmount(String cardNumber) {
        return cardNumber.length() == 16 || cardNumber.length() == 15;
    }

    public static boolean luna(String[] array){
        int sum = 0;
        boolean digitToDouble = false;

        for (int i = array.length - 1; i >= 0; i--) {
            int number = Integer.parseInt(array[i]);

            if (digitToDouble) {
                number *= 2;

                if (number > 9) {
                    number -= 9;
                }
            }

            sum += number;
            digitToDouble = !digitToDouble;
        }

        return sum % 10 == 0;
    }
}