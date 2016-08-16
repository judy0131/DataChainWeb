package com.cnic.datachain.common.util;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by pangbo on 2014/10/30.
 * good day commander!
 */
public class PropertyUtil {

    private static final String PROPERTY_FILE_NAME = "/config.properties";

	private Properties prop;
	
	private PropertyUtil(){
		prop = new Properties();
		InputStream fis;
		try {
			fis = this.getClass().getResourceAsStream(PROPERTY_FILE_NAME);
			prop.load(fis);    
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	private static PropertyUtil instance = null;
	public static PropertyUtil getInstance() {
		if(instance==null) {
			instance = new PropertyUtil();
		}
		return instance;
	}

    public BigDecimal getBigDecimalPropertyValue(String propertyKey) {
        String obj = prop.getProperty(propertyKey);
        if(obj!=null) {
            return BigDecimal.valueOf(Double.parseDouble(obj));
        }
        return null;
    }
	
	public Integer getIntegerPropertyValue(String propertyKey) {
		String obj = prop.getProperty(propertyKey);
		if(obj!=null) {
			return Integer.parseInt(obj);
		}
		return null;
	}
	
	public String getPropertyValue(String propertyKey) {
		Object obj = prop.get(propertyKey);
		if(obj!=null) {
			return (String)obj;
		}
		return null;
	}
}
