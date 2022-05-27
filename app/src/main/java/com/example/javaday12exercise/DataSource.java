package com.example.javaday12exercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataSource {
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;

    public DataSource(Context context) {
        this.context = context;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public ArrayList<Agent> getAgents() {
        ArrayList<Agent> list = new ArrayList<>();
        String [] columns = { "AgentId", "AgtFirstName", "AgtMiddleInitial", "AgtLastName", "AgtBusPhone", "AgtEmail", "AgtPosition", "AgencyId" };
        Cursor cursor = db.query("agents", columns, null, null,
                null, null, null);
        while (cursor.moveToNext())
        {
            list.add(new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
        }
        return list;
    }

    public int updateAgent(Agent agent)
    {
        ContentValues cv = new ContentValues();
        cv.put("AgtFirstName", agent.getAgtFirstName());
        String args = String.valueOf(agent.getAgentId());
        String where = "AgentId=?";
        return db.update("Agents", cv, where, new String[]{args});
    }

    public int insertAgent(Agent agent)
    {
        ContentValues cv = new ContentValues();
        cv.put("AgtFirstName", agent.getAgtFirstName());
        return (int) db.insert("Agents", null, cv);
    }
}
