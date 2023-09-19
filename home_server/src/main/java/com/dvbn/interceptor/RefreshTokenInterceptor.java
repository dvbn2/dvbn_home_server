package com.dvbn.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.dvbn.constant.RedisConstant;
import com.dvbn.utils.BaseContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


public class RefreshTokenInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求头中的token
        String token = request.getHeader("Token");

        if (StrUtil.isBlank(token)) { // 放行到第二个拦截器拦截
            return true;
        }
        // 2.基于token获取redis中的用户
        String id = stringRedisTemplate.opsForValue().get(RedisConstant.EMPLOYEE_LOGIN_TOKEN + token);
        // 3.判断用户是否存在
        if (StrUtil.isBlank(id)) { // 放行到第二个拦截器拦截
            return true;
        }
        // 5. 将查询到的id数据保存用户信息到ThreadLocal
        BaseContext.setCurrentId(Long.valueOf(id));

        // 7. 刷新token有效期 放行
        stringRedisTemplate.expire(RedisConstant.EMPLOYEE_LOGIN_TOKEN + token, RedisConstant.TOKEN_SURVIVE_TIME, TimeUnit.MINUTES);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 校验完移除用户
        BaseContext.removeCurrentId();
    }
}
