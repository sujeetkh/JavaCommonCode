package in.iisc.csa.sujeet.common.pojo;

public class BQINFO {
String redshift_table;
String redshift_database;
String select_queries;
public String getRedshift_table() {
	return redshift_table;
}
public void setRedshift_table(String redshift_table) {
	this.redshift_table = redshift_table;
}
public String getRedshift_database() {
	return redshift_database;
}
public void setRedshift_database(String redshift_database) {
	this.redshift_database = redshift_database;
}
public String getSelect_queries() {
	return select_queries;
}
public void setSelect_queries(String select_queries) {
	this.select_queries = select_queries;
}
}
