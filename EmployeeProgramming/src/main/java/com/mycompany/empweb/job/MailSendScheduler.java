package com.mycompany.empweb.job;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.List;
import java.util.Map;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MailSendScheduler {
	
	public MailSendScheduler (List<Map<String, Object>> employeeList) {
		new MailSendJob(employeeList);
	}
	
	public static void main(String[] args) {
		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// and start it off
			scheduler.start();

			// define the job and tie it to our HelloJob class
			JobDetail job = newJob(MailSendJob.class).withIdentity("job2", "group2").build();

			// Trigger the job to run now, and then repeat every 5 seconds
			Trigger trigger = newTrigger().withIdentity("trigger1", "group2").startNow()
					.withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

			// Tell quartz to schedule the job using out trigger
			scheduler.scheduleJob(job, trigger);

			Thread.sleep(60000);

			scheduler.shutdown();
		} catch (SchedulerException se) {
			se.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
