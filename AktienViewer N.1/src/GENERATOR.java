import java.util.Random;

public class GENERATOR {
    static Random rd;
    public static int generatedData[];
    public static int generatorLenght;

    public static void main(String[] args) {
        new GENERATOR();
    }


    GENERATOR(){
        generatorLenght = 31;
        rd = new Random();
        generatedData = new int[generatorLenght];
        for (int i = 0; i < generatorLenght; i++) {
            generatedData[i] = rd.nextInt(10);

        }



    }
}
