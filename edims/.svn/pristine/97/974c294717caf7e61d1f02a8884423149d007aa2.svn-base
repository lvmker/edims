package com.bgi.docking.service;

import com.bgi.docking.dao.MiddleDao;
import com.bgi.docking.pojo.Middle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者:Kangy
 * 日期:2019/9/20 9:48
 *
 *
 */
@Service
public class MiddleSqlService {

    @Autowired
    private MiddleDao dao;

    /**
     * 根据状态查询数据
     * 状态表
     * CBS_EXPORTED(已导 出),
     * PAY_SUCCESS(支付成功),
     * PAY_FAIL(支付失败),
     * CBS_EXPORT_FAILED(导出失败)
     * @return
     */
    public List<Middle> findByStatus(String status){

        return dao.findByStatus(status);
    }

    /**
     * 根据业务流水号  查询数据
     * @param busnbr
     * @return
     */
    public Middle findByBusnbr(String busnbr){

        return dao.findByBusnbr(busnbr);
    }




}
