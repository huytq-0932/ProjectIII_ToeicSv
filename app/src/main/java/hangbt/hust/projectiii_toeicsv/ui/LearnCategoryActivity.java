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
import hangbt.hust.projectiii_toeicsv.data.source.AppDatabase;
import hangbt.hust.projectiii_toeicsv.data.source.TopicDao;

public class LearnCategoryActivity extends AppCompatActivity {

    public static final String INTENT_TOPIC_WORD = "INTENT_TOPIC_WORD";
    private List<Topic> subtopics = new ArrayList<>();
    private TextView textViewTopicName;
    private ImageView imageViewBack;
    private RecyclerView recyclerViewSubTopic;
    private SubTopicAdapter subTopicAdapter = new SubTopicAdapter();

    private TopicDao topicDao;

    private static final String TAG = "LearnCategoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        Topic topic = (Topic) intent.getSerializableExtra(LearnActivity.INTENT_TOPIC);

        initView(topic);
        initData(topic);
    }

    private void initView(Topic topic) {
        Log.d(TAG, "initView: "+ topic.getCategory());

        textViewTopicName = findViewById(R.id.textViewTopicName);
        textViewTopicName.setText(topic.getCategory());
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(view -> {
            Intent back = new Intent(LearnCategoryActivity.this, LearnActivity.class);
            startActivity(back);
            finish();
        });
        //list subtopic
        recyclerViewSubTopic = findViewById(R.id.recycleViewSubTopic);
        recyclerViewSubTopic.setAdapter(subTopicAdapter);

        subTopicAdapter.setListener(new SubTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Topic topic, int position) {
                Intent learnWord = new Intent(LearnCategoryActivity.this, LearnWordActivity.class);
                learnWord.putExtra(INTENT_TOPIC_WORD, topic);
                startActivity(learnWord);
            }
        });
    }

    private void initData(Topic topic) {
        topicDao = AppDatabase.getInstance(this).topicDao();
        new BaseAsyncTask<String, List<Topic>>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<List<Topic>>() {
                    @Override
                    public void onSuccess(List<Topic> data) {
                        subTopicAdapter.updateData(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<String, List<Topic>>() {
                    @Override
                    public List<Topic> onExecute(String s) {
                        return topicDao.getTopicByCategory(topic.getCategory());
                    }
                })
                .execute();
    }
}
