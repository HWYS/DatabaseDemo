package com.pk.databasedemo.data_model;

public class MovieInfo {
    private int id;
    private String mNmae;
    private int year;
    private double income;

    public MovieInfo(String mNmae, int year, double income) {
        this.mNmae = mNmae;
        this.year = year;
        this.income = income;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmNmae() {
        return mNmae;
    }

    public void setmNmae(String mNmae) {
        this.mNmae = mNmae;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
