package Lesson7;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MinT {

    private String minT;
    private String unit;
    @JsonCreator
    public MinT(@JsonProperty("Value") String minT, @JsonProperty("Unit") String unit ){

        this.minT=minT;
        this.unit=unit;
    }

    public String getMinimumT(){
        return minT+" "+unit;
    }
}
