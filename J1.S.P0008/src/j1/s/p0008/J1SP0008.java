/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0008;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Yano Huynh
 */
public class J1SP0008 {

    static ArrayList<String> st = new ArrayList<>();
    static ArrayList<Character> c = new ArrayList<>();
    static int[] count = new int[100];

    public static void resetCount() {
        for (int i = 0; i < 100; i++) {
            count[i] = 0;
        }
    }

    public static int checkInputValid(String str) {
        int result = 0;
        ArrayList<Character> check = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                check.add(str.charAt(i));
            }
        }
        for (int i = 0; i < check.size(); i++) {
            char tmp = check.get(i);
            if (Character.isLetter(tmp)) {
                result = 1;
            }
            else {
                result = 0;
                break;
            }
        }
        return result;
    }

    public static void checkAppearString(String str) {
        StringTokenizer s = new StringTokenizer(str);
        J1SP0008.resetCount();

        while (s.hasMoreTokens()) { //kiem tra xem co nhieu token co san ko?
            st.add(s.nextToken());
        }

        //remove duplicate and add to new ArrayList
        ArrayList<String> st1 = new ArrayList<>();
        for (int i = 0; i < st.size(); i++) {
            if (!st1.contains(st.get(i))) {
                st1.add(st.get(i));
            }
        }

        //check appear
        for (int i = 0; i < st1.size(); i++) {
            for (int j = 0; j < st.size(); j++) {
                if (st1.get(i).equalsIgnoreCase(st.get(j))) {
                    count[i]++;
                }
            }
        }

        //convert
        st.clear();
        st.addAll(st1);
        J1SP0008.output(st);
    }

    public static void checkAppearCharacter(String str) {
        ArrayList<Character> c1 = new ArrayList<>();
        J1SP0008.resetCount();

        //lay tung ki tu khong phai dau space dua vao array
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                c.add(str.charAt(i));
            }
        }

        //remove duplicate and add to new ArrayList
        for (int i = 0; i < c.size(); i++) {
            if (!c1.contains(c.get(i))) {
                c1.add(c.get(i));
            }
        }

        //check appear
        for (int i = 0; i < c1.size(); i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c1.get(i).equals(c.get(j))) {
                    count[i]++;
                }
            }
        }

        //convert
        c.clear();
        c.addAll(c1);
        J1SP0008.output(c);
    }

    public static void output(ArrayList newArrayList) {
        System.out.print("{");
        for (int i = 0; i < newArrayList.size(); i++) {
            if (i == newArrayList.size() - 1) {
                System.out.printf("%s = %d", newArrayList.get(i), count[i]);
            } else {
                System.out.printf("%s = %d, ", newArrayList.get(i), count[i]);
            }
        }
        System.out.print("}");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            st.clear();
            c.clear();
            System.out.println("Enter your content:");
            String str = sc.nextLine().trim();
            if (J1SP0008.checkInputValid(str) == 1) {
                //kiem tra so lan xuat hien cua tung tu trong chuoi
                J1SP0008.checkAppearString(str);

                //kiem tra so lan xuat hien cua tung ky tu trong chuoi
                J1SP0008.checkAppearCharacter(str);
                
                System.out.println("-----------------");
                System.out.println("Enter to continue");
                System.out.println("-----------------");
                String tmp = sc.nextLine();
            } else {
                System.out.println("Wrong! Please input again.");
            }
        }

    }

}
