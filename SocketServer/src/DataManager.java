import java.io.*;
import java.util.Scanner;

public class DataManager {

    Stuff p1 = new Stuff("shampoo", 30);
    Stuff p2 = new Stuff("dog collar", 60);
    Stuff p3 = new Stuff("smartheart", 40);



    public void createNewFile() {
        try {
            File myObj = new File("Stock.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void fileWriter(){
        try {
            FileWriter myWriter = new FileWriter("Stock.txt");

            myWriter.write(String.valueOf(p1));
            myWriter.write(String.valueOf(p2));
            myWriter.write(String.valueOf(p3));

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public String fileReader() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File("Stock.txt"));
            String text = "";
            while (scanner.hasNextLine()) {
               String line = scanner.nextLine();
               text += "Name: " + line.split(":")[0] + ", Amount: " + line.split(":")[1] + "\n";
            }
            scanner.close();
            return text;
    }


}
