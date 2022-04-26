package com.demo.job.elastic3.jobs;

import java.time.LocalDateTime;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

@Component
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext arg0) {
        System.out.println(LocalDateTime.now().toString() + " job test.");
    }
    
}
