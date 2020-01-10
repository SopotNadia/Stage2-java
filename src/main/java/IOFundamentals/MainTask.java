package IOFundamentals;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainTask {
    /*Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например
    "D:/movies". Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F.
    Пример:
    Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше -
    прочитать файл и вывести в консоль следующие данные:
    Количество папок, количество файлов, среднее количество файлов в папке,среднюю длинну названия файла */

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            if (file.exists() && file.isDirectory()) {
                try (FileWriter writer = new FileWriter("data/mainTask.txt");
                     BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    writeFilesFromDirectory(file, 0, bufferedWriter);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (file.exists() && file.isFile()) {
                ArrayList<String> linesFromFile = new ArrayList<>();
                try (FileReader reader = new FileReader(args[0]);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        linesFromFile.add(line);
                    }
                    System.out.println("Amount of directories in received file: " + getAmountOfDirectories(linesFromFile));
                    System.out.println("Amount of files in received file: " + getAmountOfFiles(linesFromFile));
                    double averageAmountOfFilesInDirectory;
                    if (getAmountOfDirectories(linesFromFile) == 0) {
                        averageAmountOfFilesInDirectory = getAmountOfFiles(linesFromFile);
                    } else
                        averageAmountOfFilesInDirectory = getAmountOfFiles(linesFromFile) / getAmountOfDirectories(linesFromFile);
                    System.out.println("Average amount of files in directory in received file: " + averageAmountOfFilesInDirectory);
                    System.out.print("Average length of file name in received file: ");
                    System.out.print(String.format("%5.2f", getAverageLength(linesFromFile, getAmountOfFiles(linesFromFile))).replace(",", "."));

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You should enter a directory path or a txt-file name like a command-line argument");
        }
    }

    private static void writeFilesFromDirectory(File directory, int indent, BufferedWriter bufferedWriter) throws IOException {
        {
            StringBuilder emptyGap = new StringBuilder();
            String emptyGapForDirectories = "";
            for (int i = 0; i < indent; i++) {
                emptyGap.append("    ");
            }
            if (indent > 0) {
                emptyGapForDirectories = emptyGap + "|-----";
            }
            bufferedWriter.write(emptyGapForDirectories + directory.getName());
            bufferedWriter.newLine();
            try {
                for (File file : Objects.requireNonNull(directory.listFiles(File::isDirectory))) {
                    writeFilesFromDirectory(file, indent + 1, bufferedWriter);
                }

                for (File file : Objects.requireNonNull(directory.listFiles(File::isFile))) {
                    bufferedWriter.write(emptyGap + "|    " + file.getName());
                    bufferedWriter.newLine();
                }
            } catch (Exception e) {
                System.out.println("You don't have an access");
            }
        }
    }

    private static int getAmountOfDirectories(ArrayList<String> list) {
        int amountOfDirectories = 0;
        for (String line : list) {
            if (line.contains("|-")) {
                amountOfDirectories++;
            }
        }
        return amountOfDirectories;
    }

    private static int getAmountOfFiles(ArrayList<String> list) {
        int amountOfFiles = 0;
        for (String line : list) {
            if (line.contains("|  ")) {
                amountOfFiles++;
            }
        }
        return amountOfFiles;
    }

    private static double getAverageLength(ArrayList<String> list, int amountOfFiles) {
        double lengthAllFiles = 0;
        for (String line : list) {
            if (line.contains("|  ")) {
                lengthAllFiles += line.replaceAll("\\s*[|]\\s*", "").length();
            }
        }
        return lengthAllFiles / amountOfFiles;
    }
}

