package hangbt.hust.projectiii_toeicsv.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_word")
public class Word {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "origin")
    private String origin;
    @ColumnInfo(name = "explanation")
    private String explanation;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "pronunciation")
    private String pronunciation;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @ColumnInfo(name = "example")
    private String example;
    @ColumnInfo(name = "example_translation")
    private String exampleTranslation;
    @ColumnInfo(name = "topic_id")
    private Integer topicId;
    @ColumnInfo(name = "level")
    private Integer level;

    public Integer getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getType() {
        return type;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getExample() {
        return example;
    }

    public String getExampleTranslation() {
        return exampleTranslation;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public Integer getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                '}';
    }
}
