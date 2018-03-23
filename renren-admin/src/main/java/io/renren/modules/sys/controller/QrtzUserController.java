package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.QrtzUserEntity;
import io.renren.modules.sys.service.QrtzUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-23 14:37:39
 */
@RestController
@RequestMapping("sys/qrtzuser")
public class QrtzUserController {
    @Autowired
    private QrtzUserService qrtzUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qrtzuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:qrtzuser:info")
    public R info(@PathVariable("id") String id){
			QrtzUserEntity qrtzUser = qrtzUserService.selectById(id);

        return R.ok().put("qrtzUser", qrtzUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qrtzuser:save")
    public R save(@RequestBody QrtzUserEntity qrtzUser){
			qrtzUserService.insert(qrtzUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qrtzuser:update")
    public R update(@RequestBody QrtzUserEntity qrtzUser){
			qrtzUserService.updateById(qrtzUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qrtzuser:delete")
    public R delete(@RequestBody String[] ids){
			qrtzUserService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
