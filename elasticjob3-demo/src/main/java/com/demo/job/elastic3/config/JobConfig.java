package com.demo.job.elastic3.config;

import com.demo.job.elastic3.jobs.OneOffSimpleJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.error.handler.email.EmailPropertiesConstants;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class JobConfig {

    @Resource
    private CoordinatorRegistryCenter registryCenter;

    @Bean
    public OneOffJobBootstrap oneOffSimpleJobBootstrap() {
        JobConfiguration jobConfiguration = JobConfiguration
                .newBuilder("oneOffSimpleJob", 1)
                .jobParameter("init bean")
                .overwrite(true)
                .jobErrorHandlerType("EMAIL")
                .build();
        setEmailProperties(jobConfiguration);
        OneOffJobBootstrap oneOffEmailJob =  new OneOffJobBootstrap(registryCenter, new OneOffSimpleJob(), jobConfiguration);

        oneOffEmailJob.execute();

        return oneOffEmailJob;
    }

    private static void setEmailProperties(final JobConfiguration jobConfig) {
        jobConfig.getProps().setProperty(EmailPropertiesConstants.HOST, "smtp.163.com");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.PORT, "465");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.IS_USE_SSL, "true");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.USERNAME, "xxx@163.com");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.PASSWORD, "xxx"); // 授权码
        jobConfig.getProps().setProperty(EmailPropertiesConstants.SUBJECT, "ElasticJob error message");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.FROM, "xxx@163.com");
        jobConfig.getProps().setProperty(EmailPropertiesConstants.TO, "xxx@qq.com");
    }
}
