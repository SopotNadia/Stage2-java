package IOFundamentals;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FifthOptional {
    //В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов,
    // которые имеют средний балл более 7.
    public static void main(String[] args) {
        ArrayList linesFromFile = new ArrayList<>();
        try (FileReader reader = new FileReader("src/main/resources/data/fifthTask.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.replace("[", "").replace("]", "").replace(",", "").split(" ");
                double averageMark = getAverageMark(array);
                if (averageMark > 7) {
                    String student = array[0];
                    array[0] = student.toUpperCase();
                }
                linesFromFile.add(Arrays.toString(array));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("src/main/resources/data/fifthTask.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Object array : linesFromFile) {
                bufferedWriter.write(array.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double getAverageMark(String[] array) {
        double sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum += Integer.parseInt(array[i]);
        }
        return sum / (array.length - 1);
    }
}
