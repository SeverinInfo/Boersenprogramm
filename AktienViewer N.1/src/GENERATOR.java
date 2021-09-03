import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GENERATOR {
    static Random rd;
    public static ArrayList <Integer> dayData = new ArrayList<Integer>();
    public static ArrayList <Integer> weekData = new ArrayList<Integer>();
    public static ArrayList <Integer> monthData = new ArrayList<Integer>();
    public static ArrayList <Integer> yearData = new ArrayList<Integer>();
    public static Timer timer = new Timer();
    //public static int updateTimeDay = 288000;
    public static int updateTimeDay = 2880;
    //public static int updateTimeWeek = 2016000;
    public static int updateTimeWeek = 2016;
    //public static int updateTimeMonth = 8640000;
    public static int updateTimeMonth = 8640;
    //public static int updateTimeYear = 105120000;
    public static int updateTimeYear = 10512;

    public static void createDayData() {
            if(STORAGE.dayfile.length() == 0){
                System.out.print("Dempty");
                dayData = new ArrayList<Integer>();
                for (int i = 0; i < 300; i++) {
                    dayData.add(0);
                }
                STORAGE.DataSaver("day");
            }
            else{
                System.out.print("Dfull");
                STORAGE.DataLoader("day");
            }
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    STORAGE.DataLoader("day");
                        rd = new Random();
                        dayData.remove(0);
                        dayData.add(rd.nextInt(CHART.scale + 1));
                        //System.out.println(dayData.toString());
                    STORAGE.DataSaver("day");
                }
            }, 0, updateTimeDay);
        }

    public static void createWeekData() {
        if(STORAGE.weekfile.length() == 0){
            System.out.print("Wempty");
            weekData = new ArrayList<Integer>();
            for (int i = 0; i < 300; i++) {
                weekData.add(0);
            }
            STORAGE.DataSaver("week");
        }
        else{
            System.out.print("Wfull");
            STORAGE.DataLoader("week");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                STORAGE.DataLoader("week");
                rd = new Random();
                weekData.remove(0);
                weekData.add(rd.nextInt(CHART.scale + 1));
                //System.out.println(weekData.toString());
                STORAGE.DataSaver("week");
            }
        }, 0, updateTimeWeek);
    }

    public static void createMonthData() {
        if(STORAGE.monthfile.length() == 0){
            System.out.print("Mempty");
            monthData = new ArrayList<Integer>();
            for (int i = 0; i < 300; i++) {
                monthData.add(0);
            }
            STORAGE.DataSaver("month");
        }
        else{
            System.out.print("Mfull");
            STORAGE.DataLoader("month");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                STORAGE.DataLoader("month");
                rd = new Random();
                monthData.remove(0);
                monthData.add(rd.nextInt(CHART.scale + 1));
                //System.out.println(monthData.toString());
                STORAGE.DataSaver("month");
            }
        }, 0, updateTimeMonth);
    }

    public static void createYearData() {
        if(STORAGE.yearfile.length() == 0){
            System.out.print("Yempty");
            yearData = new ArrayList<Integer>();
            for (int i = 0; i < 300; i++) {
                yearData.add(0);
            }
            STORAGE.DataSaver("year");
        }
        else{
            System.out.print("Yfull");
            STORAGE.DataLoader("year");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                STORAGE.DataLoader("year");
                rd = new Random();
                yearData.remove(0);
                yearData.add(rd.nextInt(CHART.scale + 1));
                //System.out.println(yearData.toString());
                STORAGE.DataSaver("year");
            }
        }, 0, updateTimeYear);
    }

}










