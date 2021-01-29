/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DictionaryDao;
import dao.DictionaryDaoImpl;
import java.util.List;
import model.Word;

/**
 *
 * @author ADMIN
 */
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryDao dictionaryDao;

    public DictionaryServiceImpl() {
        dictionaryDao = new DictionaryDaoImpl();
    }

    @Override
    public Word getWord(String name, String word) {
        return dictionaryDao.getWord(name, word);
    }

    @Override
    public List<String> getWords(String name, String word) {
        return dictionaryDao.getWords(name, word);
    }

}
