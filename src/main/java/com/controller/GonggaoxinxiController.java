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

import com.entity.GonggaoxinxiEntity;
import com.entity.view.GonggaoxinxiView;

import com.service.GonggaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 公告信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-23 23:42:14
 */
@RestController
@RequestMapping("/gonggaoxinxi")
public class GonggaoxinxiController {
    @Autowired
    private GonggaoxinxiService gonggaoxinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggaoxinxiEntity gonggaoxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();


        //查询结果
		PageUtils page = gonggaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GonggaoxinxiEntity gonggaoxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();

        //查询结果
		PageUtils page = gonggaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggaoxinxiEntity gonggaoxinxi){
       	EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggaoxinxi, "gonggaoxinxi")); 
        return R.ok().put("data", gonggaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggaoxinxiEntity gonggaoxinxi){
        EntityWrapper< GonggaoxinxiEntity> ew = new EntityWrapper< GonggaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggaoxinxi, "gonggaoxinxi")); 
		GonggaoxinxiView gonggaoxinxiView =  gonggaoxinxiService.selectView(ew);
		return R.ok("查询公告信息成功").put("data", gonggaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggaoxinxiEntity gonggaoxinxi = gonggaoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gonggaoxinxi,deSens);
        return R.ok().put("data", gonggaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggaoxinxiEntity gonggaoxinxi = gonggaoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gonggaoxinxi,deSens);
        return R.ok().put("data", gonggaoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        GonggaoxinxiEntity gonggaoxinxi = gonggaoxinxiService.selectById(id);
        if(type.equals("1")) {
        	gonggaoxinxi.setThumbsupnum(gonggaoxinxi.getThumbsupnum()+1);
        } else {
        	gonggaoxinxi.setCrazilynum(gonggaoxinxi.getCrazilynum()+1);
        }
        gonggaoxinxiService.updateById(gonggaoxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增公告信息") 
    public R save(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoxinxi);
        gonggaoxinxiService.insert(gonggaoxinxi);
        return R.ok().put("data",gonggaoxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增公告信息")
    @RequestMapping("/add")
    public R add(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoxinxi);
        gonggaoxinxiService.insert(gonggaoxinxi);
        return R.ok().put("data",gonggaoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改公告信息")
    public R update(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoxinxi);
        //全部更新
        gonggaoxinxiService.updateById(gonggaoxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除公告信息")
    public R delete(@RequestBody Long[] ids){
        gonggaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
