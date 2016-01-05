package com.org.bssm.base.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 工具类
 * 
 * @author wx
 */
public class StringUtil {

    static final Character[] UP_AHPLA = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    static final Character[] LOW_AHPLA = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static final Character[] NUM = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     * 日期模式：年月日时分秒毫秒
     */
    public static final String DATE_PATTERN_TIMESTAMP_MS = "yyyyMMddHHmmssSSS";

    /**
     * 空字符
     */
    public static final String EMPTY = "";

    /**
     * 判断字符串是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null || str.trim().equals("") || str.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String s) {
        if (null != s && s.trim().length() != 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据要求字符串长度，数字左补零
     * 
     * @param s
     * @param length
     * @return
     * @author wx
     */
    public static String leftFillZero(String s, int length) {
        int fillLength = 0;
        if (s != null) {
            if (s.trim().length() > length) {
                return s.trim().substring(0, length);
            } else {
                fillLength = length - s.length();
            }
        } else {
            fillLength = length;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fillLength; i++) {
            sb.append("0");
        }

        if (s != null) {
            return sb.append(s).toString();
        } else {
            return sb.toString();
        }
    }

    /**
     * 去除字符串中的空格,换行,制表符
     * 
     * @param s
     * @return
     */
    public static String trim(String s) {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(s);
        String after = m.replaceAll("");
        return after;
    }

    public static String[] split(String s, String regex) {
        String[] sa = s.split(regex);

        return sa;
    }

