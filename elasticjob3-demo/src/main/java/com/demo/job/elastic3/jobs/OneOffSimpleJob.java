package com.demo.job.elastic3.jobs;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
// @Component
public class OneOffSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        String parameter = context.getJobParameter();
        log.info("OneOffSimpleJob test, context:{}", context);
        if (!StringUtils.hasText(parameter)) {
            throw new RuntimeException("parameter is empty");
        }
    }

}
