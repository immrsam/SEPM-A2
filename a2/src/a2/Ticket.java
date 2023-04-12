package a2;

public class Ticket {
	private String ticketId;
	private String description;
	private TicketStatus status;
	private TicketSeverity severity;
	
	public Ticket(String ticketId, String description, TicketStatus status, TicketSeverity severity) {
		super();
		this.ticketId = ticketId;
		this.description = description;
		this.status = status;
		this.severity = severity;
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

	public String getTicketId() {
		return ticketId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", description=" + description + ", status=" + status + ", severity="
				+ severity + "]";
	}
	
	
	
}
