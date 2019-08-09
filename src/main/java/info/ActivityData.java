package info;

import com.google.gson.Gson;

public class ActivityData {
    private ActivityInfo message;
    public ActivityData(ActivityInfo message){
        this.message = message;
    }

    public ActivityInfo getMessage() {
        return message;
    }

    public void setMessage(ActivityInfo message) {
        this.message = message;
    }

    public String random() {
        return new Gson().toJson(this);
    }
}
