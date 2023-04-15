package a2;

public class Ticket {
	private int userID;
	private int ticketId;
	private String description;
	private TicketStatus status;
	private TicketSeverity severity;
	
	public Ticket(int userID, int ticketId, String description, TicketStatus status, TicketSeverity severity) {
		super();
		this.userID = userID;
		this.ticketId = ticketId;
		this.description = description;
		this.status = status;
		this.severity = severity;
	}
	
	public int getUserID() {
		return userID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public TicketSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(TicketSeverity severity) {
		this.severity = severity;
	}

	public int getTicketId() {
		return ticketId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", description=" + description + ", status=" + status + ", severity="
				+ severity + "]";
	}
	
	
	
}
