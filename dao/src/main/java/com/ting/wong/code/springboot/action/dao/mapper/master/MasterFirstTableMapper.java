package com.ting.wong.code.springboot.action.dao.mapper.master;

import com.ting.wong.code.springboot.action.dao.bo.master.MasterFirstTableDO;
import com.ting.wong.code.springboot.action.dao.bo.master.MasterFirstTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasterFirstTableMapper {
    long countByExample(MasterFirstTableExample example);

    int deleteByExample(MasterFirstTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasterFirstTableDO record);

    int insertSelective(MasterFirstTableDO record);

    List<MasterFirstTableDO> selectByExample(MasterFirstTableExample example);

    MasterFirstTableDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasterFirstTableDO record, @Param("example") MasterFirstTableExample example);

    int updateByExample(@Param("record") MasterFirstTableDO record, @Param("example") MasterFirstTableExample example);

    int updateByPrimaryKeySelective(MasterFirstTableDO record);

    int updateByPrimaryKey(MasterFirstTableDO record);
}