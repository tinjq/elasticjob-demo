package com.demo.job.elastic3.controller;

import com.demo.job.elastic3.jobs.OneOffSimpleJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jobs")
public class OneOffJobController {

    // @Resource(name = "oneOffSimpleJobBootstrap")
    // private OneOffJobBootstrap oneOffSimpleJobBootstrap;

    @Resource
    private CoordinatorRegistryCenter registryCenter;

    @GetMapping("/oneOffSimpleJob")
    public String OneOffEmailJob(@RequestParam("jobParameter") String jobParameter) {
        // oneOffSimpleJobBootstrap.execute();
        JobConfiguration jobConfiguration = JobConfiguration
                .newBuilder("oneOffSimpleJob123", 1)
                .jobParameter(jobParameter)
                .overwrite(true)
                .build();
        OneOffJobBootstrap oneOffEmailJob =  new OneOffJobBootstrap(registryCenter, new OneOffSimpleJob(), jobConfiguration);
        oneOffEmailJob.execute();

        return "success";
    }
}
