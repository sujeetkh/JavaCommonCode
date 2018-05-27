package in.iisc.csa.sujeet.common.jobs;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import in.iisc.csa.sujeet.common.pojo.Job;

public class JobsList {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		String minutelyJobsListURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=False&run_minutely=True&tags=preaggregates_15min&run_every_month=False";
		Job[] minutelyJobs = mapper.readValue(new URL(minutelyJobsListURLString), Job[].class);
		System.out.println("Total Number minutely Jobs: " + minutelyJobs.length);

		String minutelyLongString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=False&run_minutely=True&tags=preaggregates_long_15min&run_every_month=False";
		Job[] minutelyLongJobs = mapper.readValue(new URL(minutelyLongString), Job[].class);
		System.out.println("Total Number minutely Long Jobs: " + minutelyLongJobs.length);

		String hourlyJobsListURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=True&run_minutely=False&tags=preaggregates&run_every_month=False";
		Job[] hourlyJobs = mapper.readValue(new URL(hourlyJobsListURLString), Job[].class);
		System.out.println("Total Number Hourly Jobs: " + hourlyJobs.length);

		String hourlyLongJobsURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=True&run_minutely=False&tags=preaggregates_long&run_every_month=False";
		Job[] hourlyLongJobs = mapper.readValue(new URL(hourlyLongJobsURLString), Job[].class);
		System.out.println("Total Number Hourly Long Jobs: " + hourlyLongJobs.length);

		String dailyJobsListURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=False&run_minutely=False&tags=preaggregates&run_every_month=False";
		Job[] dailyJobs = mapper.readValue(new URL(dailyJobsListURLString), Job[].class);
		System.out.println("Total Number daily Jobs: " + dailyJobs.length);

		String dailyJobsLongURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=False&is_active=True&run_every_hour=False&run_minutely=False&tags=preaggregates_long&run_every_month=False";
		Job[] dailyLongJobs = mapper.readValue(new URL(dailyJobsLongURLString), Job[].class);
		System.out.println("Total Number daily Long Jobs: " + dailyLongJobs.length);

		String weeklyJobsListURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=True&is_active=True&run_every_hour=False&run_minutely=False&tags=preaggregates&run_every_month=False";
		Job[] weeklyJobs = mapper.readValue(new URL(weeklyJobsListURLString), Job[].class);
		System.out.println("Total Number weekly Jobs: " + weeklyJobs.length);

		String weeklyJobsLongURLString = "http://analytics.hike.in/hive_to_redshifts.json?run_every_week=True&is_active=True&run_every_hour=False&run_minutely=False&tags=preaggregates_long&run_every_month=False";
		Job[] weeklyLongJobs = mapper.readValue(new URL(weeklyJobsLongURLString), Job[].class);
		System.out.println("Total Number weekly Long Jobs: " + weeklyLongJobs.length);
		for (int i = 0; i < 24; i++) {
			int count = 0;
			for (Job job : weeklyJobs) {
				if (job.getIst_hour() == i) {
					// System.out.println(job.getId() + ":" + job.getIst_hour());
					count++;
				}
			}
			System.out.println("Hour: " + i + ", Jobs count: " + count);
		}
	}

}
