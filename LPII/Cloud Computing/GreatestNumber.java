public class GreatestNumber {

    public static Integer findGreatest(Integer num1, Integer num2, Integer num3) {
        Integer greatest = num1;

        if (num2 > greatest) {
            greatest = num2;
        }

        if (num3 > greatest) {
            greatest = num3;
        }

        return greatest;
    }

    public static void main(){
        Integer number1 = 10;
        Integer number2 = 25;
        Integer number3 = 15;
        
        Integer greatestNumber = GreatestNumber.findGreatest(number1, number2, number3);
        System.debug('The greatest number is: ' + greatestNumber);
    }

}