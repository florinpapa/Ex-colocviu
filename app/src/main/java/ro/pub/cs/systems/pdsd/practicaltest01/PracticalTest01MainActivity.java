package ro.pub.cs.systems.pdsd.practicaltest01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PracticalTest01MainActivity extends ActionBarActivity {
    private static final int SEC_ACTIVITY_CODE = 1;
    private static final int RESULT_OK = 1;
    private static final int RESULT_CANCEL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        if (savedInstanceState != null) {
            String nr1 = savedInstanceState.getString("edit1");
            EditText e1 = (EditText)findViewById(R.id.editText);
            e1.setText(nr1);

            String nr2 = savedInstanceState.getString("edit2");
            EditText e2 = (EditText)findViewById(R.id.editText2);
            e2.setText(nr2);
        }

        // TODO 1 - ascultator pe butoane
        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tv = (EditText)findViewById(R.id.editText);
                int nr = Integer.parseInt(tv.getText().toString());
                nr = nr + 1;
                tv.setText("" + nr);
            }
        });

        Button button2 = (Button)findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tv = (EditText)findViewById(R.id.editText2);
                int nr = Integer.parseInt(tv.getText().toString());
                nr = nr + 1;
                tv.setText("" + nr);
            }
        });

        // TODO 3 - activitate noua
        Button button3 = (Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.editText);
                EditText e2 = (EditText) findViewById(R.id.editText2);
                int nr1 = Integer.parseInt(e1.getText().toString());
                int nr2 = Integer.parseInt(e2.getText().toString());
                int sum = nr1 + nr2;
                Log.e("MyErr", "Sum is " + sum);
                Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01.intent.action.SecondaryActivity");
                intent.putExtra("sum_display", "" + sum);
                startActivityForResult(intent, SEC_ACTIVITY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEC_ACTIVITY_CODE) {
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "RESULT_OK received", Toast.LENGTH_SHORT).show();
            }
            if (resultCode == RESULT_CANCEL) {
                Toast.makeText(this, "RESULT_CANCEL received", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        EditText e1 = (EditText) findViewById(R.id.editText);
        String nr1 = e1.getText().toString();
        savedInstanceState.putString("edit1", nr1);

        EditText e2 = (EditText) findViewById(R.id.editText2);
        String nr2 = e2.getText().toString();
        savedInstanceState.putString("edit2", nr2);
    }
}
