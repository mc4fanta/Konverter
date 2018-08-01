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
        addEuro();
        addPhillipinePeso();
    }


    /**
     * add euro to currencies and set text watcher
     */
    private void addEuro() {
        EditText euro = findViewById(R.id.euro);
        CurrencyWatcher euroWatcher = new CurrencyWatcher(ECurrency.EURO, currencies);
        Currency currency = new Currency(ECurrency.EURO, euro, euroWatcher);
        currencies.add(currency);

        euro.addTextChangedListener(euroWatcher);
    }

    /**
     * add php to currencies and set text watcher
     */
    private void addPhillipinePeso() {
        EditText php = findViewById(R.id.philippine_peso);
        CurrencyWatcher phpWatcher = new CurrencyWatcher(ECurrency.PHP, currencies);
        Currency currency = new Currency(ECurrency.PHP, php, phpWatcher);
        currencies.add(currency);

        php.addTextChangedListener(phpWatcher);
    }
}
