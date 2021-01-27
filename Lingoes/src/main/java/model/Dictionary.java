/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Dictionary {
    private String name;
    private List<Word> arrayWord;

    public Dictionary(){
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Word> getArrayWord() {
        return arrayWord;
    }

    public void setArrayWord(List<Word> arrayWord) {
        this.arrayWord = arrayWord;
    }
    
    
    
    
}
