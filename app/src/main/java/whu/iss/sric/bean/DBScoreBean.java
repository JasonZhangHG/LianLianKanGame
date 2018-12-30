package whu.iss.sric.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBScoreBean {

    @Id(autoincrement = false)
    public long userId;
    @Property(nameInDb = "DBScoreBean")
    private int score;//自己分数

    @Generated(hash = 322480693)
    public DBScoreBean(long userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    @Generated(hash = 1323068593)
    public DBScoreBean() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DBScoreBean{" +
                "userId=" + userId +
                ", score=" + score +
                '}';
    }
}
