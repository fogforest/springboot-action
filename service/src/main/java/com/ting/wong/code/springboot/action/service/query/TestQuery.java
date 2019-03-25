package com.ting.wong.code.springboot.action.service.query;

/**
 * 工作流调度的查询对象
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/20
 **/
public class TestQuery {
    private Long id;
    private String name;
    private String creator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
