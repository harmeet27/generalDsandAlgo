package lld.model;

import java.util.LinkedList;
import java.util.List;

public class Multiplex {

    private List<Hall> halls;
    private String multiplexName;
    private City city;
    private String address;
    private List<Show> shows;

    public Multiplex(String multiplexNmae, City city, String address) {
        this.halls = new LinkedList<>();
        this.multiplexName = multiplexNmae;
        this.city = city;
        this.address = address;

    }

    public List<Show> getShows() {
        return shows;
    }

    public boolean addHall(Hall hall) {
        return halls.add(hall);
    }

    public boolean removeHall(Hall hall) {
        return halls.remove(hall);
    }

    public boolean addShow(Show show) {
        if (shows == null) {
            shows = new LinkedList<>();
        }
        return shows.add(show);
    }

    public Show removeShow(Show show) {
        int index = shows.indexOf(show);
        return shows.remove(index);

    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public String getMultiplexName() {
        return multiplexName;
    }

    public void setMultiplexName(String multiplexName) {
        this.multiplexName = multiplexName;
    }

    public String getCity() {
        return city.toString();
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
