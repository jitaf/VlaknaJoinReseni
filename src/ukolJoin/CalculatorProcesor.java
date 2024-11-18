package ukolJoin;

public class CalculatorProcesor {
    public double calculateResult(double base1, double power1, double base2, double power2) {
        double result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */

        PowerCalculatingThread item1Calculator = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread item2Calculator = new PowerCalculatingThread(base2, power2);

        Thread vlakno1 = new Thread(item1Calculator);

        Thread vlakno2 = new Thread(item2Calculator);

        vlakno1.start();
        vlakno2.start();

        try {
            vlakno1.join();
            vlakno2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = item1Calculator.getResult() + item2Calculator.getResult();



        return result;
    }
}
