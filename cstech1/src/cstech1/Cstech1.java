package cstech1;

public class Cstech1 {

    /*public static void main(String[] args) {
        Application app=new Application();
        //app.readFile("deneme7.txt");
        //app.readFile("deneme8.txt");
        app.readFile("deneme9.txt");
        app.printData();
        //System.out.println(app.findWord("-m*l*o"));
        //app.replaceWord("-m*l*o","melo");
        //app.deleteWord("-m*l*o");
        //app.replaceWord("ılavuz","melo");
        //app.replaceWord("-az*ım","melo");
        //System.out.println(app.findWord("*zı-"));
        //System.out.println(app.findWord("*zı*"));
        //System.out.println(app.findWord("-zı*"));
        //System.out.println(app.findWord("-zı-"));
        //System.out.println(app.findWord("*el-"));
        //System.out.println(app.findWord("*li"));
        //app.replaceWord("*el-","melo");
        //app.replaceWord("*zı-","melo");
        //app.deleteWord("yazılım");
        //app.saveFile("C:\\Users\\user\\Documents\\NetBeansProjects\\cstech1\\deneme6.txt");        
        
        //kelimelerin
        String[] testData11=new String[]{"*l*","*l-","-l-","-l*"};
        int[] ansData11=new int[]{2,2,2,2};
        String[] testData12=new String[]{"*li*","*li-","-li-","-li*","*li","-li","li*","li-"};
        int[] ansData12=new int[]{1,1,1,1,1,1,1,1};
        String[] testData21=new String[]{"*k*","*k-","-k-","-k*"};
        int[] ansData21=new int[]{1,1,0,0};
        String[] testData22=new String[]{"*ke*","*ke-","-ke-","-ke*","*ke","-ke","ke*","ke-"};
        int[] ansData22=new int[]{1,1,0,0,1,0,1,1};
        String[] testData31=new String[]{"*n*","*n-","-n-","-n*"};
        int[] ansData31=new int[]{1,0,0,1};
        String[] testData32=new String[]{"*in*","*in-","-in-","-in*","*in","-in","in*","in-"};
        int[] ansData32=new int[]{1,0,0,1,1,1,1,0};
        for(int i=0;i<testData11.length;i++){
            System.out.println(testData11[i]+" "+app.findWord(testData11[i])+" "+ansData11[i]);
            System.out.println(testData21[i]+" "+app.findWord(testData21[i])+" "+ansData21[i]);
            System.out.println(testData31[i]+" "+app.findWord(testData31[i])+" "+ansData31[i]);
        }
        for(int i=0;i<testData12.length;i++){
            System.out.println(testData12[i]+" "+app.findWord(testData12[i])+" "+ansData12[i]);
            System.out.println(testData22[i]+" "+app.findWord(testData22[i])+" "+ansData22[i]);
            System.out.println(testData32[i]+" "+app.findWord(testData32[i])+" "+ansData32[i]);
        }
        //System.out.println(app.findWord("*n*"));    
        //System.out.println(app.findWord("-n*"));
        //System.out.println(app.findWord("*in*"));    
        //System.out.println(app.findWord("-in*"));
        //System.out.println(app.findWord("in-"));
        //System.out.println(app.findWord("*k*"));
        //System.out.println(app.findWord("*k-"));
        app.printData();
    }*/
    
}
/*
private Indexes compareWords(String word1, String word2){
        int iter=0;//iterate on word2                   
        Indexes idxs=new Indexes();                
        int i,j;
        boolean isBreak=true;
                
        if(word2.charAt(0)!=this.star){                       
            for(i=0;i<word1.length();i++){            
                //if first letters is matched                
                if(word1.charAt(i)==word2.charAt(0) || word2.charAt(0)==this.line){
                    iter=1; 
                    ++i;
                    isBreak=false;
                    for(j=i;j<word1.length();j++){                                                 
                        //exit condition
                        if(!(word1.charAt(j)==word2.charAt(iter) || word2.charAt(iter)==this.line || word2.charAt(iter)==this.star)){
                            --i;
                            isBreak=true;
                            break;                        
                        }
                        //match is finished condition
                        if(iter==word2.length()-1){
                            //if last letter is *
                            if(word2.charAt(iter)==this.star){
                                idxs.startPoints.add(i-1);
                                idxs.finishPoints.add(word1.length());
                                break;
                            }
                            else{
                                idxs.startPoints.add(i-1);
                                idxs.finishPoints.add(j);
                                break;
                            }                            
                        }  
                        
                        ++iter;                        
                    }  
                    if(!isBreak && word2.charAt(word2.length()-1)==this.star){
                        idxs.startPoints.add(0);
                        idxs.finishPoints.add(word1.length());
                    }
                }

            }
        }
        //if first letter is *           
        else{  
            for(i=0;i<word1.length();i++){            
                //if first letters is matched                
                if(word1.charAt(i)==word2.charAt(1)){
                    iter=2; 
                    ++i;
                    isBreak=false;
                    for(j=i;j<word1.length();j++){                         
                        //exit condition
                        if(!(word1.charAt(j)==word2.charAt(iter) || word2.charAt(iter)==this.line || word2.charAt(iter)==this.star)){
                            --i;
                            isBreak=true;
                            break;                        
                        }
                        //match is finished condition
                        if(iter==word2.length()-1){
                            //if last letter is *
                            if(word2.charAt(iter)==this.star){
                                idxs.startPoints.add(0);
                                idxs.finishPoints.add(word1.length());
                                break;
                            }
                            else{
                                idxs.startPoints.add(0);
                                idxs.finishPoints.add(j);
                                break;
                            }                            
                        }                          
                        ++iter;                        
                    }    
                    if(!isBreak && word2.charAt(word2.length()-1)==this.star){
                        idxs.startPoints.add(0);
                        idxs.finishPoints.add(word1.length());
                    }
                }

            }
        }
        
        return idxs;        
    }
*/