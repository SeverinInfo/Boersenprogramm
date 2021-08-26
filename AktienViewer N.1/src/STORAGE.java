import java.io.*;
import java.util.Scanner;

public class STORAGE {
    public static int Data[] ;



    public static void main(String[] args)  {
        new STORAGE();
        DataSaver();
        DataLoader();
    }

    STORAGE(){
        new GENERATOR();
        Data = new int[GENERATOR.generatorLenght];
        for (int i = 0; i < GENERATOR.generatorLenght; i++) {
            Data[i] = GENERATOR.generatedData[i];
        }
    }

    public static void DataSaver(){
        File file = new File("rsc/dataStorage.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Data.length; i++) {
                writer.write(Data[i] + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DataLoader(){
        File file = new File("rsc/dataStorage.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                for (int i = 0; i < Data.length; i++) {
                    Data[i] = sc.nextInt();
                }
            }
        sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
