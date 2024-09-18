public class Validator {

    public boolean isLengthValid(String cardNumber) {
        return cardNumber.length() == 16 || cardNumber.length() == 15;
    }

    public Type getTypeOfCard(String cardNumber) {
        switch (cardNumber.charAt(0)) {
            case '4': return Type.VISA;
            case '5': return Type.MASTERCARD;
            case '3': return Type.AMEX;
            default: return Type.INVALID;
        }
    }

    public boolean isLuhnValid(String cardNumber) {
        String[] array = cardNumber.split("");
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
