package Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pc on 2016/4/6.
 */
@Entity
@Table(name = "tbl_asset")
public class Asset {
    private int id;
    private User name;
    private long catipal;
    private String type;
    private Date nowdate;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    public Date getNowdate() {
        return nowdate;
    }

    public void setNowdate(Date nowdate) {
        this.nowdate = nowdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCatipal() {
        return catipal;
    }

    public void setCatipal(long catipal) {
        this.catipal = catipal;
    }

    public Asset() {
    }

    public Asset(User name, long catipal, String type,Date nowdate) {
        this.name = name;
        this.catipal = catipal;
        this.type = type;
        this.nowdate = nowdate;
    }
}
