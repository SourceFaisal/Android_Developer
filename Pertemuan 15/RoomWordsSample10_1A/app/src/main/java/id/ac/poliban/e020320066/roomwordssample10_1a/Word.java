package id.ac.poliban.e020320066.roomwordssample10_1a;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {
    //Unique key for each entity
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull //Can't be null
    @ColumnInfo(name = "word") //Column it is under
    private String mWord;

    //Constructor with word and ID
    //@Ignore because Room only expects one constructor
    @Ignore
    public Word(@NonNull String word, int id) {this.mWord = word; this.id = id; }

    //Constructor for just a word
    public Word(@NonNull String word) {this.mWord = word;}

    //Getter for word
    public String getWord() {return this.mWord; }

    //Getter for word id
    public int getId() {return this.id; }

    //Setter
    public void setId(int id) { this.id = id;}
}
