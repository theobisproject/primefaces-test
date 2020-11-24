package org.primefaces.test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@SessionScoped
public class LoggingBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(LoggingBean.class);
    
    public void logMessageOnBrowserClose() {
        logger.info("Browser was closed");
    }
}
