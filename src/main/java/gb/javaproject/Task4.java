package gb.javaproject;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Task4 {
    static File calcLog;
    static FileWriter fileWr;
    public static void main(String[] args) {

        try
        {
            calcLog = new File("calcLog.txt");
            fileWr = new FileWriter(calcLog);
            Scanner scn = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            if (scn.hasNextDouble()) {
                double num1 =scn.nextDouble();
                System.out.print("Введите знак операции (+, -, * или /): ");
                char operation = scan.nextLine().charAt(0);
                System.out.print("Введите второе число: ");
                if (scn.hasNextDouble()) {
                    double num2 = scn.nextDouble();
                    switch (operation) {
                        case '+':
                            System.out.printf("Сумма = %.2f", (num1 + num2));
                            fileWr.write("Сумма чисел " + num1 + " и " + num2 + " равна " + (num1 + num2) + "\n");
                            break;
                        case '-':
                            System.out.printf("Разность = %.2f", (num1 - num2));
                            fileWr.write("Разность чисел " + num1 + " и " + num2 + " равна " + (num1 + num2) + "\n");
                            break;
                        case '*':
                            System.out.printf("Произведение = %.2f", (num1 * num2));
                            fileWr.write("Произведение чисел " + num1 + " и " + num2 + " равно " + (num1 + num2) + "\n");
                            break;
                        case '/':
                            if (num2 == 0) {
                                System.out.println("\nНа 0 делить нельзя");
                                fileWr.write("Делитель равен 0\n");
                                break;
                            }
                            System.out.printf("Частное = %.2f", (num1 / num2));
                            fileWr.write("Частное чисел " + num1 + " и " + num2 + " равно " + (num1 + num2) + "\n");
                            break;
                        default:
                            System.out.println("\nВведен неверный знак операции");
                            fileWr.write("Неверный знак операции\n");
                    }
                } else {
                    System.out.println("\nВведено неверное число");
                    fileWr.write("Второе число введено некорректно\n");
                }
            } else {
                System.out.println("\nВведено неверное число");
                fileWr.write("Первое число введено некорректно\n");
            }
            fileWr.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
