package gb.javaproject;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;
public class Task2 {
    static File bublLog;
    static FileWriter fileWr;
    public static void main(String[] args) {
        try {
            bublLog = new File("bublLog.txt");
            fileWr = new FileWriter(bublLog);
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите количество элементов: ");
            int n = sc.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Введите %d-ый элемент массива: ", i + 1);
                numbers[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
                fileWr.write(Arrays.toString(numbers) + "\n");
            }
            fileWr.close();
            sc.close();
            System.out.println(Arrays.toString(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
