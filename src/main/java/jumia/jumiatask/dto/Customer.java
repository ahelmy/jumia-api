package jumia.jumiatask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jumia.jumiatask.dto.country.CountryFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Customer {
    private final long id;
    private final String name;
    private final String phone;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("is_valid")
    private boolean isValid;

    public Customer(long id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.setCountryDetails();
    }

    private void setCountryDetails(){
        final var country = CountryFactory.getCountry(this.phone);
        this.isValid =  country.isPresent() && country.get().matchPhone(this.phone);
        if(country.isPresent()) {
            this.countryName = country.get().getName();
            this.countryCode = country.get().getCode();
        }
    }
}
