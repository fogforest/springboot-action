package com.ting.wong.code.springboot.action.dao.mapper.slave;

import com.ting.wong.code.springboot.action.dao.bo.slave.SlaveFirstTableDO;
import com.ting.wong.code.springboot.action.dao.bo.slave.SlaveFirstTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlaveFirstTableMapper {
    long countByExample(SlaveFirstTableExample example);

    int deleteByExample(SlaveFirstTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SlaveFirstTableDO record);

    int insertSelective(SlaveFirstTableDO record);

    List<SlaveFirstTableDO> selectByExample(SlaveFirstTableExample example);

    SlaveFirstTableDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SlaveFirstTableDO record, @Param("example") SlaveFirstTableExample example);

    int updateByExample(@Param("record") SlaveFirstTableDO record, @Param("example") SlaveFirstTableExample example);

    int updateByPrimaryKeySelective(SlaveFirstTableDO record);

    int updateByPrimaryKey(SlaveFirstTableDO record);
}