package blogs.dinesh.com.testlistview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    String textd;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        AutoCompleteTextView auto = (AutoCompleteTextView)findViewById(R.id.auto);

        Resources r= getResources();
        String[] months  = r.getStringArray(R.array.months);

        ArrayAdapter a = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months);
        auto.setThreshold(1);
        auto.setAdapter(a);



        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textd = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, textd, Toast.LENGTH_LONG).show();
                textView.setText(textd);
            }
        });




    /*    text1=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
        text1.setAdapter(adapter);
        text1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());*/
    }


}
