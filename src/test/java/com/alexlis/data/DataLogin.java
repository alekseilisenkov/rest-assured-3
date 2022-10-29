package com.alexlis.data;

import com.alexlis.config.MainConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * This class created only for example.
 * It will be use in next generations tests, maybe.
 */
public class DataLogin {

    MainConfig config = ConfigFactory.create(MainConfig.class, System.getProperties());

    public Map<String, String> getDataForLogin() {
        final Map<String, String> DATA = new HashMap<>();
        DATA.put("Email", config.getUserLogin());
        DATA.put("Password", config.getUserPassword());
        return DATA;
    }
}
