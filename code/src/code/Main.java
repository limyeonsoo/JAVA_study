package code;
import java.util.*;
import java.io.*;

public class Main {
   public static void main (String [] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int n = Integer.parseInt(br.readLine());
      int num = 0;
      
      Deque <Integer> dq = new LinkedList <Integer>();
      
      for(int i=0; i<n; i++) {
    	 bw.write("in for");
         StringTokenizer st = new StringTokenizer(br.readLine());
         bw.write(st.nextToken());
         if(st.nextToken().equals("push_front")) {
            num = Integer.parseInt(st.nextToken());
            dq.addFirst(num);
;         }
         
         if(st.nextToken().equals("push_back")) {
            num = Integer.parseInt(st.nextToken());
            dq.addLast(num);
         }
         
         if(st.nextToken().equals("pop_front")) {
            if(dq.isEmpty())
               bw.write(-1);
            else
               bw.write(dq.pop());
         }
         
         if(st.nextToken().equals("pop_back")) {
            if(dq.isEmpty())
               bw.write(-1);
            else
               bw.write(dq.removeLast());
         }
         
         if(st.nextToken().equals("size")) 
            bw.write(dq.size());
         
         if(st.nextToken().equals("empty")) {
            if(dq.isEmpty())
               bw.write(1);
            else
               bw.write(0);
         }
         
         if(st.nextToken().equals("front")) {
            if(dq.isEmpty())
               bw.write(-1);
            else
               bw.write(dq.peekFirst());
         }
         
         if(st.nextToken().equals("back")) {
            if(dq.isEmpty())
               bw.write(-1);
            else
               bw.write(dq.peekLast());
         }
      }
   }
}