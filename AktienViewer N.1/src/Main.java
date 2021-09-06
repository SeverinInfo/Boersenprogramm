
public class Main {
    public static void main(String[] args) {
        Generator.createDayData();
        Generator.createWeekData();
        Generator.createMonthData();
        Generator.createYearData();

        Chart.createChart();
        new UI();

    }
}
