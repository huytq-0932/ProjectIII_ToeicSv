package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.base.BaseAsyncTask;
import hangbt.hust.projectiii_toeicsv.data.model.Topic;
import hangbt.hust.projectiii_toeicsv.data.model.Word;
import hangbt.hust.projectiii_toeicsv.data.source.AppDatabase;
import hangbt.hust.projectiii_toeicsv.data.source.WordDao;

public class LearnWordActivity extends AppCompatActivity implements DetailWordFragment.OnClickMarkWordListener {

    private List<Word> words = new ArrayList<>();
    private RecyclerView recyclerViewWord;
    private WordAdapter wordAdapter = new WordAdapter();

    private ImageView imageViewBack;
    private TextView textViewTopicName;

    private WordDao wordDao;

    private static final String TAG = "LearnWordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_word);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        Topic topic = (Topic) intent.getSerializableExtra(LearnCategoryActivity.INTENT_TOPIC_WORD);
        Log.d(TAG, "View: " + topic.getName());

        initView(topic);
        initData(topic);
    }

    private void initView(Topic topic) {
        imageViewBack = findViewById(R.id.imageViewBack);
        textViewTopicName = findViewById(R.id.textViewTopicName);
        imageViewBack.setOnClickListener(view -> {
            Intent back = new Intent(LearnWordActivity.this, LearnCategoryActivity.class);
            back.putExtra(LearnActivity.INTENT_TOPIC, topic);
            startActivity(back);
            finish();
        });
        textViewTopicName.setText(topic.getName());

        recyclerViewWord = findViewById(R.id.recycleViewWord);
        recyclerViewWord.setAdapter(wordAdapter);

        wordAdapter.setListener((word, position) -> openDetail(word, position));
    }

    private void openDetail(Word word, int position) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.learnWord, DetailWordFragment.newInstance(word, position))
                .addToBackStack(null)
                .commit();
    }

    private void initData(Topic topic) {
        wordDao = AppDatabase.getInstance(this).wordDao();
        new BaseAsyncTask<String, List<Word>>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<List<Word>>() {
                    @Override
                    public void onSuccess(List<Word> data) {
                        wordAdapter.updateData(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<String, List<Word>>() {
                    @Override
                    public List<Word> onExecute(String s) {
                        return wordDao.getWordByTopic(topic.getId());
                    }
                })
                .execute();
    }

    @Override
    public void onClickMark(Word word, int position) {
        wordAdapter.updateItem(word, position);
    }
}
