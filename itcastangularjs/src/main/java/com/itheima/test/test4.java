package com.itheima.test;

/**
 * Date:2018/9/11
 */

class Fu {
    static {
        System.out.println("Fu静态代码块");
    }
    {
        System.out.println("Fu非金泰代码块");
    }
    public Fu(){
        System.out.println("Fu构造函数");
    }
}
class Zi extends Fu{
    static {
        System.out.println("Zi静态代码块");
    }
    {
        System.out.println("Zi非金泰代码块");
    }
    public Zi(){
        System.out.println("Zi构造函数");
    }
}
public class test4 {
    public static void main(String[] args) {
        int[] counts = {9,7,6,5,2,3,4,1,8};

        System.out.println("排序前");
        for (int i = 0; i <counts.length ; i++) {
            System.out.print(counts[i]+",");
        }

        //冒泡排序算法
        for (int i = 0; i < counts.length;i++){
            for (int j = 0; j < counts.length-1 ; j++) {
                if(counts[j] > counts[j+1]) {
                    int temp;
                    temp = counts[j];
                    counts[j] = counts[j+1] ;
                    counts[j+1] = temp;
                }
            }
        }
        System.out.println("排序后");
        for (int i = 0; i <counts.length ; i++) {
            System.out.print(counts[i]+",");
        }
    }

}
