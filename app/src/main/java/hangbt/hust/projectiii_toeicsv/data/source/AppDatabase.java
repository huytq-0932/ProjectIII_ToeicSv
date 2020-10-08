package hangbt.hust.projectiii_toeicsv.data.source;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import hangbt.hust.projectiii_toeicsv.data.model.Topic;
import hangbt.hust.projectiii_toeicsv.data.model.Word;

@Database(entities = {Topic.class, Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "toeic_600.db";
    private static AppDatabase instance;

    public abstract TopicDao topicDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .createFromAsset(DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
