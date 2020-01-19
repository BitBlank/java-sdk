package app.b.sdk.server.util;

import app.b.sdk.server.ApiConstants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BappSignUtil {
    private BappSignUtil() {
    }

    public static boolean isSignOk(Map<String, ?> data, String appSecret) {
        String paramSign = (String) data.get(ApiConstants.PARAM.SIGN);
        if (StringUtils.isEmpty(paramSign) || StringUtils.isEmpty(appSecret)) {
            return false;
        }
        String calcSign = createSign(data, appSecret);
        return paramSign.equals(calcSign);
    }

    public static String createSign(Map<String, ?> data, String appSecret) {
        StringBuilder signOrigin = new StringBuilder();
        if (data != null && !data.isEmpty()) {
            List<String> keys = new ArrayList<>(data.keySet());
            Collections.sort(keys);
            for (String key : keys) {
                if (StringUtils.isEmpty(key) || data.get(key) == null || ApiConstants.PARAM.SIGN.equals(key)) {
                    continue;
                }
                signOrigin.append(key).append('=').append(data.get(key)).append('&');
            }
        }
        appendIfNotEmpty(signOrigin, ApiConstants.PARAM.APP_SECRET, appSecret);

        signOrigin.deleteCharAt(signOrigin.length() - 1);
        String signOriginStr = signOrigin.toString();

        return DigestUtils.md5Hex(signOriginStr);
    }

    private static void appendIfNotEmpty(StringBuilder sb, String key, String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        sb.append(key).append('=').append(value).append('&');
    }
}
