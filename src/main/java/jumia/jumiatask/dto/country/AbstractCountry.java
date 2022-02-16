package jumia.jumiatask.dto.country;

import jumia.jumiatask.dto.country.list.ICountry;

import java.util.regex.Pattern;

public abstract class AbstractCountry implements ICountry {
    protected Pattern phonePattern;
    public AbstractCountry(){
        this.phonePattern = Pattern.compile(getPhonePattern());
    }

    @Override
    public boolean matchPhone(final String phone){
        return this.phonePattern.matcher(phone).matches();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    protected abstract String getPhonePattern();


}
