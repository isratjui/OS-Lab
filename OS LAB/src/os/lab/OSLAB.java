/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.lab;

import java.util.Scanner;

/**
 *
 * @author samman
 */
public class OSLAB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter Task name, time and priority");
        task v[] = new task[5];
        v[0] = new task("A", 10, 3);
        v[1] = new task("B", 6, 5);
        v[2] = new task("C", 2, 2);
        v[3] = new task("D", 4, 1);
        v[4] = new task("E", 8, 4);


        // Priority Scheduling
        System.out.println("Priority scheduling");
        task v1[] = new task[5];
        for (int i = 0; i < 5; i++) {
            v1[i] = v[i];
        }
        int r = 0;
        boolean flag = true;
        task temp;
        for (int i = 0; i < (v1.length - 1); i++) {
            for (int j = 0; j < v1.length - i - 1; j++) {
                if (v1[j].priority < v1[j + 1].priority) {
                    temp = v1[j];
                    v1[j] = v1[j + 1];
                    v1[j + 1] = temp;
                }
            }
        }
        int time = 0;
        for (int i = 0; i < 5; i++) {
            time = time + v1[i].time;
            System.out.println(v1[i].name + ":" + time);
        }
        //first come, first serve
        System.out.println("First come, first serve");
        time = 0;
        for (int i = 0; i < 5; i++) {
            time = time + v[i].time;
            System.out.println(v[i].name + ":" + time);
        }
        //Shortest Job First
        System.out.println("Shortest Job First");
        for (int i = 0; i < (v1.length - 1); i++) {
            for (int j = 0; j < v1.length - i - 1; j++) {
                if (v1[j].time > v1[j + 1].time) {
                    temp = v1[j];
                    v1[j] = v1[j + 1];
                    v1[j + 1] = temp;
                }
            }
        }
        time = 0;
        for (int i = 0; i < 5; i++) {
            time = time + v1[i].time;
            System.out.println(v1[i].name + ":" + time);
        }
        System.out.println("Round robin");
        time = 0;
        int count = 0;
        int m = -1;
        int[] time1 = new int[5];
        int k = -1;

        boolean n[] = new boolean[5];
        for (int y = 0; y < 1000 ; y++)
        {
            m++;
            if(m == 5)
            {
                m = 0;
            }
            if(v[m].time == 0)
            {
                count++;
                continue; 
            }
            if(count == 5)
            {
                break;
            }
            if(v[m].time <= 1)
            {
                time = time + v[m].time;
                v[m].time = 0;
                n[m] = true;
                time1[m] = time;
                for(int h = m; h < 5;h++)
                {
                    if(n[h] == true)
                    {
                        continue;
                    }
                    time1[m] = time1[m] + 1;
                }
            }
            else
            {
                time = time + 1;
                v[m].time = v[m].time - 1;
            }
        }
        for(int i = 0; i < 5; i++)
        {
            System.out.println(v[i].name+ ":"+ time1[i]);
        }
    }

}
