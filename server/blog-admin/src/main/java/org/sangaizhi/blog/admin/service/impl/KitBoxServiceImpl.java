package org.sangaizhi.blog.admin.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.admin.service.KitBoxService;
import org.sangaizhi.blog.entity.qo.KitQO;
import org.sangaizhi.blog.entity.vo.KitBoxVO;
import org.sangaizhi.blog.entity.vo.KitVO;
import org.sangaizhi.blog.service.KitService;
import org.sangaizhi.common.constant.LogConstants;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.exception.BusinessRuntimeException;
import org.sangaizhi.common.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/9/27
 */
@Service("adminKitBoxService")
public class KitBoxServiceImpl implements KitBoxService {

    private static final Logger logger = LoggerFactory.getLogger(KitBoxServiceImpl.class);

    @Autowired
    private org.sangaizhi.blog.service.KitBoxService kitBoxService;

    @Autowired
    private org.sangaizhi.blog.service.KitService kitService;


    @Override
    public void rename(Long id, String name) {
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS_START, "重命名工具箱", JacksonUtil.toJson(id, name));
        KitBoxVO kitBoxVO = kitBoxService.getById(id);
        if(null == kitBoxVO){
            logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "重命名工具箱没有找到对应工具箱", JacksonUtil.toJson(id, name));
           throw new BusinessRuntimeException("", "没有找到对应工具箱");
        }
        KitBoxVO kitBox = new KitBoxVO();
        kitBox.setId(id);
        kitBox.setName(name);
        kitBox.setModifyTime(new Date());
        kitBoxService.updateById(kitBox);
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS_END, "重命名工具箱", JacksonUtil.toJson(id, name));
    }

    @Override
    public void delete(Long id) {
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS_START, "删除工具箱", id);
        KitBoxVO kitBox = kitBoxService.getById(id);
        if(null == kitBox){
            logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "没有找到对应工具箱", id);
            throw new BusinessRuntimeException("", "没有找到对应工具箱");
        }
        KitQO kitQO = new KitQO();
        kitQO.setKitBoxId(id);
        List<KitVO> kitList = kitService.queryList(kitQO);
        if(CollectionUtils.isNotEmpty(kitList)){
            logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "工具箱已经关联工具", id);
            throw new BusinessRuntimeException("", "工具箱已经关联工具");
        }
        kitBoxService.deleteById(id);
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS_END, "删除工具箱", id);

    }
}
