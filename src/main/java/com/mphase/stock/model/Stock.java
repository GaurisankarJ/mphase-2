package com.mphase.stock.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "stock")
public class Stock {

    @Field(name="Date")
    private String date;

    @Field(name="Open Price")
    private Float openPrice;

    @Field(name="High Price")
    private Float highPrice;

    @Field(name="Low Price")
    private Float lowPrice;

    @Field(name="Close Price")
    private Float closePrice;

    @Field(name="WAP")
    private Float wap;

    @Field(name="Deliverable Quantity")
    private Float deliverableQuantity;

    @Field(name="Spread High-Low")
    private Float spreadHighLow;

    @Field(name="Spread Close-Open")
    private Float spreadCloseOpen;

    @Field(name="% Deli Qty to Traded Qty")
    private Float deliToTraded;

    @Field(name="No of Trades")
    private Float noOfTrades;

    @Field(name="No of Shares")
    private Float noOfShares;

    @Field(name="Total Turnover (Rs)")
    private double totalTurnover;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Float openPrice) {
        this.openPrice = openPrice;
    }

    public Float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Float highPrice) {
        this.highPrice = highPrice;
    }

    public Float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Float closePrice) {
        this.closePrice = closePrice;
    }

    public Float getWap() {
        return wap;
    }

    public void setWap(Float wap) {
        this.wap = wap;
    }

    public Float getDeliverableQuantity() {
        return deliverableQuantity;
    }

    public void setDeliverableQuantity(Float deliverableQuantity) {
        this.deliverableQuantity = deliverableQuantity;
    }

    public Float getSpreadHighLow() {
        return spreadHighLow;
    }

    public void setSpreadHighLow(Float spreadHighLow) {
        this.spreadHighLow = spreadHighLow;
    }

    public Float getSpreadCloseOpen() {
        return spreadCloseOpen;
    }

    public void setSpreadCloseOpen(Float spreadCloseOpen) {
        this.spreadCloseOpen = spreadCloseOpen;
    }

    public Float getDeliToTraded() {
        return deliToTraded;
    }

    public void setDeliToTraded(Float deliToTraded) {
        this.deliToTraded = deliToTraded;
    }

    public Float getNoOfTrades() {
        return noOfTrades;
    }

    public void setNoOfTrades(Float noOfTrades) {
        this.noOfTrades = noOfTrades;
    }

    public Float getNoOfShares() {
        return noOfShares;
    }

    public void setNoOfShares(Float noOfShares) {
        this.noOfShares = noOfShares;
    }

    @Override
    public String toString() {
        return "Stock{" +
                ", date='" + date + '\'' +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", closePrice=" + closePrice +
                ", wap=" + wap +
                ", deliverableQuantity=" + deliverableQuantity +
                ", spreadHighLow=" + spreadHighLow +
                ", spreadCloseOpen=" + spreadCloseOpen +
                ", deliToTraded=" + deliToTraded +
                ", noOfTrades=" + noOfTrades +
                ", noOfShares=" + noOfShares +
                ", totalTurnover=" + totalTurnover +
                '}';
    }

    public double getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(double totalTurnover) {
        this.totalTurnover = totalTurnover;
    }
}
