package jumia.jumiatask.dto.country;

import jumia.jumiatask.dto.country.list.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class CountryFactory {
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\(([0-9]+)\\)(.*)");
    private static final Map<String, Class<? extends ICountry>> COUNTRY_MAP = new HashMap<>();
    static {
        COUNTRY_MAP.put("237", Cameroon.class);
        COUNTRY_MAP.put("251", Ethiopia.class);
        COUNTRY_MAP.put("212", Morocco.class);
        COUNTRY_MAP.put("258", Mozambique.class);
        COUNTRY_MAP.put("256", Uganda.class);
    }
    public static Optional<ICountry> getCountry(String phone)  {
        final Optional<ICountry> emptyCountry = Optional.empty();
        final var matcher = PHONE_PATTERN.matcher(phone);

        if(!matcher.find() || matcher.groupCount()!=2)
            return emptyCountry;

        final var code = matcher.group(1);
        if(!StringUtils.hasLength(code))
            return emptyCountry;

        if(!COUNTRY_MAP.containsKey(code))
            return emptyCountry;

        try {
            return Optional.of(COUNTRY_MAP.get(code).getConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return emptyCountry;
    }
}
