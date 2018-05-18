package com.konovalov;

public class Flat {
    private int id;
    private String city;
    private String adress;
    private double area;
    private int room;
    private int price;

    public Flat() {
    }

    public Flat(String city, String adress, double area, int room, int price) {
        this.city = city;
        this.adress = adress;
        this.area = area;
        this.room = room;
        this.price = price;
    }

    public Flat(int id, String city, String adress, double area, int room, int price) {
        this.id = id;
        this.city = city;
        this.adress = adress;
        this.area = area;
        this.room = room;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", city=" + city +
                ", adress=" + adress +
                ", area=" + area +
                ", room=" + room +
                ", price=" + price +
                '}';
    }
}
