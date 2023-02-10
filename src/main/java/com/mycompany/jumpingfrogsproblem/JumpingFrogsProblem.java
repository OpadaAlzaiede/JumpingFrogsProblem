/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jumpingfrogsproblem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author obada alzidi
 */
public class JumpingFrogsProblem {

    
    public int solution(int [] arr) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length - 1; i++) { // O(N)
            
            for(int j = i + 1; j < arr.length; j++) { // O(N)
                
                boolean flag = false; // flag to check if we continue calculating distances !
                
                if(map.containsKey(i)) { // O(1)
                    
                    int previousLocationHeight = arr[map.get(i)]; // calc height diff between current index & previous index
                    
                    if(arr[j] < previousLocationHeight) flag = true;
                } else {
                    
                    if(arr[j] < arr[i]) flag = true;
                }
                
                if(flag) break;
                
                int distance = j - i + 1;
                    
                if(map.containsKey(i)) {

                    int prevDis = map.get(i) - i + 1;
                    if(distance > prevDis) {
                        map.put(i, j); // store index with longest distance O(1)
                    }
                }else {
                    map.put(i, j); // O(1)
                }
                
            }
        }
        
        for(int i = 0 ; i < arr.length; i++ ) {
        
            if(map.containsKey(i)) {
                
                System.out.println("best positions from current location " + i + " is: ");
                System.out.println("first frog pos: " + i);
                System.out.println("second frog pos: " + map.get(i));
                System.out.println("distance is: " + (map.get(i) - i + 1));
            }else {
                
                System.out.println("No possible movements");
            }
        }
        
        return 0;
    }
    
    
    public static void main(String[] args) {
       JumpingFrogsProblem jfp = new JumpingFrogsProblem();
       
       int [] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
       
       jfp.solution(arr);
    }
}
 