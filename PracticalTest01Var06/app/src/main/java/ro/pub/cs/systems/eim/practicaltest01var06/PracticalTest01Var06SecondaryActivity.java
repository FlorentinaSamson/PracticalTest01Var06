package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var06SecondaryActivity  extends AppCompatActivity {

    private int scor = 100;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if(view.getId() == R.id.ok)
                setResult(scor, null);

            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactical_test01_var06_secondary);

        Log.d("D", "Intru");

        EditText text4 = (EditText) findViewById(R.id.text4);
        Button ok = (Button) findViewById(R.id.ok);

        Intent intent = getIntent();
        if (intent != null) {
            String s1 = intent.getStringExtra("numar1");
            String s2 = intent.getStringExtra("numar2");
            String s3 = intent.getStringExtra("numar3");
            text4.setText(s1 + " " + s2 + " " + s3);
        }

        ok.setOnClickListener(buttonClickListener);
    }
}
