package in.iisc.csa.sujeet.common.bigquery;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

public class FetchSchema {
	public static void main(String[] args) {
		String projectId = "";
		String dataset = "test";
		String tableName = "test_table";
		BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
		TableId tableId = TableId.of(projectId, dataset, tableName);
		Table table = bigquery.getTable(tableId);
		Schema schema = table.getDefinition().getSchema();
		for (Field val : schema.getFields()) {
			System.out.println(val.getName() + " : " + val.getType());
		}
		FieldList fl = schema.getFields();
		Field f = Field.of("test", LegacySQLTypeName.INTEGER);
		fl.add(f);

	}
}