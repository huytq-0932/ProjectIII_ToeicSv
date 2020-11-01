package hangbt.hust.projectiii_toeicsv.data.source;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import hangbt.hust.projectiii_toeicsv.data.model.Topic;

@Dao
public interface TopicDao {
    @Query("SELECT * FROM tbl_topic")
    List<Topic> getAllTopic();

    @Query("SELECT * FROM tbl_topic GROUP by category")
    List<Topic> getCategory();

    @Query("SELECT * FROM tbl_topic WHERE tbl_topic.category = :category")
    List<Topic> getTopicByCategory(String category);

}
