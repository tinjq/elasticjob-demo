package com.demo.job.elastic2.jobs;

import java.time.LocalDateTime;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        System.out.println(LocalDateTime.now().toString() + " job 2.x test.");
    }

}
