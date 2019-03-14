package Viagogo_Coding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyingShowTickets {
	/*private static Long calculateTimeTakenToGetAllTickets(int[] tickets, int p) {
        Long count = 0L;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            list.add(tickets[i]);
        }
        final int size = list.size();
        boolean done = false;
        while (!done) {
            for (int j = 1; j < size; j++) {
                if (list.get(j) == 0) {
                    continue;
                }
                if (list.get(p + 1) == 0) {
                    done = true;
                    break;
                }
                list.set(j, list.get(j) - 1);
                count++;
            }
        }
        return count;
    }
	*/
	public static long times( int[] tickets, int p) {
	    long times = 0;
	    int[] temp = Arrays.copyOf(tickets, tickets.length); //creating this array to check whether the *person i* buy tickets less than *person p*
	    for(int i = 0; i < tickets.length; i++ ) {
	       temp[i] = tickets[i] - tickets[p];
	    }
	    for(int i = 0; i < tickets.length; i++ ) {
	       if(temp[i] < 0) times += tickets[i];
	       else {
	          if(i <= p) times += tickets[p];
	          else times += tickets[p] - 1;
	       }
	    }
	    return times;
	} 
	static long waitingTime(int[] tickets, int p) {
        long noOfIterations = 0;
        int ticketBeingProcessed = 0;
        int numberOfParticipantsInLine = tickets.length;
        if(numberOfParticipantsInLine > p)
        {
            while(tickets[p] != 0)
            {
                // The person has already got his ticket and exited the line, just go to the next person, dont increase number of iterations because it took no time
                if(tickets[ticketBeingProcessed] != 0)
                {
                    // ticket being processed got one ticket
                    tickets[ticketBeingProcessed] = tickets[ticketBeingProcessed] -1;
                    // if we have reached the end of the line
                    if(ticketBeingProcessed == numberOfParticipantsInLine -1)
                        ticketBeingProcessed = 0;
                    else
                        ticketBeingProcessed ++;
                    noOfIterations ++;
                }
                else {
                    if (ticketBeingProcessed == numberOfParticipantsInLine - 1)
                        ticketBeingProcessed = 0;
                    else
                        ticketBeingProcessed++;
                }
             
            }
        }
        return noOfIterations;
    }

public static void main(String[] args) {
	int[] tickets = {5, 5, 2, 3, 3};
	long val=times(tickets,4);
	System.out.println(val);
}
}
