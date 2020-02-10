package io.safensound.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:local-login.properties" 
})
public interface LoginConfig extends Config {

    @Key("admin.username")
    public String adminUsername();

    @Key("admin.password")
    public String adminPassword();
}