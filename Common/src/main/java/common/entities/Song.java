/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.entities;

import java.io.Serializable;

/**
 *
 * @author jhonf
 */
public class Song implements Serializable{
    private int id;
    private String type;
    private String artist;
    private String title;
    private int sizeMB;
    private byte[] arrayBytes;

    public Song(int id, String type, String artist, String title, int sizeMB, byte[] arrayBytes) {
        this.id = id;
        this.type = type;
        this.artist = artist;
        this.title = title;
        this.sizeMB = sizeMB;
        this.arrayBytes = arrayBytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(int sizeMB) {
        this.sizeMB = sizeMB;
    }

    public byte[] getArrayBytes() {
        return arrayBytes;
    }

    public void setArrayBytes(byte[] arrayBytes) {
        this.arrayBytes = arrayBytes;
    }
}