/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstech1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import cstech1.Indexes;

class Application{   
    //changeable
    private char star='*';
    private char line='-';
    
    //read data
    private String[] words;
    private String filePath;
    
    public String correct="Correct";
    
    public String wordsToString(){
        String str="";
        for(String i : this.words)
            str+=i+" ";
        return str;
    }
    
    public String wordsToString(String[] newWords){
        String str="";
        for(String i : newWords)
            str+=i+" ";
        return str;
    }
    
    //this function print the data
    public void printData(){                
        System.out.println(wordsToString());
    }
    
    //this function read the file
    public void readFile(String filePath){
        String data="";
        this.filePath=filePath;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {              
                data += myReader.nextLine();
                data += " \n ";          
            }
            myReader.close();
            //this.words=this.splitData(data);
            this.words=data.split(" ");
            //this.words=data.split("\\W+");
        } catch (FileNotFoundException e) {
        System.out.println("File not found!");
        e.printStackTrace();
      }
    }
        
    //this function save the file
    public void saveFile(){
        File output = new File(this.filePath);        
        FileWriter writer;
        try {
            writer = new FileWriter(output);            
            writer.write(wordsToString());            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    public void saveFile(String path){
        File output = new File(path);        
        FileWriter writer;
        try {
            writer = new FileWriter(output);            
            writer.write(wordsToString());            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }        
            
    private Indexes compareWords(String word1, String word2){
        int iter=0;//iterate on word2                   
        Indexes idxs=new Indexes();                
        int i,j;        
        boolean word1Finished,word2Finished;
                                              
        for(i=0;i<word1.length();i++){            
            //if first letters is matched                
            if(word1.charAt(i)==word2.charAt(0) || word2.charAt(0)==this.line || word2.charAt(0)==this.star){
                iter=1; 
                if(word2.charAt(0)!=this.star)
                    ++i;                
                word1Finished=true;
                word2Finished=false;
                //if first match is last letter of w1
                if(i==word1.length()){
                    word1Finished=false;  
                }
                for(j=i;j<word1.length();j++){
                    //exit condition
                    if(iter==word2.length()-1){
                        word1Finished=false;                        
                        word2Finished=true;
                        break;
                    }
                    //exit condition
                    if(!(word1.charAt(j)==word2.charAt(iter) || word2.charAt(iter)==this.line || word2.charAt(iter)==this.star)){
                        if(word2.charAt(0)!=this.star)
                            --i; 
                        word1Finished=false;
                        break;                        
                    }                    
                    ++iter;                        
                }  
                //success condition
                if(word1Finished && iter==word2.length()-1 && word2.charAt(iter)==this.star ){
                    //if first letter is *
                    if(word2.charAt(0)==this.star){ 
                        idxs.startPoints.add(0);
                    }
                    else{
                        idxs.startPoints.add(i-1);
                    }
                    //if last letter is *
                    if(word2.charAt(word2.length()-1)==this.star){                        
                        idxs.finishPoints.add(word1.length());                        
                    }
                    else{                        
                        idxs.finishPoints.add(j);                        
                    }
                }                
                else if(word2Finished && (word1.charAt(j)==word2.charAt(iter) || word2.charAt(iter)==this.line || word2.charAt(iter)==this.star)){
                   //if first letter is *
                    if(word2.charAt(0)==this.star){ 
                        idxs.startPoints.add(0);
                    }
                    else{
                        idxs.startPoints.add(i-1);
                    }
                    //if last letter is *
                    if(word2.charAt(word2.length()-1)==this.star){                        
                        idxs.finishPoints.add(word1.length());                        
                    }
                    else{                        
                        idxs.finishPoints.add(j);                        
                    }
               }
                
            }

        }
                
        return idxs;        
    }    
    
    public int findWord(String word){                           
        //word=this.fixStars(word);
        
        LinkedList<Indexes> idxs=new LinkedList();
        int counter = 0;//word count     
        Indexes temp;
        
        //main loop for find word
        for(int w=0;w<this.words.length;w++){   
            if(this.words[w].equals("\n"))
                continue;
            temp=this.compareWords(this.words[w], word);
            idxs.add(temp);    
            if(temp.startPoints.size()>0)
                counter+=temp.startPoints.size();            
        }                
        return counter;
    }
    
    public String changeWords(String word, String changedWord, Indexes idxs){       
        //delete old word, add new word
        String newWord="";                        
        int startPointIter=0;
        for(int i=0;i<word.length();i++){            
            if(startPointIter<idxs.startPoints.size() && i==idxs.startPoints.get(startPointIter)){
                i=idxs.finishPoints.get(startPointIter);
                newWord+=changedWord;
                startPointIter++;
            }
            else{
                newWord+=word.charAt(i);
            }
        }        
        return newWord;
    }
    
    public void replaceWord(String changingWord, String changedWord){
        Indexes idxs;
        for(int w=0;w<this.words.length;w++){                   
            if(this.words[w].equals("\n"))
                continue;
            idxs=this.compareWords(this.words[w], changingWord);
            if(idxs.startPoints.size()>0)
                this.words[w]=this.changeWords(this.words[w], changedWord, idxs);
        }        
    }
    
    public void deleteWord(String word){
        Indexes idxs;
        for(int w=0;w<this.words.length;w++){   
            if(this.words[w].equals("\n"))
                continue;
            idxs=this.compareWords(this.words[w], word);
            if(idxs.startPoints.size()>0)
                this.words[w]=this.changeWords(this.words[w], "", idxs);
        }        
    }
    
       
    //* and - must be at the beginning and end of the word
    private boolean placeControl(String word){
        for(int i=1;i<word.length()-1;i++){
            if(word.charAt(i)==this.star || word.charAt(i)==this.line){
                return false;
            }
        }
        return true;
    }
    
    //words must be one piece
    private boolean wordControl(String word){
        String words[]=word.split(" ");
        if(words.length!=1){
            return false;
        }
        return true;
    }
    
    //the number of letters must be greater than 3
    private boolean letterNumControl(String word){
        if(word.length()<3){
            return false;
        }
        return true;
    }
    
    public String parameterControl(String word){
        if(!this.placeControl(word)){
            return "* and - must be at the beginning and end of the word";
        }
        if(!this.wordControl(word)){
            return "words must be one piece";
        }
        if(!this.letterNumControl(word)){
            return "the number of letters must be greater than 3";
        }
        return this.correct;
    }
}