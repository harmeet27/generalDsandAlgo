package lld.bms.model;

public class Movie {
    private String name;
    private String desc;
    private int rating;
    private int totalLikes;
    private int totalDislikes;
    private int duration;

    public Movie(String name, String desc, int duration) {
        this.name = name;
        this.desc = desc;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void like() {
        totalLikes++;
    }

    public void dislike() {
        totalDislikes++;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getRating() {
        return ((totalLikes - totalDislikes) / totalLikes) * 10;
    }

}
