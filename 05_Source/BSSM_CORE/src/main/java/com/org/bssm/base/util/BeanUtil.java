package com.org.bssm.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * @param date
     * @return
     * @作者 x-wang
     * @创建日期 2015-8-3
     * @创建时间 下午12:22:40
     * @描述 —— bean转map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> convertToMap(Object arg) {
        try {
            if (arg instanceof Map) {
                return (Map<String, String>) arg;
            }
            Map<String, String> returnMap = BeanUtils.describe(arg);
            returnMap.remove("class");
            return returnMap;
        } catch (IllegalAccessException e) {
            logger.warn(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            logger.warn(e.getMessage(), e);
        } catch (NoSuchMethodException e) {
            logger.warn(e.getMessage(), e);
        }
        return new HashMap<String, String>();

    }

    /**
     * @param object
     * @return boolean
     * @throws Exception
     * @作者 x-wang
     * @描述 —— bean是否为空校验
     */
    public static boolean beanIsNull(Object object) throws Exception {

        boolean checkFlg = true;

        if (object == null) {
            return checkFlg;
        }

        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(object) != null) {
                checkFlg = false;
            }
        }

        return checkFlg;
    }
}
