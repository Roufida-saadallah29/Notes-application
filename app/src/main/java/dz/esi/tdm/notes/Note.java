package dz.esi.tdm.notes;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    String titre, description;
    int idImage;
    Date creationaDate;

    public Note(String titre, String description, int idImage,Date creationaDate) {
        this.titre = titre;
        this.description = description;
        this.idImage = idImage;
        this.creationaDate=creationaDate;
    }

    public String getTitre() {
        return titre;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationaDate() {
        return creationaDate;
    }
    // avec des getteurs et setteurs
}
