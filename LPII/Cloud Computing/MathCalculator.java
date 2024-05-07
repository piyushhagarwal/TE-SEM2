public class MathCalculator {

    public static void add(Decimal a, Decimal b) {
        system.debug(a + b);
    }

    public static void subtract(Decimal a, Decimal b) {
        system.debug(a - b);
    }

    public static void multiply(Decimal a, Decimal b) {
        system.debug(a * b);
    }

    public static void divide(Decimal a, Decimal b) {
        if (b == 0) {
            system.debug('Cannot divide by zero');
        }
        system.debug(a / b);
    }

    public static void main() {
        multiply(2, 5);
    }

}