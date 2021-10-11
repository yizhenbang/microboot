package com.yzb.database.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TransactionConfiguration
 * Description:
 * date: 2021/10/5 18:02
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
@Aspect
public class TransactionConfiguration { //事物
    private final String TX_POINTCUT_EXPRESSION = "execution(* com.yzb.database.service.*.*(..))";//切点表达式
    private final int TX_TIMEOUT = 5000;//事物超时时间

    @Autowired
    private TransactionManager transactionManager;//事物管理器

    @Bean("txAdvice")
    public TransactionInterceptor advice() {
        //只读事物属性
        RuleBasedTransactionAttribute readOnlyAttribute = new RuleBasedTransactionAttribute();
        readOnlyAttribute.setReadOnly(true);
        readOnlyAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);//非事物运行

        //修改操作事物属性
        RuleBasedTransactionAttribute requireAttribute = new RuleBasedTransactionAttribute();
        requireAttribute.setTimeout(TX_TIMEOUT);//设置超时时间
        requireAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);//事物开启

        //映射所有可能的方法开启事务
        Map<String, TransactionAttribute> attributeMap = new HashMap<>();
        attributeMap.put("save*", requireAttribute);
        attributeMap.put("add*", requireAttribute);
        attributeMap.put("insert*", requireAttribute);
        attributeMap.put("delete*", requireAttribute);
        attributeMap.put("update*", requireAttribute);
        attributeMap.put("get*", readOnlyAttribute);
        attributeMap.put("list*", readOnlyAttribute);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.setNameMap(attributeMap);

        TransactionInterceptor transactionInterceptor = new TransactionInterceptor(transactionManager, source);
        return transactionInterceptor;

    }

    @Bean("txAdvisor")
    public Advisor advisor() {
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(TX_POINTCUT_EXPRESSION);

        return new DefaultPointcutAdvisor(aspectJExpressionPointcut, advice());
    }

}
