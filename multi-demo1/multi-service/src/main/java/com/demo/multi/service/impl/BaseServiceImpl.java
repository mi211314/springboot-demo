package com.demo.multi.service.impl;

import com.demo.multi.dao.CmbMemberMapper;
import com.demo.multi.model.CmbMember;
import com.demo.multi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BaseServiceImpl
 * @Description: BaseServiceImpl
 * @Date: 2019/4/22 11:02
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private CmbMemberMapper cmbMemberMapper;

    @Override
    public CmbMember selectByPrimaryKey(Long mid) {
        if (mid.equals(0L)) {
            throw new RuntimeException("测试异常！！！");
        }
        return cmbMemberMapper.selectByPrimaryKey(mid);
    }

}
