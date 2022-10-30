package com.rgshop.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BeanUtil {
    public static Object copyParams(Class clazz, HttpServletRequest request){
        Object bean = null;
        try {
            bean = clazz.getConstructor().newInstance();
            Map params = request.getParameterMap();
            Set set = params.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String name = (String) entry.getKey();
                Object[] values = (Object[]) entry.getValue();

                if(values!=null){
                    if(values.length == 1){
                        BeanUtils.copyProperty(bean, name, values[0]);
                    }else {
                        BeanUtils.copyProperty(bean, name, values);
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
