package com.frank.loacl.common.test.service;

import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;

import java.io.File;
import java.io.InputStream;

/**
 *
 *
 * @author cy
 * @version StorageDemoService.java, v 0.1 2020年09月09日 09:33 cy Exp $
 */
public interface StorageDemoService {

    String put(String key, File file, InputStream input, ObjectMetadata metadata, PutObjectRequest putObjectRequest);

    String getMetadata(String key);

}
