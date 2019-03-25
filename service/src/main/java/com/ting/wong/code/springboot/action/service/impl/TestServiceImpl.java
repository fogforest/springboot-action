package com.ting.wong.code.springboot.action.service.impl;


import com.ting.wong.code.springboot.action.dao.bo.master.MasterFirstTableDO;
import com.ting.wong.code.springboot.action.dao.bo.master.MasterFirstTableExample;
import com.ting.wong.code.springboot.action.dao.bo.slave.SlaveFirstTableDO;
import com.ting.wong.code.springboot.action.dao.bo.slave.SlaveFirstTableExample;
import com.ting.wong.code.springboot.action.dao.mapper.master.MasterFirstTableMapper;
import com.ting.wong.code.springboot.action.dao.mapper.slave.SlaveFirstTableMapper;
import com.ting.wong.code.springboot.action.service.interf.TestService;
import com.ting.wong.code.springboot.action.service.query.TestQuery;
import com.ting.wong.code.springboot.action.service.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 工作流调度service类
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/20
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MasterFirstTableMapper masterFirstTableMapper;

    @Autowired
    private SlaveFirstTableMapper slaveFirstTableMapper;

    @Override
    public List<TestVO> list(TestQuery query) {

        String name = "%" + query.getName() + "%";

        MasterFirstTableExample masterFirstTableExample = new MasterFirstTableExample();
        masterFirstTableExample.createCriteria().andNameLike(name);

        List<MasterFirstTableDO> masterFirstTableDOList = masterFirstTableMapper.selectByExample(masterFirstTableExample);

        List<TestVO> voList = new ArrayList<>(masterFirstTableDOList.size());
        masterFirstTableDOList.forEach(masterDO -> {
            voList.add(new TestVO(masterDO));
        });

        SlaveFirstTableExample slaveFirstTableExample = new SlaveFirstTableExample();
        slaveFirstTableExample.createCriteria().andNameLike(name);

        List<SlaveFirstTableDO> slaveFirstTableDOList = slaveFirstTableMapper.selectByExample(slaveFirstTableExample);

        slaveFirstTableDOList.forEach(slaveDO -> {
            voList.add(new TestVO(slaveDO));
        });

        return voList;
    }

    @Override
    public boolean addOrUpdate(TestVO vo) {
        if (vo == null) {
            return false;
        }
        MasterFirstTableDO masterFirstTableDO = buildDO(vo);
        if (masterFirstTableDO.getId() == null) {
            masterFirstTableDO.setCreateTime(new Date());
            return masterFirstTableMapper.insert(masterFirstTableDO) > 0;
        } else {
            masterFirstTableDO.setUpdateTime(new Date());
            return masterFirstTableMapper.updateByPrimaryKeySelective(masterFirstTableDO) > 0;
        }
    }

    @Override
    public boolean delete(long id) {
        MasterFirstTableDO masterFirstTableDO = new MasterFirstTableDO();
        masterFirstTableDO.setId(id);
        masterFirstTableDO.setDel(true);
        return masterFirstTableMapper.updateByPrimaryKeySelective(masterFirstTableDO) > 0;
    }

    public MasterFirstTableDO buildDO(TestVO vo) {
        MasterFirstTableDO masterFirstTableDO = new MasterFirstTableDO();
        masterFirstTableDO.setId(vo.getId());
        masterFirstTableDO.setName(vo.getName());
        masterFirstTableDO.setDescription(vo.getDesc());
        masterFirstTableDO.setUpdateTime(new Date());
        return masterFirstTableDO;
    }
}
