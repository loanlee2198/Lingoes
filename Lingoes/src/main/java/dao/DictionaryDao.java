/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Word;

/**
 *
 * @author ADMIN
 */
public interface DictionaryDao {

    Word getWord(String name, String word);

    List<Word> getWords(String name, String word);
}
