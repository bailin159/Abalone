package com.example.bailin.abalone.tools;

/**
 * Created by 白霖 on 16/10/8.
 */
public class DBTools {
    private static DBTools dbTools;

    private DBTools(){

    }

    public static DBTools getInstance(){
        if (dbTools == null) {
            synchronized (DBTools.class){
                if (dbTools == null) {
                    dbTools = new DBTools();
                }
            }
        }
        return dbTools;
    }
}
