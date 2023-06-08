package com.example.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = ConfigurationManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl1() {
        return properties.getProperty("soap.baseurl1");
    }
    public static String getBaseUrl2() {

        return properties.getProperty("soap.baseurl2");
    }

    public static String getBaseUrl3() {

        return properties.getProperty("soap.baseurl3");
    }

    public static String getBaseUrl4() {

        return properties.getProperty("soap.baseurl4");
    }

    public static String getBaseUrl5() {

        return properties.getProperty("rest.baseurl5");
    }

    public static String getApiEndPoint() {

        return properties.getProperty("api.endpoint");
    }

    public static String getApiSpider() {

        return properties.getProperty("api.Spider");
    }

    public static String getApiPortalCES() {

        return properties.getProperty("api.PortalCES");
    }

    public static String getApiSolicitudNissan() {

        return properties.getProperty("api.SolicitudNissan");
    }

    public static String getApiNissanAdjudicación() {

                return properties.getProperty("api.NissanAdjudicacion");
    }


    public static String getApiConsultaCuotaReqRest() {

        return properties.getProperty("api.ConsultaCuotaReqRest");
    }
}
