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
import hangbt.hust.projectiii_toeicsv.data.model.Word;

public class LearnWordActivity extends AppCompatActivity {

    private List<Word> words = new ArrayList<>();
    private RecyclerView recyclerViewWord;
    private WordAdapter wordAdapter = new WordAdapter();

    private ImageView imageViewBack;
    private TextView textViewTopicName;

    private static final String TAG = "LearnWordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_word);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        Intent intent = getIntent();
        Topic topic = (Topic) intent.getSerializableExtra(LearnCategoryActivity.INTENT_TOPIC_WORD);
        Log.d(TAG, "View: " + topic.getName());
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

        wordAdapter.setListener((word, position) -> openDetail(word));
    }

    private void openDetail(Word word) {
//        Log.d(TAG, "openDetail: " + word.getType());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.learnWord, DetailWordFragment.newInstance(word))
                .addToBackStack(null)
                .commit();
    }

    private void initData() {
        words.add(new Word(1, "abide by",
                "to accept and act according to a law, an agreement",
                "(v): ton trong, tuan theo, giu (loi)",
                "/ə'baid/",
                "http://600tuvungtoeic.com/template/english/images/study/abide_by.jpg",
                "The two parties agreed to abide by the judge's decision",
                "Hai bên đã đồng ý tuân theo quyết định của tòa án.",
                1,
                0,
                false));
        words.add(new Word(2,
                "agreement",
                "an arrangement, a promise or a contract made with somebody",
                "(n): hợp đồng, giao kèo, sự đồng ý/thỏa thuận với nhau",
                "/ə'gri:mənt/",
                "http://600tuvungtoeic.com/template/english/images/study/agreement.jpg",
                "According to the agreement, the caterer will also supply the flowers for the event",
                "Theo như thỏa thuận, nhà cung cấp lương thực thực phẩm cũng sẽ cung cấp hoa cho sự kiện",
                1,
                0,
                false));
        words.add(new Word(3, "assurance",
                "a statement that something will certainly be true or will certainly happen",
                "(n): sự cam đoan, bảo đảm, chắc chắn; sự tin chắc, tự tin",
                "/ə'ʃuərəns/",
                "http://600tuvungtoeic.com/template/english/images/study/assurance.jpg",
                "The sales associate gave his assurance that the missing keyboard would be replaced the next day.",
                "Đối tác bán hàng cam đoan rằng ngày mai bàn phím lỗi sẽ được thay.",
                1,
                0,
                true));
        words.add(new Word(4, "cancellation",
                "a decision to stop something that has already been arranged from happening",
                "(n): sự bãi bỏ, hủy bỏ",
                "/,kænse'leiʃn/",
                "http://600tuvungtoeic.com/template/english/images/study/cancellation.jpg",
                "The cancelation of her flight caused her problems for the rest of the week",
                "Việc hủy chuyến bay đã gây cho cô ấy nhiều vấn đề trong những ngày còn lại của tuần.",
                1,
                0,
                false));
        words.add(new Word(5, "engage",
                "to become involved in, to participate",
                "(v): Tham gia, cam kết, (n)sự hứa hẹn, hứa hôn",
                "/in'geidʤ/",
                "http://600tuvungtoeic.com/template/english/images/study/engage.jpg",
                "He engaged us in a fascinating discussion about current business law",
                "Anh ấy cùng chúng tôi thảo luận sôi nổi về luật kinh doanh hiện hành",
                1,
                0,
                true));
        words.add(new Word(6, "determine",
                "to discover the facts about something",
                "(v): quyết định, xác định, định rõ; quyết tâm, kiên quyết",
                "/di'tə:min/",
                "http://600tuvungtoeic.com/template/english/images/study/determine.jpg",
                "After reading the contract, I was still unable to detemine if our company was liable for back wages.",
                "Sau khi đọc hợp đồng, tôi vẫn không thể biết được liệu rằng công ty của chúng tôi có phải chịu trách nhiệm hoàn trả lại lương không",
                1,
                0,
                false));

        wordAdapter.updateData(words);
    }
}
