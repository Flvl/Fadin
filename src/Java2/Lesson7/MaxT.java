package Lesson7;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxT {

    private String maxT;
    private String unit;
    @JsonCreator
    public MaxT(@JsonProperty("Value") String maxT, @JsonProperty("Unit") String unit ){

        this.maxT=maxT;
        this.unit=unit;
    }

    public String getMaximumT(){
        return maxT+" "+unit;
    }
}
