/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Word;

/**
 *
 * @author ADMIN
 */
public class DictionaryDaoImpl implements DictionaryDao {

    private List<Word> arr=new ArrayList<>();
    private final ConnectionManager connection;

    public DictionaryDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public Word getWord(String name, String word) {
        Connection conn = connection.getConnection();
        Word resultWord = new Word();
        List<Word> arr = getWords(name, word);
//        String sql = "SELECT * FROM `" + name + "` WHERE `word` = '" + word + "'";
//        Statement statement;
//        try {
//            statement = conn.createStatement();
//            ResultSet result = statement.executeQuery(sql);
//
//            if (result.next()) {
//                result.getInt("id");
//                result.getString("word");
//                result.getString("content");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DictionaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // System.out.println("tu: "+resultWord);
        return arr.stream()
                .filter(student -> student.getWord().equals(word))
                .findFirst().orElse(null);
    }

    @Override
    public List<Word> getWords(String name, String word) {
        Connection conn = connection.getConnection();
        String sql = "SELECT * FROM `" + name + "` WHERE `word` LIKE '" + word + "%' limit 5";
        Statement statement;
        System.out.println(sql);

        System.out.println(name + "  " + word);
        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            // arr.clear();
            while (result.next()) {
                System.out.println(result.getInt("id") + " " + result.getString("word") + " " + result.getString(3));

                arr.add(new Word(result.getInt("id"), result.getString("word"), result.getString("content")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

}
