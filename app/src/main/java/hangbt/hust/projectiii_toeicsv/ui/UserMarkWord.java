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
import hangbt.hust.projectiii_toeicsv.data.base.BaseAsyncTask;
import hangbt.hust.projectiii_toeicsv.data.model.Word;
import hangbt.hust.projectiii_toeicsv.data.source.AppDatabase;
import hangbt.hust.projectiii_toeicsv.data.source.WordDao;

public class UserMarkWord extends AppCompatActivity {
    
    private RecyclerView recyclerViewMarkWord;
    private WordAdapter wordAdapter = new WordAdapter();
    private List<Word> words = new ArrayList<>();

    private ImageView imageViewBack;

    private WordDao wordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mark_word);
        
        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(UserMarkWord.this, SetAccountActivity.class);
                startActivity(back);
                finish();
            }
        });

        recyclerViewMarkWord = findViewById(R.id.recycleViewMarkWord);
        recyclerViewMarkWord.setAdapter(wordAdapter);

        wordAdapter.setListener(new WordAdapter.OnClickItemListener() {
            @Override
            public void onClick(Word word, int position) {
                openDetail(word, position);
            }
        });
    }

    private void openDetail(Word word, int position) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.userMarkWord, DetailWordFragment.newInstance(word, position))
                .addToBackStack(null)
                .commit();
    }

    private void initData() {
        wordDao = AppDatabase.getInstance(this).wordDao();
        new BaseAsyncTask<Void, List<Word>>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<List<Word>>() {
                    @Override
                    public void onSuccess(List<Word> data) {
                        wordAdapter.updateData(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<Void, List<Word>>() {
                    @Override
                    public List<Word> onExecute(Void aVoid) {
                        return wordDao.getMarkWork();
                    }
                })
                .execute();
    }
}