package models;

public enum Area {

    BULGARIA("Bulgaria"),
    GREECE("Greece"),
    SCOTLAND("Scotland"),
    JAPAN("Japan"),
    HUNGARY("Hungary"),
    AUSTRALIA("Australia"),
    ECUADOR("Ecuador");


    private String Area;

    public void setArea(String area) {
        Area = area;
    }

    Area(String area) {
        this.Area = area;
    }

    public String getArea() {
        return Area;
    }
}
