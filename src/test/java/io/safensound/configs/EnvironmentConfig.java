package io.safensound.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:local-env.properties"
})
public interface EnvironmentConfig extends Config {

    /**
     * reads and returns the base url from a ${env}-env.properties file
     * @return The base url of the testing environment
     */
    @Key("base.url")
    public String baseUrl();

    @Key("base.uri")
    public String baseUri();

    @Key("port")
    public int port();
}