    /**
     * 32位随机数字
     * 
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 将一个字符串转化为Date对象
     * 
     * @param format eg:yyyyMMdd HH:mm:ss
     * @param source date string
     * @return Date's type
     * @throws Exception
     */
    public static Date getDate(String format, String source) {

        try {
            return new SimpleDateFormat(format).parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将一个字符串转化为Date对象
     * 
     * @param source date string 默认格式:yyyyMMdd HH:mm:ss
     * @return Date's type
     * @throws Exception
     */
    public static Date getDate(String source) {

        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 通过传入不同的日期格式获取不同格式的系统时间；
     * 
     * @param formatstr String 时间格式（例如：yyyyMMdd HH:mm:ss）
     * @return String 带格式的系统时间
     * @throws TellerException
     */
    public static String getNowDate(String formatstr) {
        // 格式可以自己根据需要通过传入不同的日期格式进行修改；
        SimpleDateFormat lFormat = new SimpleDateFormat(formatstr);
        Date date = new Date(System.currentTimeMillis());
        return lFormat.format(date);
    }

    /**
     * 通过传入不同的日期格式获取不同格式的系统时间；
     * 
     * @param Date 传入的日期
     * @param formatstr String 时间格式（例如：yyyyMMdd HH:mm:ss）
     * @return String 带格式的系统时间
     * @throws TellerException
     */
    public static String getDateString(Date date, String formatstr) {

        return new SimpleDateFormat(formatstr).format(date);
    }

    /**
     * 通过传入日期获取时间的字符串；
     * 
     * @param Date 传入的日期
     * @return String 带格式的时间 String 时间格式（例如：yyyyMMdd HH:mm:ss）
     * @throws TellerException
     */
    public static String getDateString(Date date) {

        // 格式可以自己根据需要通过传入不同的日期格式进行修改；
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(date);
    }

    /**
     * 获取当前系统时间
     * 
     * @return new date
     * @throws Exception
     */
    public static Date getNewDate() {
        return new Date();
    }

    /**
     * 获取当前系统时间,格式yyyyMMdd HH:mm:ss
     * 
     * @return "yyyyMMdd HH:mm:ss" new date
     * @throws Exception
     */
    public static String getNowDate() {
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前系统时间的前一天,格式eg:yyyyMMdd HH:mm:ss
     * 
     * @param formatstr String 时间格式（例如：yyyyMMdd HH:mm:ss）
     * @return "yyyyMMdd HH:mm:ss" before date
     */
    public static String getBeforeDate(String formatstr) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day - 1);
        return new SimpleDateFormat(formatstr).format(calendar.getTime());
    }

    /**
     * 获取当前系统时间,格式yyyyMMddHHmmssSSS(17位) + UUID(32位)
     * 
     * @return "yyyyMMddHHmmssSSS"+UUID
     * @throws Exception
     */
    public static String getMessageId() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 获取当前系统时间,格式yyyyMMddHHmmssSSS(17位) + UUID(32位)
     * 
     * @return "yyyyMMddHHmmssSSS"+UUID
     * @throws Exception
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 功能描述: <br>
     * 字符串转金额格式（空值默认为0）
     * 
     * @param str
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal toBigDecimal(String str) {
        BigDecimal bd;
        if (null != str) {
            if (!"".equals(str)) {
                bd = new BigDecimal(str.trim());
            } else {
                bd = new BigDecimal("0");
            }
        } else {
            bd = new BigDecimal("0");
        }
        return bd;
    }

    /**
     * 功能描述: <br>
     * 组合时间
     * 
     * @param hour
     * @param minute
     * @param second
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String setSimpleTime(String hour, String minute, String second) {
        StringBuilder strTime = new StringBuilder();
        strTime.append(hour);
        strTime.append(":");
        strTime.append(minute);
        strTime.append(":");
        strTime.append(second);
        return strTime.toString();
    }

    /**
     * 功能描述: <br>
     * 截取字符串
     * 
     * @param str
     * @param subLength
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String subStr(String str, int subLength) {
        if (str == null) {
            return "";
        } else {
            int intSubLength = subLength;
            int tmpSubLength = intSubLength;
            String subStr = str.substring(0, str.length() < intSubLength ? str.length() : intSubLength);
            int subStrByetsL = 0;
            try {
                subStrByetsL = subStr.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            while (subStrByetsL > tmpSubLength) {
                int subLengthTmp = --intSubLength;
                subStr = str.substring(0, subLengthTmp > str.length() ? str.length() : subLengthTmp);
                try {
                    subStrByetsL = subStr.getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return subStr;
        }
    }

    /**
     * 功能描述: <br>
     * 判断是否为null或““
     * 
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述: <br>
     * 处理用格式字符串分开的字符串为数组形式
     * 
     * @param str
     * @param spritStr 分割字符串，默认为逗号（,）
     * @return String[]
     */
    public static String[] SpritForArray(String str, String spritStr) {
        if (null == str || "".equals(str)) {
            return null;
        }
        if (spritStr == null || "".equals(spritStr)) {
            spritStr = ",";
        }
        try {
            return str.split(spritStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 功能描述: <br>
     * 处理用格式字符串分开的字符串为数组形式
     * 
     * @param str
     * @param spritStr 分割字符串，默认为逗号（,）
     * @return String[]
     */
    public static List<String> SpritForList(String str, String spritStr) {
        if (null == str || "".equals(str)) {
            return null;
        }
        if (spritStr == null || "".equals(spritStr)) {
            spritStr = ",";
        }
        try {
            String s[] = str.split(spritStr);
            return new ArrayList<String>(Arrays.asList(s));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 功能描述: <br>
     * 处理列表中有效字符串为分割字符串分开的字符串形式
     * 
     * @param str
     * @param spritStr 分割字符串，默认为逗号（,）
     * @return String[]
     */
    public static String ListToString(List<String> str, String spritStr, boolean addQuots) {
        if (null == str) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        if (spritStr == null || "".equals(spritStr)) {
            spritStr = ",";
        }
        try {
            StringBuffer sb = new StringBuffer();
            for (String s : str) {
                if (!StringUtil.isNullOrEmpty(s)) {
                    if (addQuots) {
                        sb.append("'");
                    }
                    sb.append(s);
                    if (addQuots) {
                        sb.append("'");
                    }
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                return sb.toString().substring(0, sb.length() - 1);
            }
            return "";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 功能描述: <br>
     * 处理用格式字符串添加引号
     * 
     * @param str
     * @param spritStr 分割字符串，默认为逗号（,）
     * @return String[]
     */
    public static String StringAddQuots(String str, String spritStr) {
        if (str == null || "".equals(str)) {
            return str;
        }
        String[] s = SpritForArray(str, spritStr);
        StringBuffer sb = new StringBuffer("");
        if (s == null)
            return str;
        for (int i = 0; i < s.length; i++) {
            if (i != 0) {
                sb.append(spritStr);
            }
            sb.append("'").append(s[0]).append("'");
        }
        return sb.toString();
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机数字)
     * 
     * @param str
     * @return
     */
    public static String getRandNumString(int length) {
        return getRandString(NUM, length);
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机大写字母)
     * 
     * @param str
     * @return
     */
    public static String getRandUpAlphaString(int length) {
        return getRandString(UP_AHPLA, length);
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机小写字母)
     * 
     * @param str
     * @return
     */
    public static String getRandLowAlphaString(int length) {
        return getRandString(LOW_AHPLA, length);
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机大写字母和数字)
     * 
     * @param str
     * @return
     */
    public static String getRandNumAndUpAlphaString(int length) {
        Character[] c = ArrayUtil.Union(UP_AHPLA, NUM);
        Arrays.asList(UP_AHPLA);
        return getRandString(c, length);
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机小写字母和数字)
     * 
     * @param str
     * @return
     */
    public static String getRandNumAndLowAlphaString(int length) {
        Character[] c = ArrayUtil.Union(LOW_AHPLA, NUM);
        return getRandString(c, length);
    }

    /**
     * 功能描述: <br>
     * 取固定位数长度字符串(随机字母和数字)
     * 
     * @param str
     * @return
     */
    public static String getRandNumAndAlphaString(int length) {
        Character[] c = ArrayUtil.Union(UP_AHPLA, ArrayUtil.Union(LOW_AHPLA, NUM));
        return getRandString(c, length);
    }

    /**
     * 功能描述: <br>
     * 根据字符列表生成固定位数随机长度字符串
     * 
     * @param str
     * @return
     */
    public static String getRandString(Character[] c, int length) {
        if (length < 0) {
            return null;
        } else if (length == 0) {
            return "";
        }
        char[] res = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            res[i] = c[r.nextInt(c.length)];
        }
        return new String(res);
    }

    /**
     * 功能描述: <br>
     * 根据字符列表生成固定位数随机长度字符串
     * 
     * @param str
     * @return
     */
    public static String getRandString(char[] c, int length) {
        if (length < 0) {
            return null;
        } else if (length == 0) {
            return "";
        }
        char[] res = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            res[i] = c[r.nextInt(c.length)];
        }
        return new String(res);
    }

    /**
     * 功能描述: <br>
     * 将map中的String[]中的个数为1的String[]变成String 多于1个的会被剔除
     * 
     * @param Map<String, Object>
     * @return Map<String, String>
     */
    public static Map<String, String> consverStringMap(Map<String, Object> reqMap) {
        Map<String, String> map = new HashMap<String, String>();
        if (reqMap == null || reqMap.isEmpty()) {
            return map;
        }
        Set<String> keyset = reqMap.keySet();
        Iterator<String> it = keyset.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object o = reqMap.get(key);
            if (o instanceof String) {
                map.put(key, (String) o);
            } else if (o instanceof String[]) {
                if (((String[]) o).length > 0) {
                    map.put(key, ((String[]) o)[0]);
                }
            } else {
                map.put(key, String.valueOf(o));
            }
        }
        return map;
    }

    public static Map<String, Object> consverMap(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (reqMap == null || reqMap.isEmpty()) {
            return map;
        }
        Set<String> keyset = reqMap.keySet();
        Iterator<String> it = keyset.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object o = reqMap.get(key);
            if (o instanceof String) {
                map.put(key, (String) o);
            } else if (o instanceof String[]) {
                if (((String[]) o).length == 1) {
                    map.put(key, ((String[]) o)[0]);
                } else {
                    map.put(key, (String[]) o);
                }
            } else {
                map.put(key, o);
            }
        }
        return map;
    }

    /**
     * 功能描述: <br>
     * 将String 的两边加上对应的字符，为空或为null就不添加
     * 
     * @param String
     * @return String
     */

    public static String AddDefStrToString(String source, String str) {
        if (isNullOrEmpty(source) || isNullOrEmpty(str)) {
            return str;
        }
        return str + source + str;
    }

    /**
     * 功能描述: <br>
     * 将String 的后面加上对应的字符，为空或为null就不添加
     * 
     * @param String
     * @return String
     */

    public static String AddDefStrAfterString(String source, String str) {
        if (isNullOrEmpty(source) || isNullOrEmpty(str)) {
            return str;
        }
        return source + str;
    }

    /**
     * 功能描述: <br>
     * 将String 的前面加上对应的字符，为空或为null就不添加
     * 
     * @param String
     * @return String
     */
    public static String AddDefStrBeforeString(String source, String str) {
        if (isNullOrEmpty(source) || isNullOrEmpty(str)) {
            return str;
        }
        return source + str;
    }

    /**
     * 功能描述: <br>
     * 将String 的两边加上对应的字符，为空或为null就不添加
     * 
     * @param String
     * @return String
     */

    public static Map<String, Object> AddDefStrToStringForMap(Map<String, Object> map, String key, String str, int place) {
        if (map == null || map.isEmpty() || isNullOrEmpty(key) || isNullOrEmpty(str)) {
            return map;
        }

        Object value = (Object) map.get(key);
        if ((value instanceof String) && (!isNullOrEmpty((String) value))) {
            if (place == 0) {
                map.put(key, AddDefStrBeforeString((String) value, str));
            } else if (place == 1) {
                map.put(key, AddDefStrAfterString((String) value, str));
            } else {
                map.put(key, AddDefStrToString((String) value, str));
            }
        }
        return map;
    }

    /**
     * 格式化文本
     * 
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values 参数值
     * @return 格式化后的文本
     */
    public static String format(String template, Object... arguments) {
        if (StringUtil.isNullOrEmpty(template)) {
            return template;
        }
        if (arguments == null || arguments.length == 0) {
            return template.replace("{}", "");
        }
        return String.format(template.replace("{}", "%s"), arguments);
    }

    /**
     * 
     * 身份证号取性别
     */

    public static String fetchSexFromCertNo(String certNo) {
        String res = null;
        if (isNullOrEmpty(certNo)) {
            return res;
        }
        if (certNo.length() == 18 && isNumber(certNo.substring(16, 17))) {
            int s = Integer.parseInt(certNo.substring(16, 17)) % 2;
            if (s == 0) {
                // 女
                return "2";
            } else {
                // 男
                return "1";
            }
        }

        if (certNo.length() == 15 && isNumber(certNo.substring(13, 14))) {
            int s = Integer.parseInt(certNo.substring(13, 14)) % 2;
            if (s == 0) {
                // 女
                return "2";
            } else {
                // 男
                return "1";
            }
        }

        return res;
    }

    /**
     * 
     * 判断是否是数字 〈功能详细描述〉
     * 
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {

        try {
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");
            java.util.regex.Matcher match = pattern.matcher(str);
            if (match.matches() == false) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能描述: <br>
     * 为字符串补足长度
     * 
     * @param src
     * @param length
     * @param c
     * @return
     */
    public static String addCharsForLengthBeforeString(String src, int length, char c) {
        String res = src;
        if (isNullOrEmpty(res)) {
            return res;
        }
        int len = res.length();
        if (length <= len) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length - len; i++) {
            sb.append(c);
        }
        sb.append(res);
        return sb.toString();
    }

    /**
     * 功能描述: <br>
     * 字符串长度
     * 
     * @param src
     * @param length
     * @param c
     * @return
     */
    public static int getWordCount(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;

        }
        return length;

    }

    /**
     * @Title: anyIsEmpty
     * @Description: 判断是否为空
     * @author hl
     * @return boolean
     * @throws
     */
    public static boolean anyIsEmpty(Object... object) {
        for (Object o : object) {
            if (o == null) {
                return true;
            }
            if (o instanceof String) {
                if (isEmpty((String) o)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否为空
     * 
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if ("".equals(nvl(str))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 处理String null 如果是null 返回空字符串，否则返回trim后的String
     * 
     * @param value
     * @return String
     */
    public static String nvl(String value) {
        if (value == null) {
            return "";
        } else {
            return value.trim();
        }
    }
    
    /**
     * long 转换成字符串
     * 
     * @param value
     * @return String
     */
    public static String parseLong(Long value) {
        if (value == null) {
            return "";
        }
        else {
            return String.valueOf(value);
        }
    }
}
