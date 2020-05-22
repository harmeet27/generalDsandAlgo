package lld.bms;

import lld.bms.model.City;
import lld.bms.model.Hall;
import lld.bms.model.Multiplex;
import lld.bms.model.Show;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplexManager {

    List<Multiplex> multiplexes;

    public MultiplexManager() {
        multiplexes = populateMultiplexes();
    }

    private List<Multiplex> populateMultiplexes() {
        List<Multiplex> multiplexes = new LinkedList<>();
        Multiplex m1 = new Multiplex("m1", City.DELHI, "delhi based address 1");
        m1.addHall(new Hall(1, "h1", 10));
        m1.addHall(new Hall(2, "h2", 9));
        m1.addHall(new Hall(3, "h3", 8));
        m1.addHall(new Hall(4, "h4", 7));

        Multiplex m2 = new Multiplex("m1", City.BANGALORE, "Bangalore based address 1");
        m2.addHall(new Hall(1, "h1", 10));
        m2.addHall(new Hall(2, "h2", 9));
        m2.addHall(new Hall(3, "h3", 8));
        m2.addHall(new Hall(4, "h4", 7));

        Multiplex m3 = new Multiplex("m1", City.HYDERABAD, "Hyderabad based address 1");
        m3.addHall(new Hall(1, "h1", 10));
        m3.addHall(new Hall(2, "h2", 9));
        m3.addHall(new Hall(3, "h3", 8));
        m3.addHall(new Hall(4, "h4", 7));

        Multiplex m4 = new Multiplex("m1", City.GURGAON, "Gurgaon based address 1");
        m4.addHall(new Hall(1, "h1", 10));
        m4.addHall(new Hall(2, "h2", 9));
        m4.addHall(new Hall(3, "h3", 8));
        m4.addHall(new Hall(4, "h4", 7));

        Multiplex m5 = new Multiplex("m1", City.MUMBAI, "Mumbai based address 1");
        m5.addHall(new Hall(1, "h1", 10));
        m5.addHall(new Hall(2, "h2", 9));
        m5.addHall(new Hall(3, "h3", 8));
        m5.addHall(new Hall(4, "h4", 7));

        multiplexes.add(m1);
        multiplexes.add(m2);
        multiplexes.add(m3);
        multiplexes.add(m4);
        multiplexes.add(m5);
        return multiplexes;
    }

    public List<Multiplex> getAllMultiplexes() {
        return multiplexes;
    }

    public boolean addMultiplex(Multiplex multiplex) {
        return multiplexes.add(multiplex);
    }

    public boolean removeMultiplex(Multiplex multiplex) {
        return multiplexes.remove(multiplex);
    }

    public List<Multiplex> fetchMultiplexByCityName(String city) {
        return multiplexes.stream().filter(multiplex -> multiplex.getMultiplexName().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public List<Show> showMovieList(String multiplexName) {
        List<Multiplex> multi = multiplexes.stream().filter(multiplex -> multiplex.getMultiplexName().equalsIgnoreCase(multiplexName)).collect(Collectors.toList());
        return multi.get(0).getShows();

    }

    public boolean addHallInMultiplex(Multiplex multiplex, Hall hall) {
        int index = multiplexes.indexOf(multiplex);
        return multiplexes.get(index).getHalls().add(hall);
    }
}
