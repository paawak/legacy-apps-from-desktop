/*
 * Database.java
 *
 * Created on September 22, 2003, 12:39 AM
 */

package controller;

import utils.database.DBUtil;

/**
 * 
 * @author paawak
 */
public final class Database extends DBUtil {

    private String TableName = new String();
    private static final String URL = "machexpress";
    private static final String UserName = "root";
    private static final String Password = "agnimitra";

    public Database(String TableName) {

        super(URL, UserName, Password, TableName, true, new String[] { "\\",
                "\"", "'" });
        this.TableName = TableName;

    }

}
