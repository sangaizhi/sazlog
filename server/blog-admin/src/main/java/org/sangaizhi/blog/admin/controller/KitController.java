package org.sangaizhi.blog.admin.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.entity.qo.KitBoxQO;
import org.sangaizhi.blog.entity.qo.KitQO;
import org.sangaizhi.blog.entity.vo.KitBoxVO;
import org.sangaizhi.blog.entity.vo.KitVO;
import org.sangaizhi.blog.service.KitBoxService;
import org.sangaizhi.blog.service.KitService;
import org.sangaizhi.common.constant.ResponseData;
import org.sangaizhi.common.constant.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/9/29
 */
@Controller
@RequestMapping("/kit")
public class KitController {

    @Autowired
    private KitService kitService;

    @Autowired
    private KitBoxService kitBoxService;

    /**
     * 工具列表
     * @param qo 查询条件
     * @return
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult list(KitQO qo){
        if(null == qo){
            qo = new KitQO();
        }
        KitBoxQO kitBoxQO = new KitBoxQO();
        List<KitBoxVO> kitBoxVOList = kitBoxService.queryList(kitBoxQO);
        if(CollectionUtils.isNotEmpty(kitBoxVOList)){
            for(KitBoxVO kitBoxVO : kitBoxVOList){
                qo.setKitBoxId(kitBoxVO.getId());
                List<KitVO> tempList = kitService.queryList(qo);
                if(CollectionUtils.isNotEmpty(tempList)){
                    kitBoxVO.setKitList(tempList);
                }
            }
        }
        return ResponseResult.ok("查询成功", new ResponseData(kitBoxVOList, null));
    }

}
