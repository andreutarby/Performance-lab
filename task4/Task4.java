package task4;

import java.io.*;
import java.util.*;

public class Task4 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Должен быть минимум один аргумент");
            return ;
        }

        File file = new File (args[0]);
        List<Integer> nums = new ArrayList<>();

        try (Scanner scnr = new Scanner(file)) {
            while (scnr.hasNext()) {
                nums.add(scnr.nextInt());
            }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }  catch (Exception e) {
            System.out.println("Некорректное содержимое файла : " + file.getPath());
            return;
        }

        if (nums.isEmpty()) {
             System.out.println("В файле должен быть минимум один элемент");
            return;
        } else if (nums.size() == 1){
            System.out.println("0");
            return ;
        }

        Collections.sort(nums);
        int med = nums.get(nums.size() / 2);

        int res = 0;
        for (int num : nums){
            res += Math.abs(num -med);
        }

        System.out.println(res);
    }
}