package com.dvbn.interceptor;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.dvbn.result.Result;
import com.dvbn.utils.BaseContext;
import com.dvbn.utils.ErrorCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author dvbn
 * @title: LoginInterceptor
 * @createDate 2023/9/19 10:39
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 判断是否需要拦截（ThreadLocal中是否有用户）
        if (BaseContext.getCurrentId() == null) {
            // 没有， 需要拦截，设置状态码
            // 创建响应数据
            Result<String> result = Result.error(ErrorCode.NO_AUTH_ERROR);

            // 设置序列化规则
            // 创建一个 JSONConfig对象，设置保留为null的字段
            JSONConfig config = new JSONConfig();
            config.setIgnoreNullValue(false);

            // 序列化
            String json = JSONUtil.toJsonStr(result, config);

            // 写回前端
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);

            // 拦截
            return false;
        }

        // 2. 有用户则放行
        return true;
    }
}
