package ip.syssrc.function;

/**
 * BigInt
 *
 * Assignment 4.2
 *
 * @author H071211045 - MUHAMMAD SOFYAN DAUD PUJAS <gaero38@gmail.com>
 *
 */
public class BigInt {
    public static void main(String[] args) {
        int[] n = {5, 9, 1, 9, 9, 9, 1, 9, 9, 9, 9, 9, 9, 9, 9,9};
        int[] m = {1, 3, 5, 7, 3, 4, 5, 1, 3, 2, 1, 8, 9, 0, 9};
        print(humanFormat(add(n, m), '-')); 
    }
    /**
     * Adds two arrays as the sum of two numbers, this method is akin to the add
     * method from BigInteger class
     *
     * @param n the array to be used as addend, first operand
     * @param m the array to be used as addend, second operand
     * @return array of integer that represents the sum of 2 numbers
     */
    public static int[] add(int[] n, int[] m) {
        int capacity = Math.max(n.length, m.length);
        int[] total = new int[capacity];
        int[] sum = n.length < m.length ? n : m;
        System.arraycopy(n.length < m.length ? m : n, 0, total, 0, capacity);

        for (int i = 1; i <= capacity; i++) {
            if (sum.length - i < 0) {
                break;
            }
            int opt = capacity - i;
            total[opt] += (int) sum[sum.length - i];
            if (opt > 0 && total[opt] > 9) { // move the remainder to previous index
                total[opt - 1] += (total[opt] / 10);
                total[opt] %= 10;
            }
        }

        if (total[0] > 9) { // as remainder require previous index, this will add more one
            int[] opt = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                opt[i] = total[i];
            }
            total = new int[capacity + 1];
            total[0] = opt[0] / 10;
            total[1] = opt[0] % 10;
            for (int i = 2; i < total.length; i++) {
                total[i] = opt[i - 1];
            }
        }
        return total;
    }

    /**
     * Format number using human readable format, separated by dot(.)
     *
     * @param nums the array that represent a big number of integer
     * @return array of char that represent the formatted number
     */
    public static char[] humanFormat(int[] nums) {
        int index = 0;
        int size = nums.length;
        int opt = nums.length - 1;
        size += (nums.length % 3 != 0) ? ((nums.length - 1) / 3) : (nums.length / 3);

        char[] separator = new char[size];
        for (int i = 1, t = index + 1; i < separator.length + 1; i++) {
            if (separator[size - 1] == '.') {
                break;
            }
            // Re-state while decreasing the statements
            index = separator.length - i;
            opt = nums.length - t;

            if (i % 4 != 0) {
                separator[index] = (char) (nums[opt] + '0');
                index = 0;
                opt = 0;
                ++t;

            } else {
                separator[index] = '.';
                index = 0;
            }

            if (separator[0] == '.') { // Reform the separator when first index shows sparate object
                separator[0] = '\0';
            }
        }
        return separator;
    }

    /**
     * Format number using human readable format with specified separator
     *
     * @param nums      the array that represent a big number of integer
     * @param separator the character to be used as separator
     * @return array of char that represent the formatted number
     */
    public static char[] humanFormat(int[] nums, char sparator) {
        int index = 0;
        int size = nums.length;
        int opt = nums.length - 1;
        size += (nums.length % 3 != 0) ? ((nums.length - 1) / 3) : (nums.length / 3);

        char[] separator = new char[size];
        for (int i = 1, t = index + 1; i < separator.length + 1; i++) {
            if (separator[size - 1] == '.') {
                break;
            }
            // Re-state while decreasing the statements
            index = separator.length - i;
            opt = nums.length - t;

            if (i % 4 != 0) {
                separator[index] = (char) (nums[opt] + '0');
                index = 0;
                opt = 0;
                ++t;

            } else {
                separator[index] = sparator;
                index = 0;
            }

            if (separator[0] == sparator) { // Reform the separator when first index shows sparate object
                separator[0] = '\0';
            }
        }
        return separator;

    }

    /**
     * Print an array into a number format .e.g. {1, 0, 5} printed as 105
     *
     * @param nums the array to be printed as number
     * @return void
     */
    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d", nums[i]);
            System.out.print((i != nums.length - 1) ? "" : "\n");
        }
    }

    /**
     * Print an array into a human readable format of numbers
     * .e.g. {'1', '_', 0, 0, 0} printed as 1_000
     *
     * @param nums the array to be printed as number
     * @return void
     */
    public static void print(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%c", chars[i]);
            System.out.print((i != chars.length - 1) ? "" : "\n");
        }
    }
}
