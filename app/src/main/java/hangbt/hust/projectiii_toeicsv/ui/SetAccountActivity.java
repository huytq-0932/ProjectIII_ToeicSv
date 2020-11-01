package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import hangbt.hust.projectiii_toeicsv.R;

public class SetAccountActivity extends AppCompatActivity {

    private Button buttonMarkWord, buttonUserWord, buttonAddWord, buttonTestResult;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_account);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        buttonMarkWord = findViewById(R.id.buttonMarkWord);
        buttonAddWord = findViewById(R.id.buttonAddWord);
        buttonUserWord = findViewById(R.id.buttonUserWord);
        buttonTestResult = findViewById(R.id.buttonTestResult);

        imageViewBack.setOnClickListener(view -> {
            Intent back = new Intent(SetAccountActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });

        buttonMarkWord.setOnClickListener(view -> {
            Intent back = new Intent(SetAccountActivity.this, UserMarkWord.class);
            startActivity(back);
        });

        buttonUserWord.setOnClickListener(view -> {
            Intent back = new Intent(SetAccountActivity.this, UserWordActivity.class);
            startActivity(back);
        });

        buttonAddWord.setOnClickListener(view -> {
            Intent back = new Intent(SetAccountActivity.this, AddWordActivity.class);
            startActivity(back);
        });

        buttonTestResult.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.account, TestResultFragment.newInstance() )
                    .addToBackStack(null)
                    .commit();
        });

    }

    private void initData() {
    }
}