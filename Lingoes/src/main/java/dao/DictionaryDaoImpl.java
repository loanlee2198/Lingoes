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

    private List<String> arr = new ArrayList<>();
    private final ConnectionManager connection;

    public DictionaryDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public Word getWord(String name, String word) {
        Connection conn = connection.getConnection();
        Word resultWord = new Word();
        List<String> arr = getWords(name, word);
        String sql = "SELECT * FROM `" + name + "` WHERE `word` = '" + word + "'";
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                resultWord.setId(result.getInt("id"));
                resultWord.setWord(result.getString("word"));
                resultWord.setContent(result.getString("content"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("tu: " + resultWord);
        return resultWord;
    }

    @Override
    public List<String> getWords(String name, String word) {
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
                arr.add(result.getString("word"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

   
}
