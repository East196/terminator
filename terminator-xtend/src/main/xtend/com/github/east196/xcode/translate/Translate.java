package com.github.east196.xcode.translate;

import java.io.IOException;
import java.util.Map;

import org.boon.Boon;

import com.google.common.base.CaseFormat;

/**
 * 百度翻译
 */
public class Translate {
	
	public static String execute(String fieldName) throws IOException {
		return formatResult(translateFieldName(fieldName));
	}


    public static String translateFieldName(String fieldName) throws IOException {
    	Map<String, Object> ctx = Boon.resourceMap("app.json");
    	System.out.println(ctx);
    	String APP_ID = ctx.get("APP_ID").toString();
    	String SECURITY_KEY = ctx.get("SECURITY_KEY").toString();
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        Object value = Boon.fromJson(api.getTransResult(fieldName, "auto", "en"));
        String result = Boon.atIndex(value, "trans_result[0].dst").toString();
        return result;
    }

    public static String formatResult(String result) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, result.replace(" ","_").replace("\"","").replace("/","").replace("-","").replace(",",""));
    }

    public static void main(String[] args) {
        try {
            System.out.println(execute("I/O状态"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
