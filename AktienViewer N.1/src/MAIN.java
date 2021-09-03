
public class MAIN {
    public static void main(String[] args) {
        GENERATOR.createDayData();
        GENERATOR.createWeekData();
        GENERATOR.createMonthData();
        GENERATOR.createYearData();

        CHART.createChart();
        new UI();

    }
}
