package com.yzb.database.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * ClassName: MultiXADataSourceTransactionManager
 * Description:
 * date: 2021/10/10 0:15
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class MultiXADataSourceTransactionManager {
    @Bean("userTransaction")
    public UserTransaction getUserTransaction() throws SystemException {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(1000);
        return userTransactionImp;
    }

    @Bean("atomikosTransactionManager")
    public TransactionManager getXATransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);//关闭强制退出
        return userTransactionManager;
    }

    @Bean("transactionManager")
    @DependsOn({"userTransaction", "atomikosTransactionManager"})
    public PlatformTransactionManager transactionManager(
            UserTransaction userTransaction,
            TransactionManager atomikosTransactionManager
    ) {
        return new JtaTransactionManager(userTransaction, atomikosTransactionManager);
    }
}
