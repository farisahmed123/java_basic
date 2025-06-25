package com.example;
public class Array {
    public static void main(String[] args){
        int[][] number = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        int sum = 0;
     for (int i=0;i<number.length;i++)
        {{
            for(int j=0;j<number[i].length;j++)
            {
                System.out.println("At Position "+i+" "+j+" Value is "+number[i][j]);
                sum += number[i][j];
            }
         }

        }
        System.out.println("The sum of the array is "+sum);
    }}