package com.example.carnecertamobile.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.room.Room;

import com.example.carnecertamobile.model.Carne;
import com.example.carnecertamobile.dao.CarneDao;

@Database(
        entities = {Carne.class},
        version = 1
)
public abstract class CarneDatabase
        extends RoomDatabase {

    private static CarneDatabase instance;

    public static CarneDatabase getInstance(
            Context context
    ) {

        if(instance == null) {

            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            CarneDatabase.class,
                            "carnecerta_room"
                    )
                    .allowMainThreadQueries()
                    .build();

        }

        return instance;

    }

    public abstract CarneDao carneDao();

}