package gb.javaproject;
import java.io.FileReader;
import java.io.BufferedReader;
public class Task3 {
    public static void main(String[] args) {
        try {
            BufferedReader freader = new BufferedReader(new FileReader("dataJSon1.txt"));
            String fline;
            while ((fline = freader.readLine()) != null) {
                System.out.println(ParseJson(fline));
            }
            freader.close();
         } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static StringBuilder ParseJson(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        String line4 = line3.replace("[", "");
        String line5 = line4.replace("]", "");
        String line6 = line5.replace(":", ",");
        StringBuilder output = new StringBuilder("");
        String [] temp = line6.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("фамилия")) {
                output.append("Студент " + temp[i + 1] + " ");
            } else if (temp[i].equals("оценка")) {
                output.append("получил " + temp[i + 1] + " ");
            } else if (temp[i].equals("предмет")) {
                output.append("по предмету " + temp[i + 1] + "\n");
            }
        }
        return output;
    }
}

