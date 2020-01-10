package IOFundamentals;

import java.io.*;
import java.util.ArrayList;

public class TenthOptional {
    //Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
    public static void main(String[] args) {
        ArrayList<String> linesFromFile = new ArrayList<>();
        StringBuilder linesAfterChanging = new StringBuilder();
        try (FileReader reader = new FileReader("data/tenthTask.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linesFromFile.add(line);
            }
            for (String string : linesFromFile) {
                String[] arrayLines = string.split(" ");
                String temp = arrayLines[0];
                arrayLines[0] = arrayLines[arrayLines.length - 1];
                arrayLines[arrayLines.length - 1] = temp;
                for (int i = 0; i < arrayLines.length; i++) {
                    if (arrayLines[i].equals("")) break;
                    linesAfterChanging.append(arrayLines[i] + " ");
                }
                linesAfterChanging.append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("data/tenthTask.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(linesAfterChanging.toString());
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
