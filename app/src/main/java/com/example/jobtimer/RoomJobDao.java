package com.example.jobtimer;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RoomJobDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomJob rJob);

    @Query("DELETE FROM job_table")
    void deleteAll();

    @Query("SELECT * from job_table")
    LiveData<List<RoomJob>> getAlphabetizedWords();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(RoomJob rJob);

}