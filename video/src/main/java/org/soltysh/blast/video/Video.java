package org.soltysh.blast.video;

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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "video")
@NamedQuery(
    name="Video.findAll",
    query = "SELECT v FROM Video v WHERE v.title LIKE :title"
)
@XmlRootElement
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
    String id;

    @Column
    String url;

    @Column
    String title;

    public Video() {
    }

    public Video(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof Video))
            return false;
        Video that = (Video) obj;
        return that.url.equals(this.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.title);
    }
}
