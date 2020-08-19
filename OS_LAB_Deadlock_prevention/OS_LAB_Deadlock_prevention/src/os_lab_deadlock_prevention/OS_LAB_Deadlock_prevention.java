/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_lab_deadlock_prevention;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *

 */
public class OS_LAB_Deadlock_prevention {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
            BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
            
            int process = Integer.parseInt(br.readLine());
            int resource = Integer.parseInt(br.readLine());
            br.readLine();
            int max_resource [][]= new int[process][resource];
            int allocated_resource [][]= new int[process][resource];
            int resource_available[] = new int[resource];
            for(int i = 0; i < process; i++)
            {
                String a = br.readLine();
                String aa[] = a.split(" ");
                for(int j = 0; j < aa.length ; j++)
                {
                    int k = Integer.parseInt(aa[j]);
                    max_resource [i][j] = k;
                }
            }
            br.readLine();
            for(int i = 0; i < process; i++)
            {
                String a = br.readLine();
                String aa[] = a.split(" ");
                for(int j = 0; j < aa.length ; j++)
                {
                    int k = Integer.parseInt(aa[j]);
                    allocated_resource [i][j] = k;
                }
            }
            br.readLine();
//            for(int i = 0; i < allocated_resource.length;i++)
//            {
//                for(int j = 0; j < allocated_resource[i].length ; j++)
//                {
//                    System.out.print(allocated_resource[i][j]);
//                }
//                System.out.println();
//            }
            String a = br.readLine();
            String aa[] = a.split(" ");
            for(int k = 0; k < aa.length ; k++)
            {
                int g = Integer.parseInt(aa[k]);
                resource_available [k] = g;
            }
            
            //Calculation
            int need[][] = new int[process][resource];
            for(int i = 0; i < process; i++)
            {
                for(int j = 0; j < aa.length ; j++)
                {
                    need[i][j] = max_resource [i][j] - allocated_resource[i][j];
                }
            }
            System.out.println("Need Matrix");
            for(int i = 0; i < need.length;i++)
            {
                for(int j = 0; j < need[i].length ; j++)
                {
                    System.out.print(need[i][j]+" ");
                    bw.write(need[i][j]+" ");
                }
                System.out.println();
                bw.newLine();
                bw.flush();
            }
            boolean safe = true;
            String safe_sequence [] = new String[process];
            boolean fff[] = new boolean[process];
            int p = 0;
            int q = 0;
            System.out.println("Change in available resource matrix");
            for(int i = 0; i < 1000; i++)
            {
                if(q == 4)
                    break;
                safe = true;
                if(p == 4)
                {
                    p = 0;
                }
                for(int j = 0; j < resource; j++)
                {
                    if(resource_available[j] - need[p][j] < 0)
                    {
                        safe = false;
                        break;
                    }
                }
                if(safe && !fff[p])
                {
                    for(int w = 0; w < resource;w++)
                    {
                            resource_available[w] = allocated_resource[p][w] + resource_available[w];
                            System.out.print(resource_available[w]+" ");
                    }
                    System.out.println();
                    if(p == 0)
                    {
                        safe_sequence[q] = "A";
                        q++;
                    }
                    else if (p == 1)
                    {
                        safe_sequence[q] = "B";
                        q++;
                    }
                    else if (p == 2)
                    {
                        safe_sequence[q] = "C";
                        q++;
                    }
                    else if(p == 3)
                    {
                        safe_sequence[q] = "D";
                        q++;
                    }
                    fff[p] = true;
                    
                }
                p++;
            }
            System.out.println("Safe Sequence");
            for(int i = 0; i< safe_sequence.length; i++)
            {
                System.out.print(safe_sequence[i] +" ");
            }
            System.out.println();
            for(int i = 0; i < fff.length; i++)
            {
              if(!fff[i])
              {
                  System.out.println("No safe Sequence");
              }
            }
            
        }
        catch(Exception e)
        {
            
        }
    }
    
}
