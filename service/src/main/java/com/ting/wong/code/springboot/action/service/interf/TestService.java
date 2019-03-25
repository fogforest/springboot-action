package com.ting.wong.code.springboot.action.service.interf;

import com.ting.wong.code.springboot.action.service.query.TestQuery;
import com.ting.wong.code.springboot.action.service.vo.TestVO;

import java.util.List;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2019/3/21
 * @description 业务逻辑处理
 **/
public interface TestService {
    /**
     * 根据查询对象查询
     * @param query
     * @return
     */
    List<TestVO> list(TestQuery query);

    /**
     * 新增或者更新工作流调度
     * @param vo
     * @return
     */
    boolean addOrUpdate(TestVO vo);

    /**
     * 根据ID删除工作流定义
     * @param id
     * @return
     */
    boolean delete(long id);
}
