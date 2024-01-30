import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        String placeholder = "Oh! Hi there! I see you're interested in what am i doing!\n" +
                "Well, I was trying to create my own file extension in this one\n" +
                "It's not really that effective and takes more space than just plain .txt file\n" +
                "But that was just an attempt so idc.\n" +
                "Maybe in the future i'll improve it\n" +
                "And make it like a real extension with a purpose";
        EvrnFile evrnFile = new EvrnFile();

        evrnFile.createFile("MyNewFile");
        evrnFile.writeToFile("MyNewFile.evrn", placeholder);
        evrnFile.readFile("MyNewFile.evrn");
    }
}
