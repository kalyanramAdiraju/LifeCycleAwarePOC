package gmailsample.com.lifecycleaware.models;

import java.util.List;

/**
 * Created by nineleaps on 12/4/18.
 */

public class CountryModel {
    List<String> messages;
    List<CountryData> result;

    public List<CountryData> getResult() {
        return result;
    }

    public void setResult(List<CountryData> result) {
        this.result = result;
    }

    public List<String> getMessages() {

        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
