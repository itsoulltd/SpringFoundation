package com.itsoul.lab.foundation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/application-${itsoul.lab.active}.properties")
public class ResourceConfig {

    @Value("${application.version}")
    private String version;

    public String getVersion() {
        return version;
    }

    //Example of Spring Expression lang.
    @Value("#{new Boolean(environment['itsoul.lab.active']=='dev')}")
    private boolean isDev;

    public boolean isDevEnv() {
        return isDev;
    }
}
