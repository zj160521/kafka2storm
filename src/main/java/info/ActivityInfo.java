package info;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ActivityInfo implements Serializable {
    private String activityModelName;
    private String activityModelId;
    private BigDecimal amount;
    private BigDecimal prizeAmount;
    private String type;
    private Long time;

    public String getActivityModelName() {
        return activityModelName;
    }

    public void setActivityModelName(String activityModelName) {
        this.activityModelName = activityModelName;
    }

    public String getActivityModelId() {
        return activityModelId;
    }

    public void setActivityModelId(String activityModelId) {
        this.activityModelId = activityModelId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(BigDecimal prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }


    public ActivityInfo random() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] name = {"首充","笔笔送","注册送","手机认证彩金"};
            String[] type2 = {"存送","彩金"};
            String[] id = {"001","002","003"};

            this.amount = new BigDecimal("100");
            this.prizeAmount = new BigDecimal("10");
            this.activityModelName = name[new Random().nextInt(4)];
            this.type = type2[new Random().nextInt(2)];
            this.activityModelId = id[new Random().nextInt(3)];
            Integer hour = new Random().nextInt(23);
            String hourStr;
            if (hour < 10)
                hourStr = "0" + hour;
            else hourStr = hour.toString();
            String time2 = "2019-04-28 "+hourStr+":00:00";
            this.time = df.parse(time2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }
}
