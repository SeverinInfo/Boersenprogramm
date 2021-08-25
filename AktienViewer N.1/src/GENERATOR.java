import java.util.Random;

public class GENERATOR {
    static Random rd;
    public static int generatedData[];
    public static int generatorLenght;

    public static void main(String[] args) {
        new GENERATOR();
    }


    GENERATOR(){
        generatorLenght = 30;
        rd = new Random();
        generatedData = new int[generatorLenght];
        for (int i = 0; i < generatedData.length; i++) {
            generatedData[i] = 1 + rd.nextInt(100);

        }



    }
}
