public class NumbersToText {

    public static String numbersToLetters(String input) {
        if (input == null || input.isEmpty()) {
            return "";  // Handle empty input
        }

        String[] parts = input.split("\\+");  // Split input into words
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            String[] numbers = part.split(" ");  // Split each word into numbers
            StringBuilder word = new StringBuilder();

            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if (num == 1) {
                    word.append("A");
                } else if (num == 2) {
                    word.append("B");
                } else if (num == 26) {
                    word.append("Z");
                } else if (num >= 3 && num <= 25) {
                    char letter = (char) ('A' + num - 3);
                    word.append(letter);
                }
            }

            if (result.length() > 0) {
                result.append(" ");  // Add space between words
            }
            result.append(word.toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "20 5 19 20+4 15 13 5";  // Change this to your input string
        String result = numbersToLetters(input);
        System.out.println(result);
    }
}
