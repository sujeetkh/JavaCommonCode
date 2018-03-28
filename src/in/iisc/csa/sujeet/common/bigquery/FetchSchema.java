package in.iisc.csa.sujeet.common.bigquery;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

public class FetchSchema {
	public static void main(String[] args) {
		BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
		TableId tableId = TableId.of("analytics-156605", "test", "wide_metrics_test_cases");
		Table table = bigquery.getTable(tableId);
		Schema schema = table.getDefinition().getSchema();
		for (Field val : schema.getFields()) {
			System.out.println(val.getName()+" : "+val.getType());
		}
	}
}
