import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Storage {
    public static int[] Data = new int[300] ;
    public static File dayFile = new File("AktienViewer N.1/rsc/dayData.txt");
    public static File weekFile = new File("AktienViewer N.1/rsc/weekData.txt");
    public static File monthFile = new File("AktienViewer N.1/rsc/monthData.txt");
    public static File yearFile = new File("AktienViewer N.1/rsc/yearData.txt");

    public static void DataSaver(String timescale) {
        switch (timescale) {
            case "day" -> {
                FileWriter dwriter = null;
                try {
                    dwriter = new FileWriter(dayFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    for (int i = 0; i < Data.length; i++) {
                        Data[i] = Generator.dayData.get(i);
                        Objects.requireNonNull(dwriter).write(Data[i] + " ");
                    }
                    Objects.requireNonNull(dwriter).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "week" -> {
                FileWriter wwriter = null;
                try {
                    wwriter = new FileWriter(weekFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    for (int i = 0; i < Data.length; i++) {
                        Data[i] = Generator.weekData.get(i);
                        Objects.requireNonNull(wwriter).write(Data[i] + " ");
                    }
                    Objects.requireNonNull(wwriter).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "month" -> {
                FileWriter mwriter = null;
                try {
                    mwriter = new FileWriter(monthFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    for (int i = 0; i < Data.length; i++) {
                        Data[i] = Generator.monthData.get(i);
                        Objects.requireNonNull(mwriter).write(Data[i] + " ");
                    }
                    Objects.requireNonNull(mwriter).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "year" -> {
                FileWriter ywriter = null;
                try {
                    ywriter = new FileWriter(yearFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    for (int i = 0; i < Data.length; i++) {
                        Data[i] = Generator.yearData.get(i);
                        Objects.requireNonNull(ywriter).write(Data[i] + " ");
                    }
                    Objects.requireNonNull(ywriter).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void DataLoader(String timescale) {
        switch (timescale){
            case "day":
                try {
                    Scanner sc = new Scanner(dayFile);
                    Generator.dayData = new ArrayList<>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            Generator.dayData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "week":
                try {
                    Scanner sc = new Scanner(weekFile);
                    Generator.weekData = new ArrayList<>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            Generator.weekData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "month":
                try {
                    Scanner sc = new Scanner(monthFile);
                    Generator.monthData = new ArrayList<>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            Generator.monthData.add(Data[i]);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case "year":
                try {
                    Scanner sc = new Scanner(yearFile);
                    Generator.yearData = new ArrayList<>();
                    while (sc.hasNext()) {
                        for (int i = 0; i < Data.length; i++) {
                            Data[i] = sc.nextInt();
                            Generator.yearData.add(Data[i]);
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
