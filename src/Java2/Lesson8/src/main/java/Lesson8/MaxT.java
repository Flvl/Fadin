package Lesson8;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxT {

    private Double maxT;
    private String unit;
    @JsonCreator
    public MaxT(@JsonProperty("Value") Double maxT, @JsonProperty("Unit") String unit ){

        this.maxT=maxT;
        this.unit=unit;
    }

    public Double getMaximumT(){
        return maxT;
    }
}
