package niklas.konverter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class CurrencyWatcher implements TextWatcher {

    private ECurrency eCurrency;
    private ArrayList<Currency> currencies;

    public CurrencyWatcher(ECurrency eCurrency, ArrayList<Currency> currencies) {
        this.eCurrency = eCurrency;
        this.currencies = currencies;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (charSequence.length() > 0) {
            String s = charSequence.toString();
            double value = Double.parseDouble(s.replace(",", "."));

            for (Currency currency : currencies) {
                if (currency.getECurrency() != eCurrency) {
                    currency.getField().removeTextChangedListener(currency.getWatcher());
                    currency.getField().setText(Double.toString(currency.calc(value, eCurrency)));
                    currency.getField().addTextChangedListener(currency.getWatcher());
                }
            }
        } else {
            for (Currency currency : currencies) {
                if (currency.getECurrency() != eCurrency) {
                    currency.getField().removeTextChangedListener(currency.getWatcher());
                    currency.getField().setText("");
                    currency.getField().addTextChangedListener(currency.getWatcher());
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
