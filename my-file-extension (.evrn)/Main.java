import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        createFile("everrynn");
        writeToFile("everrynn.evrn", "Some kind of encrypted text");
        readFile("everrynn.evrn");
    }
    static void createFile(String name){
        try{
            File file = new File(name+".evrn");
            if(file.createNewFile()){
                System.out.println("A file has been created!: " + file.getName());
            } else {
                System.out.println("The file already exist");
            }
        } catch (IOException e){
            System.out.println("An error occured!");
        }
    }
    static void writeToFile(String filename, String text){
        try {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            FileWriter writer = new FileWriter(filename);
            for(Character i : text.toCharArray()){
                numbers.add((int) i*2);
            }
            String arrayString = numbers.stream().map(Object::toString).collect(Collectors.joining("."));
            writer.write(arrayString);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occured!");
        }
    }

    static void readFile(String filename){
        File file = new File(filename);
        try{
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                System.out.println("Decrypted: "+ decrypt(nextLine));
            }
        } catch (IOException e){
            System.out.println("An error occured!");
        }
    }
    static String decrypt(String text){
        ArrayList<String> letters = new ArrayList<String>();
        String[] numbers = text.split("\\.");
        for(String letter : numbers){
            int number = Integer.parseInt(letter)/2;
            String asciiLetter = Character.toString((char) number);
            letters.add(asciiLetter);
        }
        return letters.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
