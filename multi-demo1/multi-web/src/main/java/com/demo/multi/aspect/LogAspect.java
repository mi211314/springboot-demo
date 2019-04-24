package com.demo.multi.aspect;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: LogAspect
 * @Description:
 * @Date: 2019/4/22 14:41
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspect {

    /**
     * 线程变量（保存开始时间）
     */
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 线程变量（保存请求信息）
     */
    private ThreadLocal<Map<String, String>> message = new ThreadLocal<>();

    /**
     * 申明切点，里面是execution表达式
     * 第一个public表示方法的修饰符，可以用*代替
     * 第一个*表示返回值，*代表所有
     * com.demo.multi.controller..*包路径，.*表示路径下的所有包
     * 第三个.* 表示路径下，所有包下的所有类的方法
     * (..) 表示不限方法参数
     */
    @Pointcut("execution(public * com.demo.multi.controller..*.*(..))")
    private void controllerAspect() {

    }

    /**
     * 方法执行前打印的日志
     * @param joinPoint 切点
     */
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        // 开始时间
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 开始日志
        String startStr = "###理财超市###<<start>> traceId={[traceId]}|^|requestURL={[requestURL]}|^|methodId={[methodId]}|^|request={}";
        // 跟踪号
        String traceId = UUID.randomUUID().toString().replace("-", "");
        // 请求地址
        String requestURL = request.getRequestURL().toString();
        // 请求方法名
        String methodId = joinPoint.getSignature().toLongString();
        message.set(Maps.newHashMap());
        message.get().put("traceId", traceId);
        message.get().put("requestURL", requestURL);
        message.get().put("methodId", methodId);

        startStr = startStr.replace("[traceId]", traceId).replace("[requestURL]", requestURL).replace("[methodId]", methodId);
        log.info(startStr, joinPoint.getArgs());
    }

    /**
     * 方法执行后打印的日志
     * @param o 返回对象
     */
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturning(Object o) {
        // 请求耗时
        Long costTime = System.currentTimeMillis() - startTime.get();
        // 结束日志
        String endStr ="###理财超市###<<end>> traceId={[traceId]}|^|requestURL={[requestURL]}|^|methodId={[methodId]}|^|costTime={[costTime]}|^|response={}";
        // 跟踪号
        String traceId = message.get().get("traceId");
        // 请求地址
        String requestURL = message.get().get("requestURL");
        // 请求方法名
        String methodId = message.get().get("methodId");

        endStr = endStr.replace("[traceId]", traceId).replace("[requestURL]", requestURL).replace("[methodId]", methodId)
                .replace("[costTime]", costTime.toString());
        log.info(endStr, o);
    }

    @AfterThrowing(throwing = "e", pointcut = "controllerAspect()")
    public void methodAfterThrowing(Throwable e) {
        // 异常日志
        String str ="###理财超市###<<error>> traceId={[traceId]}|^|requestURL={[requestURL]}|^|methodId={[methodId]}|^|errorContent={}";
        // 跟踪号
        String traceId = message.get().get("traceId");
        // 请求地址
        String requestURL = message.get().get("requestURL");
        // 请求方法名
        String methodId = message.get().get("methodId");

        str = str.replace("[traceId]", traceId).replace("[requestURL]", requestURL).replace("[methodId]", methodId);
        log.error(str, e.getMessage(), e);
    }

}
