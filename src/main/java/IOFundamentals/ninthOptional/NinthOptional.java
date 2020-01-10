package IOFundamentals.ninthOptional;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NinthOptional {
    //Из текста Java-программы удалить все виды комментариев
    private static String filePath;

    public static void main(String[] args) {
        ArrayList<String> linesFromFile = getLinesFromFile();
        StringBuilder linesFromFileForDeletingComments = new StringBuilder();
        for (String line : linesFromFile) {
            linesFromFileForDeletingComments.append(line);
            linesFromFileForDeletingComments.append("\n");
        }
        StringBuilder linesAfterDeletingComments = deleteComments(linesFromFileForDeletingComments);
        try (FileWriter writer = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(linesAfterDeletingComments.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static StringBuilder deleteComments(StringBuilder string) {
        Pattern oneLineComment = Pattern.compile("\\/\\/.*");
        Matcher matcher = oneLineComment.matcher(string);
        while (matcher.find()) {
            string = new StringBuilder(matcher.replaceAll(""));
        }
        Pattern multiLineComment = Pattern.compile("[/]\\*.*(?:.|[\\n\\r])*?\\*[/]");
        Matcher otherMatcher = multiLineComment.matcher(string);
        while (otherMatcher.find()) {
            string = new StringBuilder(otherMatcher.replaceAll(""));
        }
        return string;
    }

    private static ArrayList<String> getLinesFromFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path where you want to delete all comments");
        filePath = scanner.nextLine();
        ArrayList<String> linesFromFile = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(filePath + " doesn't exist");
            getLinesFromFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  linesFromFile;
    }
}
