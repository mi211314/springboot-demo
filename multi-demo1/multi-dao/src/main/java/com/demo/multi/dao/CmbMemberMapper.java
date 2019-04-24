package com.demo.multi.dao;

import com.demo.multi.model.CmbMember;
import java.math.BigDecimal;

public interface CmbMemberMapper {

    int deleteByPrimaryKey(Long mid);

    int insert(CmbMember record);

    int insertSelective(CmbMember record);

    CmbMember selectByPrimaryKey(Long mid);

    int updateByPrimaryKeySelective(CmbMember record);

    int updateByPrimaryKey(CmbMember record);

}