import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int p;

    public CustomStack(int cap) {
      data = new int[cap];
      p = -1;
    }

    int size() {
      return p + 1;
    }

    void display() {
      for (int i = p; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }
    
    void push(int val) {
      if (p == data.length - 1) {
        int[] temp = new int[data.length*2];
        for(int i = 0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
        p++;
        data[tos]=val;
      } else {
        p++;
        data[tos] = val;
      }
    }

    int pop() {
      if (p == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data[p];
        p--;
        return val;
      }
    }

    int top() {
      if (p == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return data[p];
      }
    }
}