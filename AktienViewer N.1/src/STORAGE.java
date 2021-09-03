import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class STORAGE {
    public static int Data[] = new int[300] ;
    public static File dayfile = new File("rsc/dayData.txt");
    public static File weekfile = new File("rsc/weekData.txt");
    public static File monthfile = new File("rsc/monthData.txt");
    public static File yearfile = new File("rsc/yearData.txt");

    public static void DataSaver(String timescale) {
    switch (timescale){
    case "day":
        FileWriter dwriter = null;
        try {
            dwriter = new FileWriter(dayfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Data.length; i++) {
                Data[i] = GENERATOR.dayData.get(i);
                dwriter.write(Data[i] + " ");
            }
            dwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        break;

    case "week":
        FileWriter wwriter = null;
        try {
            wwriter = new FileWriter(weekfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Data.length; i++) {
                Data[i] = GENERATOR.weekData.get(i);
                wwriter.write(Data[i] + " ");
            }
            wwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        break;

    case "month":
        FileWriter mwriter = null;
        try {
            mwriter = new FileWriter(monthfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Data.length; i++) {
                Data[i] = GENERATOR.monthData.get(i);
                mwriter.write(Data[i] + " ");
            }
            mwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        break;

    case "year":
        FileWriter ywriter = null;
        try {
            ywriter = new FileWriter(yearfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Data.length; i++) {
                Data[i] = GENERATOR.yearData.get(i);
                ywriter.write(Data[i] + " ");
            }
            ywriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        break;
}
    }

    public static void DataLoader(String timescale) {
        switch (timescale){
            case "day":
                try {
                    Scanner sc = new Scanner(dayfile);
                    GENERATOR.dayData = new ArrayList<Integer>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            GENERATOR.dayData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "week":
                try {
                    Scanner sc = new Scanner(weekfile);
                    GENERATOR.weekData = new ArrayList<Integer>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            GENERATOR.weekData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "month":
                try {
                    Scanner sc = new Scanner(monthfile);
                    GENERATOR.monthData = new ArrayList<Integer>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            GENERATOR.monthData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "year":
                try {
                    Scanner sc = new Scanner(yearfile);
                    GENERATOR.yearData = new ArrayList<Integer>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            GENERATOR.yearData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
