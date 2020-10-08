package hangbt.hust.projectiii_toeicsv.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_topic")
public class Topic {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "no")
    private Integer no;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "color")
    private String color;
    @ColumnInfo(name = "last_time")
    private String lastTime;

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

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
