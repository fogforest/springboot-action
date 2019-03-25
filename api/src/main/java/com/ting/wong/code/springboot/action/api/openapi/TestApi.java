package com.ting.wong.code.springboot.action.api.openapi;

import com.ting.wong.code.springboot.action.api.enums.ResCode;
import com.ting.wong.code.springboot.action.api.base.RestResponse;
import com.ting.wong.code.springboot.action.service.exception.ApiException;
import com.ting.wong.code.springboot.action.service.exception.ApiLogErrorException;
import com.ting.wong.code.springboot.action.service.interf.TestService;
import com.ting.wong.code.springboot.action.service.query.TestQuery;

import com.ting.wong.code.springboot.action.service.vo.TestVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 工作流定时调度接口
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/19
 **/
@RestController
@RequestMapping("test")
public class TestApi {

    @Autowired
    TestService service;

    @PostMapping("addOrUpdate")
    public RestResponse addOrUpdate(TestVO vo) {
        if (vo == null) {
            return RestResponse.ILLEGAL_PARAMS;
        }
        if (StringUtils.isBlank(vo.getName())) {
            return RestResponse.ILLEGAL_PARAMS;
        }
        boolean b = service.addOrUpdate(vo);
        if (b) {
            return RestResponse.SUCCESS;
        } else {
            return RestResponse.FAILED;
        }
    }

    @PostMapping("delete")
    public RestResponse delete(Long id) {
        if (id == null) {
            return RestResponse.ILLEGAL_PARAMS;
        }
        boolean delete = service.delete(id);
        if (delete) {
            return RestResponse.SUCCESS;
        } else {
            return RestResponse.FAILED;
        }
    }

    @GetMapping("list")
    public RestResponse list(TestQuery query) {
        List<TestVO> testVOList = service.list(query);
        System.out.println("just test");
        RestResponse resp = new RestResponse(ResCode.SUCCESS, testVOList);
        System.out.println(resp);
        return resp;
    }

    @GetMapping("testException")
    public RestResponse testErrorException(String type) {

        if ("error".equals(type)) {
            throw new ApiLogErrorException("yes just testErrorException ");
        }

        if ("nomal".equals(type)) {
            throw new ApiException("yes just testNomalException ");
        }

        return RestResponse.SUCCESS;
    }

}
