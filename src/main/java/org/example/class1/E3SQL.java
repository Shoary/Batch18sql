package org.example.class1;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E3SQL {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        // Creates the connection between java program and the database
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        // Takes our queries executes them and brings the results back
        Statement statement = connection.createStatement();
        String query = "select * from person";
        ResultSet rs = statement.executeQuery(query);
        // This Object gives us info about the data that is being returned by the query
        ResultSetMetaData rsm = rs.getMetaData();
       // To store all the data from the query so that we can easily pass it around
        List<Map<String, String>> tableData = new ArrayList<>();
       // TO GO through  all the columns from a row
        while (rs.next()) {
            Map<String, String> rowMap = new LinkedHashMap<>();
            for (int i = 1; i < rsm.getColumnCount(); i++) {
                String key = rsm.getColumnName(i);
                // getting the value  of the row
                String value = rs.getString(i);
                rowMap.put(key, value);
            }
            tableData.add(rowMap);
        }
        System.out.println(tableData);
    }
}

