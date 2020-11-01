package hangbt.hust.projectiii_toeicsv.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Word;

public class UserWordActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWord;
    private WordAdapter wordAdapter = new WordAdapter();
    private List<Word> words = new ArrayList<>();

    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_word);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(UserWordActivity.this, SetAccountActivity.class);
                startActivity(back);
                finish();
            }
        });

        recyclerViewWord = findViewById(R.id.recycleViewWord);
        recyclerViewWord.setAdapter(wordAdapter);

        wordAdapter.setListener(new WordAdapter.OnClickItemListener() {
            @Override
            public void onClick(Word word, int position) {
                openDetail(word, position);
            }
        });
    }

    private void openDetail(Word word, int position) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.userWord, DetailWordFragment.newInstance(word, position))
                .addToBackStack(null)
                .commit();
    }

    private void initData() {
        wordAdapter.updateData(words);
    }
}