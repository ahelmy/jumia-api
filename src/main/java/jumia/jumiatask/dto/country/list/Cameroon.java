package jumia.jumiatask.dto.country.list;

import jumia.jumiatask.dto.country.AbstractCountry;

public class Cameroon extends AbstractCountry {

    @Override
    public String getCode() {
        return "237";
    }

    @Override
    protected String getPhonePattern() {
        return "\\(237\\)\\ ?[2368]\\d{7,8}$";
    }
}
