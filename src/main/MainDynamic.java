package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tinhngo on 9/22/17.
 */
public class MainDynamic {

    public static void main(String[] args) {
        writeFileInLine("file.inp", "9", "1 2 9 4 5 4 7 8 3");
        readFileInLine("file.inp");
    }

    public static void writeFile(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) {
        try(Stream<String> lines = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
            lines.forEachOrdered(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileInLine(String path) {
        Charset charset = Charset.forName("UTF-8");
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path),charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineVariable = line.split(" ");
                System.out.println("");
                for(int i = 0; i < lineVariable.length; i++) {
                    System.out.print(lineVariable[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileInLine(String fileName, String n,String content) {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(n);
            writer.println(content);
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public static void fileReaderLine(String path) {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
