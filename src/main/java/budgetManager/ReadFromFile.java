package budgetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public static List<Purchase> readFromFile() {
        try {
            File myObj = new File("src/main/java/budgetManager/PurchasesFile.txt");
            Scanner myReader = new Scanner(myObj);
            List<Purchase> result = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result = new ArrayList(Arrays.asList(data.substring(1, data.length() - 1).replaceAll("\\s", "").split(",")));
            }
            myReader.close();
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
            return null;
        }
    }
}
