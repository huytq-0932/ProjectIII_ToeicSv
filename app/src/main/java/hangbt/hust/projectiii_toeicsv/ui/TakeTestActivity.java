package hangbt.hust.projectiii_toeicsv.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hangbt.hust.projectiii_toeicsv.R;

public class TakeTestActivity extends AppCompatActivity {

    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        buttonStop = findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stop = new Intent(TakeTestActivity.this, TestActivity.class);
                startActivity(stop);
                finish();
            }
        });
    }

    private void initData() {
    }
}