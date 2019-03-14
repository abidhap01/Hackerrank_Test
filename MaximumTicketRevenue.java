package Viagogo_Coding_Challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumTicketRevenue {
	 PriorityQueue<Integer> pq;
    
	   public MaximumTicketRevenue(int length){
		   
	        pq = new  PriorityQueue<>(length, new Comparator<Integer>(){
	            @Override
	            public int compare(Integer o1, Integer o2){
	                return o2-o1;
	            }
	        });
	    }
	   
	    public  int getMaxRevenue(int[] tick, int noOfTickets){
	        int revenue =0;
	        for(int i=0; i<tick.length;i++){
	            pq.offer(tick[i]);
	        }
	        while(noOfTickets>0){
	            int ticketPrice = pq.poll();
	            revenue+= ticketPrice;
	            pq.offer(--ticketPrice);
	            noOfTickets--;
	        }
	        return revenue;
	    }
	     public static void main(String args[]) {
	      int[] ticekts={5, 1, 7, 10, 11, 9};
	      int noOfTickets= 4;
	      MaximumTicketRevenue mx=new MaximumTicketRevenue(ticekts.length);
	     int value= mx.getMaxRevenue(ticekts, noOfTickets);
	     System.out.println(value);
	    }
}
