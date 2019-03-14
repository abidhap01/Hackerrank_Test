package Viagogo_Coding_Challenge;

/**
 * @author abidhapandey
 *
 */
public class Event {
	private int eventID;
	private int distanceToUser;
	private int[] location;
	private Ticket[] tickets;
	
	public Event(int eventID, Ticket[] tickets) {
		super();
		this.eventID = eventID;
		this.tickets = tickets;
	}
	
	public Ticket getCheapestTicket() {
		double currentTicketPrice = tickets[0].getPrice();
		int currentIndex= 0;
		
		for(int i=0; i<tickets.length;i++) {
			double newTicketPrice= tickets[i].getPrice();
			if(newTicketPrice<currentTicketPrice) {
				currentTicketPrice=newTicketPrice;
				currentIndex=i;
			}
		}
		return tickets[currentIndex];
	}
	public int[] getLocation() {
		return location;
	}

	

	public void setDistanceToUser(int distanceToUser) {
		this.distanceToUser = distanceToUser;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public int getEventID() {
		return eventID;
	}

	public int getDistanceToUser() {
		return distanceToUser;
	}

	public Ticket[] getTickets() {
		return tickets;
	}

	
	
	
}
