package gb.javaproject;
import java.io.FileReader;
import java.io.BufferedReader;

public class Task1 {
    public static void main(String[] args) {
        try {
            BufferedReader freader = new BufferedReader(new FileReader("dataJSon.txt"));
            String fline = freader.readLine();
            StringBuilder resultSelect = LineInList(fline);
            System.out.println(resultSelect);
            freader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static StringBuilder LineInList(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        System.out.println(line3);
        StringBuilder result = new StringBuilder("select * from students where ");

        String [] arrayData = line3.split(", ");
        for (int i =0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if(arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(", ");
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                } else {
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                }
            }

        }
        return result;
    }
}
