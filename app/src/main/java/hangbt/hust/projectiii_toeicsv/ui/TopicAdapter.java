package hangbt.hust.projectiii_toeicsv.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.projectiii_toeicsv.R;
import hangbt.hust.projectiii_toeicsv.data.model.Topic;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private List<Topic> topics = new ArrayList<>();
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topics.get(position);
        holder.bindData(topic);
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public void updateData(List<Topic> topicList) {
        topics.clear();
        topics.addAll(topicList);
        notifyDataSetChanged();
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTopic, textViewTopicName;
        private OnItemClickListener listener;

        public TopicViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            textViewTopic = itemView.findViewById(R.id.textViewTopic);
            textViewTopicName = itemView.findViewById(R.id.textViewTopicName);
            this.listener = listener;
        }

        public void bindData(Topic topic) {
            textViewTopic.setText("Topic " + String.valueOf(getAdapterPosition()+1));
            textViewTopicName.setText(topic.getCategory());

            itemView.setOnClickListener(view -> listener.onItemClick(topic, getAdapterPosition()));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Topic topic, int position);
    }
}
