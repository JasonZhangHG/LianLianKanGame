package whu.iss.sric.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBRankingBean {

    @Id(autoincrement = false)
    public long currentTimeAsId;

    @Property(nameInDb = "DBRankingBean")

    private int score;//得分

    private int type;//等级  1代表简单  2：代表中级  3：代表高级

    @Generated(hash = 1940062535)
    public DBRankingBean(long currentTimeAsId, int score, int type) {
        this.currentTimeAsId = currentTimeAsId;
        this.score = score;
        this.type = type;
    }

    @Generated(hash = 668912200)
    public DBRankingBean() {
    }

    public long getCurrentTimeAsId() {
        return this.currentTimeAsId;
    }

    public void setCurrentTimeAsId(long currentTimeAsId) {
        this.currentTimeAsId = currentTimeAsId;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
