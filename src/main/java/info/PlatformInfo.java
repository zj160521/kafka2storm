package info;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PlatformInfo implements Serializable {
    private BigDecimal betAmount;
    private BigDecimal gainAmount;
    private String number;
    private String game;
    private String userId;
    private String platformCode;
    private Long timestamp;

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getGainAmount() {
        return gainAmount;
    }

    public void setGainAmount(BigDecimal gainAmount) {
        this.gainAmount = gainAmount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public PlatformInfo random() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] name = {"FISH","BIRD"};
            String[] room = {"奔驰宝马350","奔驰宝马351"};
            String[] id = {"111111","222222"};

            this.platformCode = name[new Random().nextInt(2)];
            this.betAmount = new BigDecimal("100");
            this.gainAmount = new BigDecimal("10");
            this.number = room[new Random().nextInt(2)];
            this.game = "奔驰宝马";
            this.userId = id[new Random().nextInt(2)];
            Integer hour = new Random().nextInt(23);
            String hourStr;
            if (hour < 10)
                hourStr = "0" + hour;
            else hourStr = hour.toString();
            String time2 = "2019-05-20 "+hourStr+":00:00";
            this.timestamp = df.parse(time2).getTime();
//            this.timestamp = "sad";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
