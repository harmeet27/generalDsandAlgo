package lld.model;

public class User {

    private int userId;
    private String fName;
    private String lName;

    public User(int userId, String fName, String lName) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public int getUserId() {
        return userId;
    }


    public String getlName() {
        return lName;
    }

}
