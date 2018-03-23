package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.QrtzUserDao;
import io.renren.modules.sys.entity.QrtzUserEntity;
import io.renren.modules.sys.service.QrtzUserService;


@Service("qrtzUserService")
public class QrtzUserServiceImpl extends ServiceImpl<QrtzUserDao, QrtzUserEntity> implements QrtzUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzUserEntity> page = this.selectPage(
                new Query<QrtzUserEntity>(params).getPage(),
                new EntityWrapper<QrtzUserEntity>()
        );

        return new PageUtils(page);
    }

}
