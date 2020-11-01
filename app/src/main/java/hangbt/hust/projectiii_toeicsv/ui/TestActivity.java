package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import hangbt.hust.projectiii_toeicsv.R;

public class TestActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private Button buttonStart, buttonSetting, buttonGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        buttonStart = findViewById(R.id.buttonStart);
        buttonSetting = findViewById(R.id.buttonSetting);
        buttonGuide = findViewById(R.id.buttonGuide);
        imageViewBack.setOnClickListener(view -> {
            Intent back = new Intent(TestActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });

        buttonStart.setOnClickListener(view -> {
            Intent test = new Intent(TestActivity.this, TakeTestActivity.class);
            startActivity(test);
        });

        buttonSetting.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.test, SettingTestFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });

        buttonGuide.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.test, GuideFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void initData() {
    }


}