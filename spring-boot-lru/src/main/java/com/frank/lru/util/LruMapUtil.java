package com.frank.lru.util;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.EvictionListener;
import com.googlecode.concurrentlinkedhashmap.Weighers;

/**
 *
 *
 * @author cy
 * @version LruMap.java, v 0.1 2020年06月23日 11:59 cy Exp $
 */
public class LruMapUtil {

    public static ConcurrentLinkedHashMap initMap() {
        EvictionListener<String, String> listener = (key, value) -> System.out.println("key=" + key + ", value = " + value + "数据被丢弃...");

        ConcurrentLinkedHashMap<String, String> map = new ConcurrentLinkedHashMap.Builder<String, String>()
                .maximumWeightedCapacity(50).listener(listener).weigher(Weighers.singleton()).build();

        for (int i = 0; i < 50; i++) {
            //map.put("")

        }

        return map;
    }

}
