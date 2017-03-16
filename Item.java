/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korrow;

import java.sql.DriverManager;

/**
 *
 * @author Kantarat
 */
public class Item {
    private String id;
    private String name;
    private String ownerId;
    private String unit;
    private long capaAmount;
    private long currentAmount;
    private String pic;
    private String note;
    private String rentDe;
    private byte avali;
    private String type;
    private int cata;
    private byte[] picture;

    public Item(String id, String name, String ownerId, String unit, long capaAmount, long currentAmount, String pic, String note, String rentDe, byte avali, String type, int cata, byte[] picture) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.unit = unit;
        this.capaAmount = capaAmount;
        this.currentAmount = currentAmount;
        this.pic = pic;
        this.note = note;
        this.rentDe = rentDe;
        this.avali = avali;
        this.type = type;
        this.cata = cata;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getUnit() {
        return unit;
    }

    public long getCapaAmount() {
        return capaAmount;
    }

    public long getCurrentAmount() {
        return currentAmount;
    }

    public String getPic() {
        return pic;
    }

    public String getNote() {
        return note;
    }

    public String getRentDe() {
        return rentDe;
    }

    public byte getAvali() {
        return avali;
    }

    public String getType() {
        return type;
    }

    public int getCata() {
        return cata;
    }

    public byte[] getPicture() {
        return picture;
    }
    
}