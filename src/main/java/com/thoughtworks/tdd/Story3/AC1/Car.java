package com.thoughtworks.tdd.Story3.AC1;

public class Car {
    private String carNum;
    private boolean carparkstatus;
    public Car() {
    }

    public Car(String carNum) {
        this.carNum = carNum;
        carparkstatus = true;
    }

    public boolean isCarparkstatus() {
        return carparkstatus;
    }

    public void setCarparkstatus(boolean carparkstatus) {
        this.carparkstatus = carparkstatus;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
}
