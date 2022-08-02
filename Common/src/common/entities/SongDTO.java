package common.entities;

import java.io.Serializable;

/**
 *
 * @author jhonfer
 */
public class SongDTO implements Serializable {
    private String artist;
    private String title;
    private String type;
    private int sizeMB;
    private byte[] arrayBytes;

    public SongDTO(String artist, String title, int sizeMB) {
        this.artist = artist;
        this.title = title;
        this.sizeMB = sizeMB;
        this.type = "mp3";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
