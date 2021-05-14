package Lesson8;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    private MinT minT;
    private MaxT maxT;
    @JsonCreator
    public Temperature(@JsonProperty("Minimum") MinT minT, @JsonProperty("Maximum") MaxT maxT){

        this.minT=minT;
        this.maxT=maxT;
    }

    public Double getTemperature(){
        Double temperature=(minT.getMinimumT()+maxT.getMaximumT())/2;

        return temperature;
    }
}
