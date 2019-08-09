package info;

import com.google.gson.Gson;

public class FinanceData {
    private FinanceInfo message;
    public FinanceData(FinanceInfo message){
        this.message = message;
    }

    public FinanceInfo getMessage() {
        return message;
    }

    public void setMessage(FinanceInfo message) {
        this.message = message;
    }

    public String random() {
        return new Gson().toJson(this);
    }
}
