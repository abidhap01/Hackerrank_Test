package Viagogo_Coding_Challenge;

/**
 * @author abidhapandey
 *
 */
import java.util.ArrayList;

public class World {
	private ArrayList<int[]> cordinates;
	private ArrayList<Event> events;
	
	public World() {
		generateWorld();
		generatEvents();
	}

	private void generatEvents() {
		//we generate a random number of events between 5 and 400
		int numberOfEvents = (int)(Math.random()*395)+5;
		System.out.println(numberOfEvents);
		
		events=new ArrayList<>();
		/*
		 * In this loop, we loop through the events ArrayList 
		 * and create a number of tickets which we then store in a Ticket array.
		 */
		for(int i=1;i<=numberOfEvents;i++) {
			//we create a random number of ticket between 0 and 5
			int numberOfTicekts = (int)(Math.random()*5);
			if(i<6) {
				numberOfTicekts=(int)(Math.random()*5)+1;
				
			}
			Ticket[] tickets = generateTicekts(numberOfTicekts);
			Event event = new Event(i, tickets);
			events.add(event);
			
		}
		assignLocations(events);
	}

	private void assignLocations(ArrayList<Event> events2) {
		/*
		 * We loop through 'events' and assign each event a random coordinate
		 * Each time we remove the coordinate we have assigned, so that no two events are in the same location.
		 */
		for(int i=0; i<events.size();i++) {
			ArrayList<int[]> corodinates=this.cordinates;
			int locIndex=(int)(Math.random()*corodinates.size());
			events.get(i).setLocation(corodinates.remove(locIndex));
		}
		
	}

	private Ticket[] generateTicekts(int numberOfTicekts) {
		// TODO Auto-generated method stub
		Ticket[] ticekts=new Ticket[numberOfTicekts];
		/*
		 * This loop assigns each ticket a price between $1 and $150
		 */
		for(int i=0; i<ticekts.length;i++) {
			double ticketPrice = (Math.random()*149)+1;
			Ticket ticekt = new Ticket(ticketPrice);
			ticekts[i]=ticekt;
		}
		return ticekts;
	}

	private ArrayList<int[]> generateWorld() {
		// TODO Auto-generated method stub
		cordinates = new ArrayList<int[]>();
		for(int x=-10; x<=10; x++) {
			for(int y=-10; y<=10; y++) {
				int[] coordinate = {x,y};
				cordinates.add(coordinate);
			}
		}
		return cordinates;
		
	}
	
	/*
	 * This method find the nearest events, given the users location.
	 * @param x - the x coordinate of the user 
	 * @param y - the y coordinate of the user
	 */
	public ArrayList<Event> findNearestEvents(int x, int y) {
		calculateDistance(x,y);
		ArrayList<Event> nearestEvent = new ArrayList<>();
		
		//while there is no more than 5 events in the nearestEvents array
		while(nearestEvent.size()<5) {
			int currentDistance = events.get(0).getDistanceToUser();
			int currentIdx =0;
			/* 
			 * We loop through the events array and get the distance from the user
			 * When we find a distance less than the currentDistance, we add the event to nearest events when
			 * we are sure it is the nearest event, we then remove it from the events arraylist so that it is not
			 * selected more than one time.
			 */
			for(int j=1; j<events.size();j++) {
				int newDistance = events.get(j).getDistanceToUser();
				if(newDistance<currentDistance) {
					currentDistance=newDistance;
					currentIdx = j;
				}
			}
			if(events.get(currentIdx).getTickets().length>0) {
				nearestEvent.add(events.remove(currentIdx));
				
			}else {
				events.remove(currentIdx);
			}
		}
		return nearestEvent;
	}

	public ArrayList<int[]> getCordinates() {
		return cordinates;
	}

	

	private void calculateDistance(int x, int y) {
		// TODO Auto-generated method stub
		for(Event event:events) {
			int x1 = event.getLocation()[0];
			int y1= event.getLocation()[1];
			
			int distance = Math.abs(x-x1)+ Math.abs(y-y1);
			event.setDistanceToUser(distance);
		}
	}
}
