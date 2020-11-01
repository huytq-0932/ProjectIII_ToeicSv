package hangbt.hust.projectiii_toeicsv.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_topic")
public class Topic implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "no")
    private Integer no;
    @NonNull
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "color")
    private String color;
    @ColumnInfo(name = "last_time")
    private String lastTime;

    public Topic(Integer id, String name, Integer no, String imageUrl, String category, String color, String lastTime) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.imageUrl = imageUrl;
        this.category = category;
        this.color = color;
        this.lastTime = lastTime;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNo() {
        return no;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
