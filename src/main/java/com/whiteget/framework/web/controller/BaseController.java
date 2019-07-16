package com.whiteget.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * controller基类
 *
 * @author fjc
 */
public class BaseController {

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 获取分页信息
     *
     * @param <E> 传入的泛型对象
     * @return mybatisplus的分页对象
     */
    public <E> Page<E> getPage() {
        int pageNumber = setPageNumAndSize("pageNumber", 1);
        int pageSize = setPageNumAndSize("pageSize", 10);
        return new Page<>(pageNumber, pageSize);
    }

    /**
     * 设置分页开始页和每页显示的条数
     *
     * @param key        请求的参数
     * @param defaultVal 默认值
     * @return 开始页或显示的条数
     */
    private int setPageNumAndSize(String key, int defaultVal) {
        String pageNumber = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest().getParameter(key);
        if (StringUtils.isBlank(pageNumber)) {
            return defaultVal;
        }
        return Integer.parseInt(pageNumber);
    }
}
