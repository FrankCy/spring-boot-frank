package com.frank.sb.admin.client;

import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cy
 * @version $Id: Test.java, v 0.1 2020年06月05日 11:21 cy Exp $
 */
public class RefTest {
    public static void main(String[] args) throws Exception {
        String[] sr = new String[]{"序号#seq,问题#question,答案#ans","1,问题1,abc","2,问题2,def"};
        List<Question> ql = buildT(Question.class, sr);
        System.err.println(ql.toArray().toString());
    }

    public static <T> List<T> buildT(Class clazz, String[] sr) throws Exception {
        List<T> list = new ArrayList<T>();
        String[] sa = sr[0].split(",");
        String s = null;
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 0, len = sa.length; i < len; i++){
            s = sa[i];
            String[] _sa = s.split("#", 2);
            map.put(i, _sa[1]);
        }
        for(int i = 1, len = sr.length; i < len; i++){
            s = sr[i];
            String[] _sa = s.split(",");
            T t = (T) clazz.newInstance();

            for(int j = 0; j < _sa.length; j++){
                Field fi = clazz.getDeclaredField(map.get(j));
                fi.setAccessible(true);
                fi.set(t, _sa[j]);
            }
            list.add(t);
        }
        return list;
    }
}
