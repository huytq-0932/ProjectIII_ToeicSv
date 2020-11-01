package hangbt.hust.projectiii_toeicsv.ui;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Word;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Word> words = new ArrayList<>();
    private OnClickItemListener listener;

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = words.get(position);
        holder.bindData(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void updateData(List<Word> wordList) {
        words.clear();
        words.addAll(wordList);
        notifyDataSetChanged();
    }

    public void updateItem(Word word, int position) {
        words.remove(position);
        words.add(position, word);
        notifyDataSetChanged();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewEnglish, textViewVietnamese, textViewPronunciation;
        private ImageView imageSpeak;
        private View viewMark;
        private OnClickItemListener listener;
        private TextToSpeech textToSpeech;

        public WordViewHolder(@NonNull View itemView, OnClickItemListener listener) {
            super(itemView);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewVietnamese = itemView.findViewById(R.id.textViewVietnamese);
            textViewPronunciation = itemView.findViewById(R.id.textViewPronunciation);
            imageSpeak = itemView.findViewById(R.id.imageButton);
            viewMark = itemView.findViewById(R.id.viewMark);
            textToSpeech = new TextToSpeech(itemView.getContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            });
            this.listener = listener;
        }

        public void bindData(Word word) {
            textViewEnglish.setText(word.getOrigin());
            textViewPronunciation.setText(word.getPronunciation());
            textViewVietnamese.setText(word.getType());

            imageSpeak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String utteranceId = UUID.randomUUID().toString();
                    textToSpeech.speak(word.getOrigin(), TextToSpeech.QUEUE_FLUSH, null, utteranceId);
                }
            });

            int colorId = word.getMark() == 1 ? R.color.colorMark : R.color.colorMarkGreen;
            int color = ContextCompat.getColor(itemView.getContext(), colorId);
            viewMark.setBackgroundColor(color);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(word, getAdapterPosition());
                }
            });
        }
    }

    public interface OnClickItemListener {
        void onClick(Word word, int position);
    }
}
