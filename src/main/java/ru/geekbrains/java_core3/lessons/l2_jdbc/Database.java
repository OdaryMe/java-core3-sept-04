package ru.geekbrains.java_core3.lessons.l2_jdbc;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static String insertStatement = "insert into users (nickname, password) values (?, ?);";
    private static final String DB_CONNECTION_STRING = "jdbc:sqlite:db/example.db";
    private static final String CREATE_REQUEST = "create table if not exists users (id integer primary key autoincrement, nickname text, password text);";
    private static final String DROP_REQUEST = "drop table if exists users;";

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            preparedStatement("Condor", "alco");
            preparedStatement("Kucher", "135/1");
            preparedStatement("Scorpion", "someone");
            preparedStatement("Henrietta", "zuyd");
            massInsertBatch();
//            dropAllTable();
            simpleRead();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void dropAllTable() throws SQLException {
        statement.execute(DROP_REQUEST);
    }

    private static void simpleRead() throws SQLException {
       try (var resultSet = statement.executeQuery("select * from users")) {
           while (resultSet.next()) {
               System.out.printf("User id: %d, nickname: %s, password: %s\n",
                       resultSet.getInt(1),
                       resultSet.getString("nickname"),
                       resultSet.getString("password"));
           }
       }
    }

    private static void preparedStatement(String nickname, String password) throws SQLException {
        ps = connection.prepareStatement(insertStatement);
        ps.setString(1, nickname);
        ps.setString(2, password);
        ps.executeUpdate();
    }

    private static void massInsertBatch() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 5; i++) {
            ps.setInt(2, i);
            ps.setString(1, "User #" + i);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.setAutoCommit(true);
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_CONNECTION_STRING);
        statement = connection.createStatement();
//        ps = connection.prepareStatement(insertStatement);
    }

    private static void createTable() throws SQLException {
        statement.execute(CREATE_REQUEST);
    }

    private static void disconnect() {
        try {
            if(statement != null) {
                statement.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
