package com.ting.wong.code.springboot.action.service.vo;

import com.ting.wong.code.springboot.action.dao.bo.master.MasterFirstTableDO;
import com.ting.wong.code.springboot.action.dao.bo.slave.SlaveFirstTableDO;

import java.text.SimpleDateFormat;

/**
 * 视图对象
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/20
 **/
public class TestVO {

    private Long id;
    private String name;
    private String desc;
    private String createTime;

    public TestVO(MasterFirstTableDO masterFirstTableDO) {
        this.id = masterFirstTableDO.getId();
        this.name = masterFirstTableDO.getName();
        this.desc = masterFirstTableDO.getDescription();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createTime = simpleDateFormat.format(masterFirstTableDO.getCreateTime());
    }

    public TestVO(SlaveFirstTableDO slaveFirstTableDO) {
        this.id = slaveFirstTableDO.getId();
        this.name = slaveFirstTableDO.getName();
        this.desc = slaveFirstTableDO.getDescription();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createTime = simpleDateFormat.format(slaveFirstTableDO.getCreateTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TestVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
