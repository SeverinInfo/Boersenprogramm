import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Generator {
    static Random rd;
    public static ArrayList <Integer> dayData = new ArrayList<>();
    public static ArrayList <Integer> weekData = new ArrayList<>();
    public static ArrayList <Integer> monthData = new ArrayList<>();
    public static ArrayList <Integer> yearData = new ArrayList<>();
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
            if(Storage.dayFile.length() == 0){
                System.out.print("Dempty");
                dayData = new ArrayList<>();
                for (int i = 0; i < 300; i++) {
                    dayData.add(0);
                }
                Storage.DataSaver("day");
            }
            else{
                System.out.print("Dfull");
                Storage.DataLoader("day");
            }
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Storage.DataLoader("day");
                        rd = new Random();
                        dayData.remove(0);
                        dayData.add(rd.nextInt(Chart.scale + 1));
                        //System.out.println(dayData.toString());
                    Storage.DataSaver("day");
                }
            }, 0, updateTimeDay);
        }

    public static void createWeekData() {
        if(Storage.weekFile.length() == 0){
            System.out.print("Wempty");
            weekData = new ArrayList<>();
            for (int i = 0; i < 300; i++) {
                weekData.add(0);
            }
            Storage.DataSaver("week");
        }
        else{
            System.out.print("Wfull");
            Storage.DataLoader("week");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Storage.DataLoader("week");
                rd = new Random();
                weekData.remove(0);
                weekData.add(rd.nextInt(Chart.scale + 1));
                //System.out.println(weekData.toString());
                Storage.DataSaver("week");
            }
        }, 0, updateTimeWeek);
    }

    public static void createMonthData() {
        if(Storage.monthFile.length() == 0){
            System.out.print("Mempty");
            monthData = new ArrayList<>();
            for (int i = 0; i < 300; i++) {
                monthData.add(0);
            }
            Storage.DataSaver("month");
        }
        else{
            System.out.print("Mfull");
            Storage.DataLoader("month");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Storage.DataLoader("month");
                rd = new Random();
                monthData.remove(0);
                monthData.add(rd.nextInt(Chart.scale + 1));
                //System.out.println(monthData.toString());
                Storage.DataSaver("month");
            }
        }, 0, updateTimeMonth);
    }

    public static void createYearData() {
        if(Storage.yearFile.length() == 0){
            System.out.print("Yempty");
            yearData = new ArrayList<>();
            for (int i = 0; i < 300; i++) {
                yearData.add(0);
            }
            Storage.DataSaver("year");
        }
        else{
            System.out.print("Yfull");
            Storage.DataLoader("year");
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Storage.DataLoader("year");
                rd = new Random();
                yearData.remove(0);
                yearData.add(rd.nextInt(Chart.scale + 1));
                //System.out.println(yearData.toString());
                Storage.DataSaver("year");
            }
        }, 0, updateTimeYear);
    }

}










