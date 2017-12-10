package com.badran.suzan.shoppinglist.data;

/**
 * Created by user on 22/11/2017.
 */

    public class Product{
    private String name;
    private double price;
    private double amount;
    private boolean isCompleted=false;
    private String imgPath;
    private String keyId;


    public Product(String name,double price,double  amount,boolean isCompleted,String imgPath,String keyId) {

        this.name=name;
        this.price=price;
        this.amount=amount;
        this.isCompleted=isCompleted;
        this.imgPath=imgPath;
        this.keyId=keyId;

    }
    public Product()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", isCompleted=" + isCompleted +
                ", imgPath='" + imgPath + '\'' +
                ", keyId='" + keyId + '\'' +
                '}';
    }
}