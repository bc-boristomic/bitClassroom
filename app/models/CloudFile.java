package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by gordan.masic on 22/10/15.
 */
@Entity
public class CloudFile extends Model {
    public static final String URL = "https://classroomstorage.blob.core.windows.net/classroomcontainer/";

    @Id
    public Long id;

    private String fileName;

    @ManyToOne
    Post post;

    public CloudFile(String fileName, Post post) {
        this.fileName = fileName;
        this.post = post;
        this.save();
    }

    public String getFileName() {
        return fileName;
    }

    public String getUrl(){
        return URL + fileName;
    }

    public void deleteFile(){
        this.delete();
    }
}
