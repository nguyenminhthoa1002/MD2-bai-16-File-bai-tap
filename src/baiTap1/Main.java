package baiTap1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> listSource = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int sum = 0;

    public static void main(String[] args) {
        readDataFromFile("D:\\Module 2\\bai-16-File\\bai-tap\\src\\baiTap1\\source file.txt");
        writeDataToFile("D:\\Module 2\\bai-16-File\\bai-tap\\src\\baiTap1\\target file", listSource, calCharacters(listSource));
    }

    public static void readDataFromFile(String path) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(path);
            if (!file.exists() || file == null) {
                throw new FileNotFoundException();
            }
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                listSource.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exception1) {
            exception1.printStackTrace();
        } catch (IOException exception2) {
            exception2.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writeDataToFile(String path, List<String> listSource, String characters) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (String source : listSource) {
                bufferedWriter.write(source);
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }
            bufferedWriter.write(characters);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String calCharacters(List<String> listSource) {
        for (String character : listSource) {
            sum += character.length();
        }
        return "Total characters: " + sum;
    }
}