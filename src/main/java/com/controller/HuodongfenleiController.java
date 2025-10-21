package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.HuodongfenleiEntity;
import com.entity.view.HuodongfenleiView;

import com.service.HuodongfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-23 23:42:14
 */
@RestController
@RequestMapping("/huodongfenlei")
public class HuodongfenleiController {
    @Autowired
    private HuodongfenleiService huodongfenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongfenleiEntity huodongfenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();


        //查询结果
		PageUtils page = huodongfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongfenleiEntity huodongfenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();

        //查询结果
		PageUtils page = huodongfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongfenleiEntity huodongfenlei){
       	EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongfenlei, "huodongfenlei")); 
        return R.ok().put("data", huodongfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongfenleiEntity huodongfenlei){
        EntityWrapper< HuodongfenleiEntity> ew = new EntityWrapper< HuodongfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongfenlei, "huodongfenlei")); 
		HuodongfenleiView huodongfenleiView =  huodongfenleiService.selectView(ew);
		return R.ok("查询活动分类成功").put("data", huodongfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongfenleiEntity huodongfenlei = huodongfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huodongfenlei,deSens);
        return R.ok().put("data", huodongfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongfenleiEntity huodongfenlei = huodongfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huodongfenlei,deSens);
        return R.ok().put("data", huodongfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增活动分类") 
    public R save(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongfenlei);
        huodongfenleiService.insert(huodongfenlei);
        return R.ok().put("data",huodongfenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增活动分类")
    @RequestMapping("/add")
    public R add(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongfenlei);
        huodongfenleiService.insert(huodongfenlei);
        return R.ok().put("data",huodongfenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改活动分类")
    public R update(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongfenlei);
        //全部更新
        huodongfenleiService.updateById(huodongfenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除活动分类")
    public R delete(@RequestBody Long[] ids){
        huodongfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
