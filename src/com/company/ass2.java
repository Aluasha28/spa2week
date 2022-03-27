package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ass2 {
    public static void main(String[] args) {
        int number;
        static ArrayList<Integer> curr = new ArrayList<>();
        static int amountOfRightPermutations = 0;
        static double percent = -1;

        public ass2() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter N");
            number = Integer.parseInt(reader.readLine());
            computeTask();
        }

        public void computeTask() {
            permutationComputing(number, number);
            System.out.println(percent);

        }


        public static void permutationComputing(int n, int depth) {
            int save = 1;
            int amountOfPermutations = (int)factorial(n);
            if(depth == 0) {
                for(int i=0; i<n-1; i++)
                {
                    if(curr.get(i) - curr.get(i+1) > 0){
                        save += curr.get(i) - curr.get(i+1);
                    }
                    else
                        save += curr.get(i+1) - curr.get(i);

                    if(i==n-2)
                    {
                        if(save>Math.floor((double)n*(double)n/2))
                        {
                            amountOfRightPermutations++;
                        }
                    }
                }
                //ОБРАБАТЫВАЕМ ПЕРЕСТАНОВКУ КОТОРАЯ СЕЙЧАС СОХРАНЕНА В curr
                percent = (double)amountOfRightPermutations/(double)amountOfPermutations;
            }
            boolean[] used = new boolean[n+1];
            for(int i = 0; i < curr.size(); i++) {
                used[curr.get(i)] = true;
            }
            for(int i = 1; i <= n; i++) {
                if(used[i]) continue;
                curr.add(i);
                permutationComputing(n, depth-1);
                curr.remove(curr.size()-1);
            }
        }
    }

}
