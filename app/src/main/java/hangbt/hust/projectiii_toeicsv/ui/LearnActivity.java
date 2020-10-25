package hangbt.hust.projectiii_toeicsv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Topic;

public class LearnActivity extends AppCompatActivity {

    public static final String INTENT_TOPIC = "INTENT_TOPIC";
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter = new TopicAdapter();
    private List<Topic> topics = new ArrayList<>();
    private ImageView imageViewBack;

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
        topics.add(new Topic(1, "Contracts",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Business",
                "#966474", ""));
        topics.add(new Topic(2, "Computers & the Internet",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Office",
                "#966474", ""));
        topics.add(new Topic(3, "Marketing",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Personal",
                "#966474", ""));
        topics.add(new Topic(4, "Warranties",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Purchasing",
                "#966474", ""));
        topics.add(new Topic(5, "Business Planning",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Financing",
                "#966474", ""));
        topics.add(new Topic(6, "Conferences",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Management",
                "#966474", ""));

        topicAdapter.updateData(topics);
    }
}
