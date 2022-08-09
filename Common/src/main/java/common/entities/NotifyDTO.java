package common.entities;

import java.io.Serializable;
import java.time.LocalDate;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author adrianfelipegp
 */
public class NotifyDTO implements Serializable{
    private int id;
    private SongDTO song;
    private LocalDate date;
    private int size; 
    
    public NotifyDTO(int id, SongDTO song, int size) {
        this.id = id;
        this.song = song;
        this.date = LocalDate.now();
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SongDTO getSong() {
        return song;
    }

    public void setSong(SongDTO song) {
        this.song = song;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
