package jumia.jumiatask.dto.country.list;

import jumia.jumiatask.dto.country.AbstractCountry;

public class Uganda extends AbstractCountry {

    @Override
    public String getCode() {
        return "256";
    }

    @Override
    protected String getPhonePattern() {
        return " \\(256\\)\\ ?\\d{9}$";
    }
}
