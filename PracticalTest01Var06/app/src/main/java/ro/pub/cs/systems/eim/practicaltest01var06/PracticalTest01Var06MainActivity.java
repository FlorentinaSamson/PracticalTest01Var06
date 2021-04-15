package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private Button playbutton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        public void onClick(View view) {

            Random rand = new Random();

            if(view.getId() == R.id.play) {

                if(!checkBox1.isChecked()) {
                    int i = rand.nextInt(3);
                    editText1.setText(i > 0 ? Integer.toString(i) : "*");
                }
                if(!checkBox2.isChecked()) {
                    int i = rand.nextInt(3);
                    editText2.setText(i > 0 ? Integer.toString(i) : "*");
                }
                if(!checkBox3.isChecked()) {
                    int i = rand.nextInt(3);
                    editText3.setText(i > 0 ? Integer.toString(i) : "*");
                }

                Log.d("D", "Avem numerele" + editText1.getText() + " " + editText2.getText() + " " + editText3.getText());

                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                intent.putExtra("numar1", editText1.getText().toString());
                intent.putExtra("numar2", editText2.getText().toString());
                intent.putExtra("numar3", editText2.getText().toString());

                startActivityForResult(intent, 101);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        editText1 = (EditText) findViewById(R.id.text1);
        editText2 = (EditText) findViewById(R.id.text2);
        editText3 = (EditText) findViewById(R.id.text3);
        checkBox1 = (CheckBox) findViewById(R.id.hold1);
        checkBox2 = (CheckBox) findViewById(R.id.hold2);
        checkBox3 = (CheckBox) findViewById(R.id.hold3);
        playbutton = (Button) findViewById(R.id.play);

        playbutton.setOnClickListener(buttonClickListener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 101) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}