package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args)  throws IOException {


        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));

        String temp1;
        String files = "";
        float[] coordinatesOfCenterCircInt = new float[2];
        int radius;

        while ((temp1 = reader1.readLine()) != null) {
            files = files + temp1 + " ";
        }

        String[] file1SepStr = files.split(" ");
        for (int i = 0; i < 2; i++) {
            coordinatesOfCenterCircInt[i] = Integer.parseInt(file1SepStr[i]);
        }
        radius = Integer.parseInt(file1SepStr[2]);

        String temp2;
        String[] tempPointStr;
        float[] tempPointInt = new float[2];

        while ((temp2 = reader2.readLine()) != null) {
            tempPointStr = temp2.split(" ");

            for (int i = 0; i < 2; i++) {
                tempPointInt[i] = Integer.parseInt(tempPointStr[i]);
            }

            tempPointInt[0] = tempPointInt[0] - coordinatesOfCenterCircInt[0];
            tempPointInt[1] = tempPointInt[1] - coordinatesOfCenterCircInt[1];

            double dist = Math.sqrt(tempPointInt[0] * tempPointInt[0] + tempPointInt[1] * tempPointInt[1]);

            if (dist == radius) {
                System.out.println("0");
            } else if (dist < radius) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }

        reader1.close();
        reader2.close();
    }
}