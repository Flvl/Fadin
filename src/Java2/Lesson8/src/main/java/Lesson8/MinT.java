package Lesson8;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MinT {

    private Double minT;
    private String unit;
    @JsonCreator
    public MinT(@JsonProperty("Value") Double minT, @JsonProperty("Unit") String unit ){

        this.minT=minT;
        this.unit=unit;
    }

    public Double getMinimumT(){
        return minT;
    }
}
