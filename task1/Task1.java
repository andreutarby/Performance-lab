public class Task1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите два числа : n и m");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[]  array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        int temp = 0;

        do {
            System.out.print(array[temp]);
            temp = (temp + m - 1) % n;
        } while (temp != 0);
    }
}
