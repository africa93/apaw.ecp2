package rest.business.views;

public class ThemeAverageTransfer {
    private String themeName;

    private double average;

    public ThemeAverageTransfer(String themeName, double average) {
        this.themeName = themeName;
        this.average = average;
    }

    public String getThemeName() {
        return themeName;
    }

    public double getAverage() {
        return average;
    }

}
