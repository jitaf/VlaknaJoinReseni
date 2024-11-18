package ukolJoin;

public class PowerCalculatingThread implements Runnable {
    private double result = 1;
    private double base;
    private double power;

    public PowerCalculatingThread(double base, double power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
           /*
           Implementation the calculation of result = base ^ power
           */
        result = Math.pow(base, power);
    }

    public double getResult() { return result; }
}
