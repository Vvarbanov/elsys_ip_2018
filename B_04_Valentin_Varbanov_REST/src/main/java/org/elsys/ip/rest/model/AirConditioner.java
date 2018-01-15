package org.elsys.ip.rest.model;

public class AirConditioner {

    private int id;
    private Integer warranty;

    private String brand;
    private String model;

    private String autoRestart;
    private String remoteControl;
    private String antibacterialFilter;

    private Double coolingPower;
    private Double heatingPower;
    private Double noiseLevel;
    private Double weight;


    public AirConditioner(int id, String brand, String model, double coolingPower, double heatingPower, double noiseLevel, double weight, String autoRestart, String remoteControl, String antibacterialFilter, int warranty) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.coolingPower = coolingPower;
        this.heatingPower = heatingPower;
        this.noiseLevel = noiseLevel;
        this.weight = weight;
        this.autoRestart = autoRestart;
        this.remoteControl = remoteControl;
        this.antibacterialFilter = antibacterialFilter;
        this.warranty = warranty;
    }

    public AirConditioner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCoolingPower() {
        return coolingPower;
    }

    public void setCoolingPower(Double coolingPower) {
        this.coolingPower = coolingPower;
    }

    public Double getHeatingPower() {
        return heatingPower;
    }

    public void setHeatingPower(double heatingPower) {
        this.heatingPower = heatingPower;
    }

    public Double getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(Double noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAutoRestart() {
        return autoRestart;
    }

    public void setAutoRestart(String autoRestart) {
        this.autoRestart = autoRestart;
    }

    public String getRemoteControl() {
        return remoteControl;
    }

    public void setRemoteControl(String remoteControl) {
        this.remoteControl = remoteControl;
    }

    public String getAntibacterialFilter() {
        return antibacterialFilter;
    }

    public void setAntibacterialFilter(String antibacterialFilter) {
        this.antibacterialFilter = antibacterialFilter;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }
}
