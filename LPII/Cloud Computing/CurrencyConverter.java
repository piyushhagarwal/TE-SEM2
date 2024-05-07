public class CurrencyConverter {

    // Exchange rates (for demonstration purposes)
    private static final Map<String, Decimal> EXCHANGE_RATES = new Map<String, Decimal>{
        'USD' => 1.0,
        'EUR' => 0.92,
        'GBP' => 0.81,
        'JPY' => 133.45,
        'AUD' => 1.39
    };

    public static Decimal convert(Decimal amount, String fromCurrency, String toCurrency) {
        // Validate input currencies
        if (!EXCHANGE_RATES.containsKey(fromCurrency.toUpperCase()) || !EXCHANGE_RATES.containsKey(toCurrency.toUpperCase())) {
            throw new CurrencyException('Invalid currency code');
        }
        
        // Convert amount from base currency to target currency
        Decimal baseAmount = amount / EXCHANGE_RATES.get(fromCurrency.toUpperCase());
        Decimal convertedAmount = baseAmount * EXCHANGE_RATES.get(toCurrency.toUpperCase());
        
        return convertedAmount;
    }

    public class CurrencyException extends Exception {
    }

    public static void main(){
        try {
            Decimal amount = 100;
            String fromCurrency = 'USD';
            String toCurrency = 'EUR';
            
            Decimal convertedAmount = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
            System.debug('$' + amount + ' ' + fromCurrency + ' = €' + convertedAmount + ' ' + toCurrency);
        } catch (CurrencyConverter.CurrencyException ex) {
            System.debug('Error: ' + ex.getMessage());
        }
    }
}