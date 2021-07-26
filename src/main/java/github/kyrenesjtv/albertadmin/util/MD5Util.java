package github.kyrenesjtv.albertadmin.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.*;

public class MD5Util {
    /**
     * Title: MD5加密 生成32位md5码
     * Description: TestDemo
     * @author lu
     * @date 2016年6月23日 下午2:36:07
     * @param inStr
     * @return 返回32位md5码
     * @throws Exception
     */
    public static String md5Encode(String inStr) throws UnsupportedEncodingException {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    /**
     * Title: MD5加密
     * Description: TestDemo
     * @author lu
     * @date 2016年6月23日 下午2:43:31
     * @param inStr
     * @return
     */
    public static String md5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * Title: 加密解密算法 执行一次加密，两次解密
     * Description: TestDemo
     * @author lu
     * @date 2016年6月23日 下午2:37:29
     * @param inStr
     * @return
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
    public static String md5Decode(String str) {
        return convertMD5(convertMD5(str));
    }

    public static void main(String[] args) {
        String s = new String("13917114404");
        System.out.println(md5(s));
      /*  System.out.println("原始：" + s);
        System.out.println("MD5后：" + md5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
        System.out.println(md5("13917114404"));*/
    }

    /**
     * 生成微信支付sign
     * @return
     */
    public static String createSign(SortedMap<String, String> params){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> es =  params.entrySet();
        Iterator<Map.Entry<String,String>> it =  es.iterator();

        //生成 stringA="appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
        while (it.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String,String>)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(null != v && !"".equals(v) && !"sign".equals(k)){
                sb.append(k+"="+v+"&");
            }
        }

        String sign = MD5(sb.toString()).toUpperCase();
        return sign;
    }


    /**
     * 校验签名
     * @param params
     * @param key
     * @return
     */
    public static boolean isCorrectSign(SortedMap<String, String> params){
        String sign = createSign(params);

        String weixinPaySign = params.get("sign").toUpperCase();
        return weixinPaySign.equals(sign);
    }


    /**
     * 获取有序map
     * @param map
     * @return
     */
    public static SortedMap<String,String> getSortedMap(Map<String,String> map){

        SortedMap<String, String> sortedMap = new TreeMap<>();
        Iterator<String> it =  map.keySet().iterator();
        while (it.hasNext()){
            String key  = (String)it.next();
            String value = map.get(key);
            String temp = "";
            if( null != value){
                temp = value.trim();
            }
            sortedMap.put(key,temp);
        }
        return sortedMap;
    }


    /**
     * md5常用工具类
     * @param data
     * @return
     */
    public static String MD5(String data){
        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte [] array = md5.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }




}