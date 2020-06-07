package org.softserve.edu.models.environmentJSON;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment {

        private Placeholder jsonPlaceholder;

    public Placeholder getJsonPlaceholder() {
        return jsonPlaceholder;
    }

    public void setJsonPlaceholder(Placeholder jsonPlaceholder) {
        this.jsonPlaceholder = jsonPlaceholder;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "jsonPlaceholder=" + jsonPlaceholder +
                '}';
    }
}
