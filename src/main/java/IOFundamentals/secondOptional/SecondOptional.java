package IOFundamentals.secondOptional;

import java.io.*;
import java.util.ArrayList;

public class SecondOptional {
    //Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
    public static void main(String[] args) {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        try (FileReader reader = new FileReader("src/IOFundamentals/ForReadingSecondTask.java");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringsFromFile.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (String string : stringsFromFile) {
            if (string.contains("public")) {
                int index = stringsFromFile.indexOf(string);
                StringBuilder newString = new StringBuilder(string.replaceAll("public", "private"));
                stringsFromFile.set(index, newString.toString());
            }
        }
        try (FileWriter writer = new FileWriter("src/IOFundamentals/ForReadingSecondTask.java")) {
            writer.write("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("src/IOFundamentals/ForReadingSecondTask.java")) {
            for (String changedString : stringsFromFile) {
                writer.write(changedString + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
