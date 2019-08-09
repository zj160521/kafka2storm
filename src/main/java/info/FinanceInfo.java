package info;

import java.io.Serializable;
import java.util.Random;

public class FinanceInfo implements Serializable {
    private String paymentName;
    private String eventTime;
    private Double money;
    private int event;
    private String memberId;
    private String paymentId;//存款支付线路id
    private Integer state;//存款记录状态，0所有存款记录（包含成功与失败），1存款成功记录
    private String platformName;//支付平台名
    private String platformCode;//支付平台code

    @Override
    public String toString() {
        return "FinanceInfo{" +
                "paymentName='" + paymentName + '\'' +
                ", eventTime=" + eventTime +
                ", money='" + money + '\'' +
                ", event=" + event +
                '}';
    }

    public FinanceInfo random() {
//        String[] payment = {"支付宝","微信","网银","信用卡"};
        String[] payment = {"支付宝","微信"};
        String[] member = {"1a7bd81478f1401fbbf6e52ad7e2cb8b"};
        String[] paymentID = {"a1674029da8b4af5a6ccedb37b9189f5"};//"8adc4b7fa4184f1396ec452084d21535",
        String[] code = {"FISH","BIRD"};
        String[] platName = {"TC平台", "CG平台"};
//        this.event = new Random().nextInt(1) + 1;
        this.event = 1;
        this.money = 10.00;
        this.paymentName = payment[new Random().nextInt(1)];
        Integer hour = new Random().nextInt(23);
        String hourStr;
        if (hour < 10)
            hourStr = "0" + hour;
        else hourStr = hour.toString();
        this.eventTime = "2019-07-10 "+hourStr+":21:10";
        this.memberId = member[new Random().nextInt(1)];
        this.paymentId = paymentID[new Random().nextInt(1)];
        this.state = 1;
        this.platformCode = code[new Random().nextInt(2)];
        this.platformName = platName[new Random().nextInt(2)];

        return this;
    }
}
