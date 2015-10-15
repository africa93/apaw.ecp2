package rest.business.views;

public class VoteTransfer {
    private String themeName;

    private int vote;

    public VoteTransfer(String themeName, int vote) {
        this.themeName = themeName;
        this.vote = vote;
    }

    public String getThemeName() {
        return themeName;
    }

    public int getVote() {
        return vote;
    }
}
