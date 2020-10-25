package hangbt.hust.projectiii_toeicsv.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Topic;

public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.SubTopicViewHolder> {

    private List<Topic> subtopics = new ArrayList<>();
    private SubTopicAdapter.OnItemClickListener listener;

    public void setListener(SubTopicAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SubTopicAdapter.SubTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subtopic, parent, false);
        return new SubTopicAdapter.SubTopicViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTopicAdapter.SubTopicViewHolder holder, int position) {
        Topic subtopic = subtopics.get(position);
        holder.bindData(subtopic);
    }

    @Override
    public int getItemCount() {
        return subtopics.size();
    }

    public void updateData(List<Topic> topicList) {
        subtopics.clear();
        subtopics.addAll(topicList);
        notifyDataSetChanged();
    }

    static class SubTopicViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTopicName;
        private ImageView imageViewTopic;
        private SubTopicAdapter.OnItemClickListener listener;

        public SubTopicViewHolder(@NonNull View itemView, SubTopicAdapter.OnItemClickListener listener) {
            super(itemView);
            textViewTopicName = itemView.findViewById(R.id.textViewTopicName);
            imageViewTopic = itemView.findViewById(R.id.imageViewTopic);
            this.listener = listener;
        }

        public void bindData(Topic topic) {
            textViewTopicName.setText(topic.getName());
            Glide.with(itemView).load(topic.getImageUrl()).into(imageViewTopic);
            itemView.setOnClickListener(view -> listener.onItemClick(topic, getAdapterPosition()));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Topic topic, int position);
    }
}
