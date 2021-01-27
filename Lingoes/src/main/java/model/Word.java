/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Word {
    private int id;
    private String word;
    private String content;

    public Word(){
        
    }
    public Word(String word, String content){
        this.content = content;
        this.word = word;
    }

    public Word(int id, String word, String content) {
        this.id = id;
        this.word = word;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return id +"    "+ word + "-" + content ;
    }

   
    
}
