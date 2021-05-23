package sample;


import java.math.BigDecimal;

public class Driver {

    public static void main(String... s) {
        double d = 0;

        BigDecimal decimal = new BigDecimal(0.00000000010001599549);


//        System.out.println(Math.floor(d));
        System.out.println(decimal.compareTo(BigDecimal.ZERO) > 0);
    }


}
