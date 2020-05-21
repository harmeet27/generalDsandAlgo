package lld.model;

public class Hall {
    private int hallId;
    private String name;
    private int capacity;
    private int availableCapacity;
    Seat[] seats;

    public Hall(int hallId, String name, int capacity) {
        this.hallId = hallId;
        this.name = name;
        this.capacity = capacity;
        this.availableCapacity = capacity;
        seats = new Seat[capacity];
    }

    public boolean isFullHouse() {
        return availableCapacity == 0;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
}
