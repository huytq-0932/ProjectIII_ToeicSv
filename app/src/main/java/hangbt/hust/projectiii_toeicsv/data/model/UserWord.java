package hangbt.hust.projectiii_toeicsv.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "tbl_userword")
public class UserWord implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @NonNull
    @ColumnInfo(name = "origin")
    private String origin;
    @ColumnInfo(name = "explanation")
    private String explanation;
    @NonNull
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "pronunciation")
    private String pronunciation;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @NonNull
    @ColumnInfo(name = "example")
    private String example;
    @ColumnInfo(name = "example_translation")
    private String exampleTranslation;
    @ColumnInfo(name = "topic_id")
    private Integer topicId;
    @ColumnInfo(name = "level")
    private Integer level;
    @ColumnInfo(name = "mark")
    private Integer mark;

    public UserWord(Integer id, @NonNull String origin, String explanation, @NonNull String type, String pronunciation, String imageUrl, @NonNull String example, String exampleTranslation, Integer topicId, Integer level, Integer mark) {
        this.id = id;
        this.origin = origin;
        this.explanation = explanation;
        this.type = type;
        this.pronunciation = pronunciation;
        this.imageUrl = imageUrl;
        this.example = example;
        this.exampleTranslation = exampleTranslation;
        this.topicId = topicId;
        this.level = level;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(@NonNull String origin) {
        this.origin = origin;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getExample() {
        return example;
    }

    public void setExample(@NonNull String example) {
        this.example = example;
    }

    public String getExampleTranslation() {
        return exampleTranslation;
    }

    public void setExampleTranslation(String exampleTranslation) {
        this.exampleTranslation = exampleTranslation;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
