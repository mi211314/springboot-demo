package com.demo.multi.service;

import com.demo.multi.model.CmbMember;

/**
 * @ClassName: BaseService
 * @Description: BaseService
 * @Date: 2019/4/22 11:01
 */
public interface BaseService {

    CmbMember selectByPrimaryKey(Long mid);

}
