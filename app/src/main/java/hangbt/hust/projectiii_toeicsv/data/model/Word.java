package hangbt.hust.projectiii_toeicsv.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_word")
public class Word implements Serializable {
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
    @ColumnInfo(name = "mark")
    private boolean mark;

    public Word(Integer id, String origin, String explanation, String type, String pronunciation, String imageUrl, String example, String exampleTranslation, Integer topicId, Integer level, boolean mark) {
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

    public boolean isMark() {
        return mark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setExampleTranslation(String exampleTranslation) {
        this.exampleTranslation = exampleTranslation;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                '}';
    }
}
