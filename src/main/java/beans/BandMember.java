package beans;

import java.io.Serializable;

public class BandMember implements Serializable {
    private String first;
    private String last;
    private String bio;

    public BandMember(String first, String last, String bio) {
        this.first = first;
        this.last = last;
        this.bio = bio;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
