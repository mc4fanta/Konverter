package niklas.konverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Currency> currencies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        buildView();
    }

    private void buildView() {
        addCurrency((EditText) findViewById(R.id.euro), ECurrency.EURO); // euro
        addCurrency((EditText) findViewById(R.id.namibia_dollar), ECurrency.NAD); // namibia dollar
        addCurrency((EditText) findViewById(R.id.philippine_peso), ECurrency.PHP); // philippines peso
        addCurrency((EditText) findViewById(R.id.dong), ECurrency.VND); // philippines peso
        addCurrency((EditText) findViewById(R.id.us_dollar), ECurrency.USD); // US Dollar
    }

    /**
     * add currency and set text watcher
     */
    private void addCurrency(EditText field, ECurrency eCurrency) {
        CurrencyWatcher watcher = new CurrencyWatcher(eCurrency, currencies);
        Currency currency = new Currency(eCurrency, field, watcher);
        currencies.add(currency);

        field.addTextChangedListener(watcher);
    }
	
}
