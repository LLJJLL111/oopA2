public class Visitor extends Person {
    private String visitorId;
    private String ticketType;
    private boolean hasSeasonPass;

    // Default constructor
    public Visitor() {
        super();
        this.visitorId = "V000";
        this.ticketType = "Standard";
        this.hasSeasonPass = false;
    }

    // Parameterized constructor
    public Visitor(String name, int age, String email, String visitorId, String ticketType, boolean hasSeasonPass) {
        super(name, age, email);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.hasSeasonPass = hasSeasonPass;
    }

    // Getters and setters
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isHasSeasonPass() {
        return hasSeasonPass;
    }

    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", hasSeasonPass=" + hasSeasonPass +
                '}';
    }
}