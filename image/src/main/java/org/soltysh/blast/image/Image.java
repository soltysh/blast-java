package org.soltysh.blast.image;

import java.io.Serializable;
import java.lang.Object;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "image")
@NamedQuery(
    name="Image.findAll",
    query = "SELECT i FROM Image i WHERE i.tag = :tag"
)
@XmlRootElement
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String tag;

    @Column
    byte[] image;

    public Image() {
    }

    public Image(String tag, byte[] image) {
        this.tag = tag;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof Image))
            return false;
        Image that = (Image) obj;
        return that.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tag, this.image);
    }
}
