package io.safensound.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:local-env.properties"
})
public interface EnvironmentConfig extends Config {

    @Key("base.url")
    public String baseUrl();

    @Key("base.uri")
    public String baseUri();

    @Key("port")
    public int port();
}