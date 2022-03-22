import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
      for(int i = 0; i < size; i++){
        int idx = (front + i) % data.length;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

    void add(int val) {
      if(size == data.length){
        int[] temp = new int[data.length*2];
        for(int i =0;i<data.length-front;i++){
            temp[i]=data[i+front];
        }
        int l = data.length - front;
        for(int j=0;j<front;j++){
            temp[j+l]=data[j];
        }
        front = 0;
        data = temp;
        int idx = (front + size) % data.length;
        data[idx]=val;
        size++;
        
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }

    int remove() {
      if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
       }
    }

    int peek() {
       if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];
        return val;
       }
    }
  }