/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Word;

/**
 *
 * @author ADMIN
 */
public interface DictionaryService {
   Word getWord(String name, String word);

    List<String> getWords(String name, String word);
}
