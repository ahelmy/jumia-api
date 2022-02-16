package jumia.jumiatask.dto.country.list;

import jumia.jumiatask.dto.country.AbstractCountry;

public class Mozambique extends AbstractCountry {
    @Override
    public String getCode() {
        return "258";
    }

    @Override
    protected String getPhonePattern() {
        return "\\(258\\)\\ ?[28]\\d{7,8}$";
    }
}
