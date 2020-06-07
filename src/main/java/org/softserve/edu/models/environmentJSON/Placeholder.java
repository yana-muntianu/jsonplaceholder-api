package org.softserve.edu.models.environmentJSON;

public class Placeholder {

    private String apiURL;

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @Override
    public String toString() {
        return "Placeholder{" +
                "apiURL='" + apiURL + '\'' +
                '}';
    }
}
