public class Main {
    public static boolean matchKeyCombo(String sequence) {
        if (sequence == null || sequence.isEmpty()) {
            return true;  // If the sequence is empty or null, both occurrences are 0.
        }

        // Convert the input sequence to lowercase to make it case-insensitive
        sequence = sequence.toLowerCase();

        // Count the occurrences of 'qee' and 'zcc' in the lowercase sequence
        int countQEE = 0;
        int countZCC = 0;

        for (int i = 0; i < sequence.length() - 2; i++) {
            String combo = sequence.substring(i, i + 3);
            if (combo.equals("qee")) {
                countQEE++;
            } else if (combo.equals("zcc")) {
                countZCC++;
            }
        }

        return countQEE == countZCC;
    }

    public static void main(String[] args) {
        System.out.println(matchKeyCombo("QEEAZCC")); // Should return true
    }
}