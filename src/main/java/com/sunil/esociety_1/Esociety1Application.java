package com.sunil.esociety_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling
public class Esociety1Application {

    public static void main(String[] args) {


        SpringApplication.run(Esociety1Application.class, args);
       /* try {

            JobDetail job1 = JobBuilder.newJob(EmailJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) //0 0 8 5,6,7,8,9,10 * ? *  //0/10 * * * * ?
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);


            Thread.sleep(100);

//            scheduler1.shutdown();


        } catch (Exception e) {
            e.printStackTrace();
        }*/



    }

}
