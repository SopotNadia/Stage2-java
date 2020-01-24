package IOFundamentals;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FirstOptional {
    public static void main(String[] args) {
        //Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
        int[] arrayWithNumbers = new int[10];
        try (FileWriter writer = new FileWriter("src/main/resources/data/firstTask.txt", false)) {
            for (int i = 0; i < 10; i++) {
                arrayWithNumbers[i] = (int) (Math.random() * 100);
                writer.write(Integer.toString(arrayWithNumbers[i]));
                writer.write(" ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        File file = new File("src/main/resources/data/firstTask.txt");
        String[] arrayFromFileWithNumbers = new String[10];
        try (Scanner scanner = new Scanner(file)) {
            arrayFromFileWithNumbers = scanner.nextLine().split(" ");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int[] arrayForSort = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayForSort[i] = Integer.parseInt(arrayFromFileWithNumbers[i]);
        }
        Arrays.sort(arrayForSort);
        try (FileWriter writer = new FileWriter("src/main/resources/data/firstTask.txt", false)) {
            writer.write(Arrays.toString(arrayForSort));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


