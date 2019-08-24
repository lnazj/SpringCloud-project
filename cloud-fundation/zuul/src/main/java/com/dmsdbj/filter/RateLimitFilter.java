package com.dmsdbj.filter;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流-令牌桶算法
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-23
 */
public class RateLimitFilter extends ZuulFilter{

    // 每秒钟1000个令牌
    private static final RateLimiter RATE_LIMITER= RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        if (!RATE_LIMITER.tryAcquire()) {
            System.out.println("没有获得令牌，限流");
        }
        return null;
    }
}
