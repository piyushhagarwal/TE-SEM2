public class ElectricityBillCalculator {

    public static Decimal calculateBill(Decimal unitsConsumed, Decimal ratePerUnit) {
        Decimal billAmount = unitsConsumed * ratePerUnit;
        return billAmount;
    }

    public static void main(){
        Decimal unitsConsumed = 250;
        Decimal ratePerUnit = 5.75;
        
        Decimal billAmount = ElectricityBillCalculator.calculateBill(unitsConsumed, ratePerUnit);
        System.debug('Electricity Bill: $' + billAmount);
    }

}