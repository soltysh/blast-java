package org.soltysh.blast.text;

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
@Table(name = "text")
@NamedQuery(
    name="Text.findAll",
    query = "SELECT t FROM Text t WHERE t.text LIKE :text"
)
@XmlRootElement
public class Text implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
    String id;

    @Column
    String url;

    @Column
    String text;

    public Text() {
    }

    public Text(String url, String text) {
        this.url = url;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof Text))
            return false;
        Text that = (Text) obj;
        return that.url.equals(this.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.text);
    }
}
