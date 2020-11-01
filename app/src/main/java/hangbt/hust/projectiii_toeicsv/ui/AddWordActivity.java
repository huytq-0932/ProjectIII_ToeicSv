package hangbt.hust.projectiii_toeicsv.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Set;

import hangbt.hust.projectiii_toeicsv.R;

public class AddWordActivity extends AppCompatActivity {

    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(view -> {
            Intent back = new Intent(AddWordActivity.this, SetAccountActivity.class);
            startActivity(back);
            finish();
        });
    }

    private void initData() {
    }
}