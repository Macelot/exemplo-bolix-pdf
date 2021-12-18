package models;

import org.json.JSONObject;

public class Metadata extends JSONObject {

    private String notification_url;

    private String custom_id;

    public Metadata(String notification_url, String custom_id) {
        this.notification_url = notification_url;
        this.custom_id = custom_id;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    @Override
    public String toString() {
        return "Metadata{" + "notification_url=" + notification_url + ", custom_id=" + custom_id + '}';
    }
    
    
}
