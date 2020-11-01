package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.base.BaseAsyncTask;
import hangbt.hust.projectiii_toeicsv.data.model.Topic;
import hangbt.hust.projectiii_toeicsv.data.source.AppDatabase;
import hangbt.hust.projectiii_toeicsv.data.source.TopicDao;

public class LearnActivity extends AppCompatActivity {

    public static final String INTENT_TOPIC = "INTENT_TOPIC";
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter = new TopicAdapter();
    private List<Topic> topics = new ArrayList<>();
    private ImageView imageViewBack;

    private TopicDao topicDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(view -> {
            Intent main = new Intent(LearnActivity.this, MainActivity.class);
            startActivity(main);
            finish();
        });
        //list topic
        recyclerView = findViewById(R.id.recycleViewTopic);
        recyclerView.setAdapter(topicAdapter);

        topicAdapter.setListener((topic, position) -> {
            Intent intent = new Intent(LearnActivity.this, LearnCategoryActivity.class);
            intent.putExtra(INTENT_TOPIC, topic);
            startActivity(intent);
        });
    }

    private void initData() {
        topicDao = AppDatabase.getInstance(this).topicDao();
        new BaseAsyncTask<Void, List<Topic>>()
                .setOnDataLoadedListener(new BaseAsyncTask.OnDataLoadedListener<List<Topic>>() {
                    @Override
                    public void onSuccess(List<Topic> data) {
                        topicAdapter.updateData(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                })
                .onExecute(new BaseAsyncTask.OnExecuteListener<Void, List<Topic>>() {
                    @Override
                    public List<Topic> onExecute(Void aVoid) {
                        return topicDao.getCategory();
                    }
                })
                .execute();
    }
}
