package com.blueice.springconditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Administrator on 2017/4/5.
 */
public class WindowsConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //如果当前操作系统是windows则返回真。
        boolean isWin = context.getEnvironment().getProperty("os.name").contains("windows");
        return isWin;
    }
}
