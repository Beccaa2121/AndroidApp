package com.example.javaday12exercise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String NAME = "TravelExpertsSqlLite.db";
    private static final int VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table Agents");
        String sql = "CREATE TABLE Agents ("
	                + "AgentId	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	                + "AgtFirstName VARCHAR(20),"
	                + "AgtMiddleInitial VARCHAR(5),"
	                + "AgtLastName VARCHAR(20),"
	                + "AgtBusPhone	VARCHAR(20),"
	                + "AgtEmail VARCHAR(50),"
	                + "AgtPosition	VARCHAR(20),"
	                + "AgencyId INT)";

        db.execSQL(sql);
        sql = "insert into Agents values(1, 'Janet', null, 'Delton', '(403) 210-7801', 'janet.delton@travelexperts.com', 'Senior Agent', 1)";
        db.execSQL(sql);
        sql = "insert into Agents values(2, 'Judy', null, 'Lisle', '(403) 210-7802', 'judy.lisle@travelexperts.com', 'Intermediate Agent', 1)";
        db.execSQL(sql);
        sql = "insert into Agents values(3, 'Dennis', 'C.', 'Reynold', '(403) 210-7843', 'dennis.reynold@travelexperts.com', 'Junior Agent', 1)";
        db.execSQL(sql);
        sql = "insert into Agents values(4, 'John', null, 'Coville', '(403) 210-7823', 'john.coville@travelexperts.com', 'Intermediate Agent', 1)";
        db.execSQL(sql);
        sql = "insert into Agents values(5, 'Janice', 'W.', 'Dahl', '(403) 210-7865', 'janice.dahl@travelexperts.com', 'Senior Agent', 1)";
        db.execSQL(sql);
        sql = "insert into Agents values(6, 'Bruce', 'J.', 'Dixon', '(403) 210-7867', 'bruce.dixon@travelexperts.com', 'Intermediate Agent', 2)";
        db.execSQL(sql);
        sql = "insert into Agents values(7, 'Beverly', 'J.', 'Jones', '(403) 210-7812', 'beverly.jones@travelexperts.com', 'Intermediate Agent', 2)";
        db.execSQL(sql);
        sql = "insert into Agents values(8, 'Jane', null, 'Merrill', '(403) 210-7868', 'jane.merrill@travelexperts.com', 'Senior Agent', 2)";
        db.execSQL(sql);
        sql = "insert into Agents values(9, 'Brian', 'S.', 'Peterson', '(403) 210-7833', 'brian.peterson@travelexperts.com', 'Junior Agent', 2)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table Agents");
        onCreate(db);
    }
}
