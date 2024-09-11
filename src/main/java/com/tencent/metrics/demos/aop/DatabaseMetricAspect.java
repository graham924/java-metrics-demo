package com.tencent.metrics.demos.aop;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Aspect
public class DatabaseMetricAspect {

    private static final Logger log = LoggerFactory.getLogger(DatabaseMetricAspect.class);

    private final MeterRegistry meterRegistry;

    public DatabaseMetricAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Pointcut("@within(com.tencent.metrics.demos.anno.DatabaseMetric)")
    public void metricPointcut() {

    }

    @Around("metricPointcut()")
    public Object metricDaoProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeMs = System.currentTimeMillis();
        long endTimeMs = startTimeMs;
        boolean hasError = false;
        try {
            Object ret = joinPoint.proceed();
            endTimeMs = System.currentTimeMillis();
            return ret;
        } catch (Throwable e) {
            endTimeMs = System.currentTimeMillis();
            hasError = true;
            throw e;
        } finally {
            try {
                long timeCost = endTimeMs - startTimeMs;
                // 获取拦截点（pointcut）的函数签名
                if (joinPoint.getSignature() instanceof MethodSignature) {
                    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                    // 获取拦截点的类名
                    String pointClassName = methodSignature.getDeclaringTypeName();
                    String methodName = methodSignature.getName();
                    String clazzName = pointClassName;
                    if (pointClassName.lastIndexOf(".") > 0) {
                        clazzName = pointClassName.substring(pointClassName.lastIndexOf(".") + 1);
                    }

                    String path = clazzName + "." + methodName;

                    Duration [] sla = new Duration[]{
                            Duration.ofMillis(20),
                            Duration.ofMillis(50),
                            Duration.ofMillis(100),
                            Duration.ofMillis(500),
                            Duration.ofMillis(1000),
                            Duration.ofMillis(3000),
                    };
                    Timer.builder("db_client_requests_duration")
                            .description("database client request duration")
                            .sla(sla)
                            .tag("path",path)
                            .register(this.meterRegistry).record(timeCost, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable e) {
                log.error("report metrics error:{}", e.getMessage());
            }
        }
    }
}
