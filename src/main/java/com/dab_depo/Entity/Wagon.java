package com.dab_depo.Entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "wagon")
public class Wagon {

    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "wagon_type")
    private String wagonType;

    @JacksonXmlProperty(localName = "loading_percentage")
    private Integer loadingPercentage;

    @JacksonXmlProperty(localName = "serial_number")
    private String serialNumber;

    @JacksonXmlProperty(localName = "home_station")
    private String homeStation;

    @JacksonXmlProperty(localName = "load_capacity")
    private Integer loadCapacity;

    @JacksonXmlProperty(localName = "year_of_release")
    private Integer yearOfRelease;

    @JacksonXmlProperty(localName = "is_servicable")
    private Boolean isServicable;

    public Wagon() {
    }

    public Wagon(String wagonType, Integer loadingPercentage, String serialNumber, String homeStation, Integer loadCapacity, Integer yearOfRelease) {
        this.wagonType = wagonType;
        this.loadingPercentage = loadingPercentage;
        this.serialNumber = serialNumber;
        this.homeStation = homeStation;
        this.loadCapacity = loadCapacity;
        this.yearOfRelease = yearOfRelease;
        this.isServicable = Boolean.TRUE;

    }

    public Wagon(Integer id, String wagonType, Integer loadingPercentage, String serialNumber, String homeStation, Integer loadCapacity, Integer yearOfRelease) {
        this.id = id;
        this.wagonType = wagonType;
        this.loadingPercentage = loadingPercentage;
        this.serialNumber = serialNumber;
        this.homeStation = homeStation;
        this.loadCapacity = loadCapacity;
        this.yearOfRelease = yearOfRelease;
        this.isServicable = Boolean.TRUE;
    }

    public Wagon(Integer id, String wagonType, Integer loadingPercentage, String serialNumber, String homeStation, Integer loadCapacity, Integer yearOfRelease, Boolean isServicable) {
        this.id = id;
        this.wagonType = wagonType;
        this.loadingPercentage = loadingPercentage;
        this.serialNumber = serialNumber;
        this.homeStation = homeStation;
        this.loadCapacity = loadCapacity;
        this.yearOfRelease = yearOfRelease;
        this.isServicable = isServicable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWagonType() {
        return wagonType;
    }

    public void setWagonType(String wagonType) {
        this.wagonType = wagonType;
    }

    public Integer getLoadingPercentage() {
        return loadingPercentage;
    }

    public void setLoadingPercentage(Integer loadingPercentage) {
        this.loadingPercentage = loadingPercentage;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHomeStation() {
        return homeStation;
    }

    public void setHomeStation(String homeStation) {
        this.homeStation = homeStation;
    }

    public Integer getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Integer loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Boolean getIsServicable() {
        return isServicable;
    }

    public void setIsServicable(Boolean servicable) {
        isServicable = servicable;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "id=" + id +
                ", wagonType='" + wagonType + '\'' +
                ", loadingPercentage=" + loadingPercentage +
                ", serialNumber='" + serialNumber + '\'' +
                ", homeStation='" + homeStation + '\'' +
                ", loadCapacity=" + loadCapacity +
                ", yearOfRelease=" + yearOfRelease +
                ", isServicable=" + isServicable +
                '}';
    }
}
