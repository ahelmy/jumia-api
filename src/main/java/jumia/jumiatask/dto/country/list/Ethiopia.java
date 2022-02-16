package jumia.jumiatask.dto.country.list;

import jumia.jumiatask.dto.country.AbstractCountry;

public class Ethiopia extends AbstractCountry {

    @Override
    public String getCode() {
        return "251";
    }

    @Override
    protected String getPhonePattern() {
        return "\\(251\\)\\ ?[1-59]\\d{8}$";
    }
}
