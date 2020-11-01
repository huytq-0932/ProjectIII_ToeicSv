package hangbt.hust.projectiii_toeicsv.data.source;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hangbt.hust.projectiii_toeicsv.data.model.Word;

@Dao
public interface WordDao {
    @Query("SELECT * FROM tbl_word WHERE tbl_word.topic_id = :topic_id")
    List<Word> getWordByTopic(Integer topic_id);

    @Query("SELECT * FROM tbl_word")
    List<Word> getAllWord();

    @Query("SELECT * FROM tbl_word WHERE tbl_word.mark = 1")
    List<Word> getMarkWork();

    @Update
    Void updateMark(Word word);
}
