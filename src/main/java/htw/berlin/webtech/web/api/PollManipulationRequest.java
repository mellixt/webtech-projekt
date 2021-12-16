package htw.berlin.webtech.web.api;

import java.time.LocalDate;

public class PollManipulationRequest {

    private String title;
    private String username;
    private String creationDate;
    private String endDate;
    private String options;


    public PollManipulationRequest(String title, String username, String creationDate, String endDate, String options) {
            this.title = title;
            this.username = username;
            this.creationDate = creationDate;
            this.endDate = endDate;
            this.options = options;
    }

    public PollManipulationRequest() {}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
