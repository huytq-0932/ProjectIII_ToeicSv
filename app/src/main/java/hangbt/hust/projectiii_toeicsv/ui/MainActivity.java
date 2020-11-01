package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.base.BaseAsyncTask;
import hangbt.hust.projectiii_toeicsv.data.model.Word;
import hangbt.hust.projectiii_toeicsv.data.source.AppDatabase;
import hangbt.hust.projectiii_toeicsv.data.source.WordDao;

public class MainActivity extends AppCompatActivity implements DetailWordFragment.OnClickMarkWordListener {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerViewMarkWord;
    private WordAdapter wordAdapter = new WordAdapter();
    private List<Word> words = new ArrayList<>();
    private WordDao wordDao;

    private Button buttonLearn, buttonTest;
    private ImageView imageViewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        buttonLearn = findViewById(R.id.buttonLearn);
        buttonLearn.setOnClickListener(view -> {
            Intent learn = new Intent(MainActivity.this, LearnActivity.class);
            startActivity(learn);
        });
        //imageViewAccount
        imageViewAccount = findViewById(R.id.imageViewAccount);
        imageViewAccount.setOnClickListener(view -> {
            Intent account = new Intent(MainActivity.this, SetAccountActivity.class);
            startActivity(account);
        });
        //imageTest
        buttonTest = findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent test = new Intent(MainActivity.this, TestActivity.class);
                startActivity(test);
            }
        });

        //list
        recyclerViewMarkWord = findViewById(R.id.recycleViewMarkWord);
        recyclerViewMarkWord.setAdapter(wordAdapter);

        wordAdapter.setListener((word, position) -> openDetail(word, position));
    }

    private void openDetail(Word word, int position) {
        Log.d(TAG, "openDetail: " + word.getType());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main, DetailWordFragment.newInstance(word, position))
                .addToBackStack(null)
                .commit();
    }

    private void initData() {
        wordDao = AppDatabase.getInstance(this).wordDao();
        new BaseAsyncTask<Integer, List<Word>>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<List<Word>>() {
                    @Override
                    public void onSuccess(List<Word> data) {
                        wordAdapter.updateData(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<Integer, List<Word>>() {
                    @Override
                    public List<Word> onExecute(Integer integer) {
                        return wordDao.getWordByTopic(1);
                    }
                })
                .execute();
    }


    @Override
    public void onClickMark(Word word, int position) {
        new BaseAsyncTask<Word, Void>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<Void>() {
                    @Override
                    public void onSuccess(Void data) {

                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<Word, Void>() {
                    @Override
                    public Void onExecute(Word word) {
                        return wordDao.updateMark(word);
                    }
                })
                .execute();
        wordAdapter.updateItem(word, position);
    }
}
