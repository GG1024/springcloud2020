package com.lucky.sz.service.impl;

import com.lucky.sz.dao.StorageDao;
import com.lucky.sz.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @FileName: StorageService.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("----> storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("----> storage-service中扣减库存结束");
    }

}
