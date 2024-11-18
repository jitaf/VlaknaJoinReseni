package ukolJoin;

public class UkolJoin {
    public static void main(String[] args) throws InterruptedException{
        CalculatorProcesor calculatorProcesor = new CalculatorProcesor();
        double result = calculatorProcesor.calculateResult(2, 4, 9, 2);
        System.out.println(result);

    }
}

