package com.bgi.docking.dao;

import com.bgi.docking.pojo.Middle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 作者:Kangy
 * 日期:2019/9/20 0:34
 */
public interface MiddleDao extends JpaRepository<Middle,String>, JpaSpecificationExecutor<Middle> {

    List<Middle> findByStatus(String status);

    List<Middle> findMiddleByBusnbrAndStatus(Middle middle);

    /**
     * 根据状态 业务流水号
     * @param busnbr
     * @return
     */
    @Query(value = "from Middle where busnbr = ?1")
    Middle findByBusnbr(String busnbr);


}
