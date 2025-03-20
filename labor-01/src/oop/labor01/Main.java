package oop.labor01;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.Random;



public class Main {
    //Max függvény
    static double maxElement(double array[]){
        if(array.length == 0){
            System.out.println("Array is empty");
            return Double.NEGATIVE_INFINITY;
        }
        else{
            double max=array[0];
            for(int i=1;i<array.length;i++){
                if(array[i]>max){
                    max=array[i];
                }
            }
            return max;
        }

    }
    //P. bit jobbról
    static byte BitP(int x,int p){
        if(p<0 || p>31){
            return -1;
        }
        else{
            return (byte)((x>>p)&1);
        }
    }
    //Hány 1-es bit
    static int countBits(int number){
        int count=0;
        while(number!=0){
            if((number&1)==1){
                count++;
            }
            number>>=1;
        }
        return count;
    }
    static double mean(double array[]){
        if(array.length == 0){
            System.out.println("Array is empty");
            return Double.NaN;
        }
        double sum=0;
        int count=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            count++;
        }
        return sum/count;
    }
    static double standardDeviation(double array[]){
        if(array.length == 0){
            System.out.println("Array is empty");
            return Double.NaN;
        }
        double avg=mean(array),sum=0;
        for(int i=0;i<array.length;i++){
            sum+=pow(avg-array[i],2);
        }
        sum=sum/array.length;
        return sqrt(sum);
    }
    static double secondLargest(double array[]){
        if(array.length == 0){
            System.out.println("Array is empty");
            return Double.NEGATIVE_INFINITY;
        }
        double maxi=array[0],secondMaxi=Double.NEGATIVE_INFINITY;
        for(int i=1;i<array.length;i++){
            if(array[i]>maxi){
                secondMaxi=maxi;
                maxi=array[i];
            }
            else if(array[i]>secondMaxi && array[i]!=maxi){
                secondMaxi=array[i];
            }
        }
        if(maxi==secondMaxi){
            return Double.NEGATIVE_INFINITY;
        }
        else {
            return secondMaxi;
        }
    }
    static void randomArray(int array[]){
        Random rand = new Random();
        for(int i=0;i<array.length;i++){
            array[i]=rand.nextInt(Integer.MAX_VALUE);
        }
    }
    static void printArray(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    static int numberOfDuplicates(int array[]){
        int count=0;
        if(array[0]==array[1]){
            count++;
        }
        for(int i=2;i<array.length;i++){
            if(array[i]==array[i-1] && array[i]!=array[i-2]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double array[]={5,2,6,8,2};
        int array2[];
        array2=new int[1000000];
        //System.out.println(maxElement(array));
        //System.out.println(BitP(14,2));*/
        //System.out.println(countBits(15));
        //System.out.println(mean(array));
        //System.out.println(standardDeviation(array));
        //System.out.println(secondLargest(array));
        randomArray(array2);
        Arrays.sort(array2);
        System.out.println(numberOfDuplicates(array2));
        //printArray(array2);
    }
}