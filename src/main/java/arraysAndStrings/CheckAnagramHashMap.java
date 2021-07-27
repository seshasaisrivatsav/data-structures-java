/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysAndStrings;
import java.util.*;

/**
 *
 * @author seshasai
 */
public class CheckAnagramHashMap {

 public static void main(String[] args) {
  String str1 = "manasa";
  String str2 = "asanam";


  if (isAnagram(str1, str2)) {
   System.out.println("they are anagrams");
  } else {
   System.out.println("they are not anagram");
  }
 }

 public static boolean isAnagram(String str1, String str2) {
  int s = 0;
  /* create a hashmap for string str1 */
  HashMap < Character, Integer > myMap = new HashMap < > ();
  for (int i = 0; i < str1.length(); i++) {
   if (myMap.containsKey(str1.charAt(i))) {
    myMap.put(str1.charAt(i), myMap.get(str1.charAt(i)) + 1);
   } else {
    myMap.put(str1.charAt(i), 1);
   }
  }

  for (int i = 0; i < str2.length(); i++) {
   if (myMap.containsKey(str2.charAt(i))) {
    if (myMap.get(str2.charAt(i)) < 0) {
     return false;
    } else {
     myMap.put(str2.charAt(i), myMap.get(str1.charAt(i)) - 1);
    }
   }
  }

  for (int i = 0; i < str2.length(); i++) {

   s = s + myMap.get(str1.charAt(i));
  }

  if (s == 0) {
   return true;
  } else {
   return false;
  }


 }



}