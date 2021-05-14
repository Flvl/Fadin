package Lesson8;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {

    private String iconPhrase;
    @JsonCreator
    public Day(@JsonProperty("IconPhrase") String iconPhrase){

        this.iconPhrase=iconPhrase;
    }

    public String getIconPhrase(){
        return iconPhrase;
    }
}
