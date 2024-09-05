import java.util.Arrays;

public class Main {

    public static int[] array = { 5, 1, 3, 2, 7 };
    public static int sum = 10;

    public static void main(String[] args) {
        Main main = new Main();
        main.findToSum(array, sum);
        System.out.println("Рекурсия проведена. Ответ: " + can(1));
    }

    public int[] findToSum(int[] array, int sum) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int foundedSum = array[leftIndex] + array[rightIndex];
            if (foundedSum == sum) {
                System.out.println("Ответ: " + Arrays.toString(new int[] {array[leftIndex], array[rightIndex]} ));
                return new int[] {array[leftIndex], array[rightIndex]};
            }
            if (foundedSum > sum)
                rightIndex--;
            else leftIndex++;
        }
        return new int[0];
    }

    public static boolean can(int sum) {
        if (sum == 5 || sum == 3) {
            return true;
        }
        if (sum >= 3 && can(sum - 3)) {
            return true;
        }
        return sum >= 5 && can(sum - 5);
    }
}