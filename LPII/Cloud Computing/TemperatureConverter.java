public class TemperatureConverter {

    public static Decimal celsiusToFahrenheit(Decimal celsius) {
        Decimal fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }

    public static void main(){
        Decimal celsius = 25;

        Decimal fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        System.debug('Temperature in Fahrenheit: ' + fahrenheit);
    }
}