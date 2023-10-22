package com.example.planetsapp;

public class Planet {

    //Attributes
    private String planetName;
    private String moonCount;
    private int planetImage;
    private String extraDescription;

    //Constructors

    public Planet(String planetName, String moonCount, int planetImage,String extraDescription) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
        this.extraDescription = extraDescription;
    }

    //Getters and Setters
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }
}
