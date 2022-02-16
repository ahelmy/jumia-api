package jumia.jumiatask.dto.country.list;

import jumia.jumiatask.dto.country.AbstractCountry;

public class Morocco extends AbstractCountry {

    @Override
    public String getCode() {
        return "212";
    }

    @Override
    protected String getPhonePattern() {
        return " \\(212\\)\\ ?[5-9]\\d{8}$";
    }
}
