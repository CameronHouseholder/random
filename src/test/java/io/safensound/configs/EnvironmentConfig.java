package io.safensound.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:local-env.properties" // mention the property file name
})
public interface EnvironmentConfig extends Config {

    @Key("base.url")
    public String baseUrl();
}