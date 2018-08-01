package niklas.konverter;

import android.widget.EditText;

public class Currency {

    private ECurrency eCurrency;
    private EditText editText;
    private CurrencyWatcher watcher;

    public Currency(ECurrency eCurrency, EditText editText, CurrencyWatcher watcher) {
        this.eCurrency = eCurrency;
        this.editText = editText;
        this.watcher = watcher;

    }

    public double calc(double value, ECurrency convertCurrency) {
        return (value / getConversion(convertCurrency) * getConversion(getECurrency()));
    }

    public CurrencyWatcher getWatcher() {
        return watcher;
    }

    public EditText getField() {
        return editText;
    }

    public ECurrency getECurrency() {
        return eCurrency;
    }


    private double getConversion(ECurrency enumCurrency) {
        double result = 0;

        switch (enumCurrency) {
            case EURO: result = ICurrency.EURO; break;
            case PHP: result = ICurrency.PHP; break;
        }

        return result;
    }

}
