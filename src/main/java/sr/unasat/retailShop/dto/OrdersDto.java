package sr.unasat.retailShop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersDto {

    private String number;

    @JsonCreator
    public OrdersDto(@JsonProperty("number") String number) {

        this.number = number;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
