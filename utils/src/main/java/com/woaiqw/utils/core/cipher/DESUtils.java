package com.woaiqw.utils.core.cipher;

import android.util.Log;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by haoran on 2019/2/18.
 */
public class DESUtils {
    private static final String TAG = "DESUtils";

    /**
     * 数据加密，算法（DES）
     *
     * @param data         要进行加密的数据
     * @param customDeskey 秘钥key
     * @return 加密后的数据
     */
    public static String encryptBasedDes(String data, String customDeskey) {
        String encryptedData = null;
        try {

            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(customDeskey.getBytes("UTF-8"));
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = encodeBase64(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            Log.d(TAG,"加密错误，错误信息：" + e);
        }
        return encryptedData;
    }


    /**
     * 数据解密，算法（DES）
     *
     * @param cryptData    加密数据
     * @param customDeskey 秘钥key
     * @return 解密后的数据
     */
    public static String decryptBasedDes(String cryptData, String customDeskey) {
        String decryptedData = null;
        try {
            byte[] decryptStr = decodeBase64(cryptData);
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(customDeskey.getBytes("UTF-8"));
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串解码为字节数组，并解密
            byte[] decryResult = cipher.doFinal(decryptStr);
            decryptedData = new String(decryResult, "UTF-8");
        } catch (Exception e) {
            Log.d(TAG,"解密错误，错误信息：" + e);
        }
        return decryptedData;
    }


    public static String encodeBase64(byte[] input) throws Exception {

        return android.util.Base64.encodeToString(input, android.util.Base64.NO_WRAP);

    }

    public static byte[] decodeBase64(String input) throws Exception {

        return android.util.Base64.decode(input, android.util.Base64.NO_WRAP);
    }
}
