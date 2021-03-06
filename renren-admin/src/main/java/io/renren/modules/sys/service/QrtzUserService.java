package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.QrtzUserEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-23 14:37:39
 */
public interface QrtzUserService extends IService<QrtzUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

