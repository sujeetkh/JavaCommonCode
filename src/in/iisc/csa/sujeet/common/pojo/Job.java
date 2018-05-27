package in.iisc.csa.sujeet.common.pojo;

public class Job {
	int id;
	int ist_hour;
	int priority;
	boolean active;
	String intermediate_queries;
	String cleanup_queries;
	String updated_at;
	BQINFO[] mappings;
	String[] dependencies;
	String[] tags;
	boolean is_minutely;
	boolean is_hourly;
	boolean is_weekly;
	boolean is_monthly;
	boolean is_hive_only;
	String job_name;
	String job_group;
	String[] owner_emails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIst_hour() {
		return ist_hour;
	}
	public void setIst_hour(int ist_hour) {
		this.ist_hour = ist_hour;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getIntermediate_queries() {
		return intermediate_queries;
	}
	public void setIntermediate_queries(String intermediate_queries) {
		this.intermediate_queries = intermediate_queries;
	}
	public String getCleanup_queries() {
		return cleanup_queries;
	}
	public void setCleanup_queries(String cleanup_queries) {
		this.cleanup_queries = cleanup_queries;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public BQINFO[] getMappings() {
		return mappings;
	}
	public void setMappings(BQINFO[] mappings) {
		this.mappings = mappings;
	}
	public String[] getDependencies() {
		return dependencies;
	}
	public void setDependencies(String[] dependencies) {
		this.dependencies = dependencies;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public boolean isIs_minutely() {
		return is_minutely;
	}
	public void setIs_minutely(boolean is_minutely) {
		this.is_minutely = is_minutely;
	}
	public boolean isIs_hourly() {
		return is_hourly;
	}
	public void setIs_hourly(boolean is_hourly) {
		this.is_hourly = is_hourly;
	}
	public boolean isIs_weekly() {
		return is_weekly;
	}
	public void setIs_weekly(boolean is_weekly) {
		this.is_weekly = is_weekly;
	}
	public boolean isIs_monthly() {
		return is_monthly;
	}
	public void setIs_monthly(boolean is_monthly) {
		this.is_monthly = is_monthly;
	}
	public boolean isIs_hive_only() {
		return is_hive_only;
	}
	public void setIs_hive_only(boolean is_hive_only) {
		this.is_hive_only = is_hive_only;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_group() {
		return job_group;
	}
	public void setJob_group(String job_group) {
		this.job_group = job_group;
	}
	public String[] getOwner_emails() {
		return owner_emails;
	}
	public void setOwner_emails(String[] owner_emails) {
		this.owner_emails = owner_emails;
	}
	
}