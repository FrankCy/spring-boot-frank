package com.frank.loacl.common.test.service.impl;

import com.frank.loacl.common.test.service.StorageDemoService;
import com.jtmm.common.activity.StorageActivity;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 *
 *
 * @author cy
 * @version StorageDemoServiceImpl.java, v 0.1 2020年09月09日 09:50 cy Exp $
 */
@Service("storageDemoServiceImpl")
public class StorageDemoServiceImpl implements StorageDemoService {

    /**
     * 需要使用邮件时注入此服务
     */
    @Autowired
    private StorageActivity storageActivity;

    /**
     * 上传服务
     * @param key 云端文件端标识
     * @param file 文件
     * @param input 文件流
     * @param metadata 元数据
     * @param putObjectRequest Tencent传递大文件端扩展对象（未实现）
     * @return
     */
    @Override
    public String put(String key, File file, InputStream input, ObjectMetadata metadata, PutObjectRequest putObjectRequest) {
        return storageActivity.put(key, file, input, metadata, putObjectRequest);
    }

    @Override
    public String getMetadata(String key) {
        return storageActivity.getMetadata(key);
    }

}
