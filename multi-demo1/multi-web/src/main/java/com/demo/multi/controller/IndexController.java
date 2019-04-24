package com.demo.multi.controller;

import com.demo.multi.model.CmbMember;
import com.demo.multi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Description: IndexController
 * @Date: 2019/4/22 10:57
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("/selectMemberByMid")
    public CmbMember selectMemberByMid(@RequestBody Long mid) {
        CmbMember cmbMember = baseService.selectByPrimaryKey(mid);
        return cmbMember;
    }

}
