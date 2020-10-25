package hangbt.hust.projectiii_toeicsv.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Word;

public class DetailWordFragment extends Fragment {

    private static final String BUNDLE_WORD = "BUNDLE_WORD";

    private static final String TAG = "DetailWordFragment";

    private TextView textViewEnglish, textViewVietnamese, textViewPronunciation, textViewExample, textViewTranslation, textViewExplanation;
    private ImageView imageSpeak, image, imageViewMark, imageViewBack;
    private ConstraintLayout detailWordFragment;

    public static DetailWordFragment newInstance(Word word) {
        DetailWordFragment fragment = new DetailWordFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_WORD, word);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewEnglish = view.findViewById(R.id.textViewEnglish);
        textViewVietnamese = view.findViewById(R.id.textViewVietnamese);
        textViewExample = view.findViewById(R.id.textViewExample);
        textViewTranslation = view.findViewById(R.id.textViewTranslation);
        textViewPronunciation = view.findViewById(R.id.textViewPronunciation);
        textViewExplanation = view.findViewById(R.id.textViewExplanation);
        image = view.findViewById(R.id.image);
        imageSpeak = view.findViewById(R.id.imageViewSpeak);
        imageViewMark = view.findViewById(R.id.imageViewMark);
        imageViewBack = view.findViewById(R.id.imageViewBack);
        detailWordFragment = view.findViewById(R.id.detailWordFragment);

        detailWordFragment.setOnClickListener(view1 -> {
        });
        imageViewBack.setOnClickListener(view12 -> getActivity().onBackPressed());

        showDetail();
    }

    private void showDetail() {
        Word word = (Word) getArguments().getSerializable(BUNDLE_WORD);
        Log.d(TAG, "showDetail: " + word);
        textViewEnglish.setText(word.getOrigin());
        textViewPronunciation.setText(word.getPronunciation());
        textViewVietnamese.setText(word.getType());
        textViewExample.setText(word.getExample());
        textViewTranslation.setText(word.getExampleTranslation());
        textViewExplanation.setText(word.getExplanation());

        Log.d(TAG, "showDetail: " + word.getImageUrl() + " " + word.getType());
        Glide.with(this).load(word.getImageUrl()).into(image);

        if (word.isMark()) {
            imageViewMark.setBackgroundResource(R.drawable.ic_baseline_bookmark_24);
        }
    }
}
