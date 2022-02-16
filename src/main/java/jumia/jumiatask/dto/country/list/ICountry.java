package jumia.jumiatask.dto.country.list;

public interface ICountry {
    String getName();

    String getCode();

    boolean matchPhone(String phone);
}
