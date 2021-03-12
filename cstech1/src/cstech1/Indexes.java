/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstech1;

import java.util.LinkedList;

//keep word indexes
public class Indexes {
    LinkedList<Integer> startPoints=new LinkedList();
    LinkedList<Integer> finishPoints=new LinkedList();
    public void printPoints(){
        for(int i=0;i<this.startPoints.size();i++){
            System.out.println(this.startPoints.get(i)+" "+this.finishPoints.get(i));
        }
    }
}
