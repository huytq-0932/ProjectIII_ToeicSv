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
import hangbt.hust.projectiii_toeicsv.data.model.Topic;

public class LearnCategoryActivity extends AppCompatActivity {

    public static final String INTENT_TOPIC_WORD = "INTENT_TOPIC_WORD";
    private List<Topic> subtopics = new ArrayList<>();
    private TextView textViewTopicName;
    private ImageView imageViewBack;
    private RecyclerView recyclerViewSubTopic;
    private SubTopicAdapter subTopicAdapter = new SubTopicAdapter();

    private static final String TAG = "LearnCategoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        Intent intent = getIntent();
        Topic topic = (Topic) intent.getSerializableExtra(LearnActivity.INTENT_TOPIC);
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

    private void initData() {

        subtopics.add(new Topic(1, "Contracts",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/contracts.jpg",
                "Business",
                "#966474", ""));
        subtopics.add(new Topic(3, "Marketing",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/marketing.jpg",
                "Personal",
                "#966474", ""));
        subtopics.add(new Topic(4, "Warranties",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/warranties.jpg",
                "Purchasing",
                "#966474", ""));
        subtopics.add(new Topic(5, "Business Planning",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/business_planning.jpg",
                "Financing",
                "#966474", ""));
        subtopics.add(new Topic(6, "Conferences",
                1, "http://600tuvungtoeic.com/template/english/images/lesson/conferences.jpg",
                "Management",
                "#966474", ""));

        subTopicAdapter.updateData(subtopics);
    }
}
