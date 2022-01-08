package htw.berlin.webtech.web.api;

import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;

import java.time.LocalDate;
import java.util.Map;

public class Poll {

    private long id;
    private String title;
    private String username;
    private String creationDate;
    private String endDate;
    private String options;
    private String votes;

    public Poll(long id, String title, String username, String creationDate, String endDate, String options, String votes) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.options = options;
        this.votes = votes;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

}
