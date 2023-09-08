package org.edu.epo.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
private static Connection connection;
static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema","root","");
        System.out.println("connexion etabli");
    }
    catch (Exception e){
        e.printStackTrace();
    }
}

    public static Connection getConnection() {
        return connection;
    }
}
