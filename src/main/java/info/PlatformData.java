package info;

import com.google.gson.Gson;

public class PlatformData {
    private PlatformInfo message;
    public PlatformData(PlatformInfo message){
        this.message = message;
    }

    public PlatformInfo getMessage() {
        return message;
    }

    public void setMessage(PlatformInfo message) {
        this.message = message;
    }

    public String random() {
        return new Gson().toJson(this);
    }
}
