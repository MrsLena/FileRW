package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;


public class Main {

    public static final String FILE_NAME = "1.txt";

    public static void main(String[] args) {

        read();

    }

    private static void write(List<String> list) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (String ss : list) {
                fw.write(ss);
            }
            fw.close();
        }  catch (IOException e){
            System.err.println("Error writing  2.txt");
        }
    }

    private static void read() {


        Scanner sca =new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            List<String> list = reader.lines().collect(Collectors.toList());

            ListIterator<String> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                String element = listIterator.next();

                System.out.println("Введите возраст сотрудника " + element);
                int a = sca.nextInt();
                listIterator.set(element + " - " + Integer.toString(a) + "\n");
            }

            write(list);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
