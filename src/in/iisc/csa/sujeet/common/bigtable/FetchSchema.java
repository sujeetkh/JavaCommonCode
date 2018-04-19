package in.iisc.csa.sujeet.common.bigtable;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos.ColumnFamilySchema;
import org.apache.hadoop.hbase.shaded.com.google.protobuf.Descriptors.FieldDescriptor;
//import org.apache.hadoop.hbase.util.Bytes;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;

public class FetchSchema {

	public static void main(String[] args) {
		String projectId = "";
		String instanceId = "";
		String tableName = "";
		try (Connection connection = BigtableConfiguration.connect(projectId, instanceId)) {

			Admin admin = connection.getAdmin();
			TableName[] tns = admin.listTableNames();

			for (TableName tn : tns) {
				System.out.println(tn.getNameAsString());
			}
			// byte[] columnFamilyName=Bytes.toBytes("f");
			Table table = connection.getTable(TableName.valueOf(tableName));
			HTableDescriptor descriptor = table.getTableDescriptor();
			HColumnDescriptor[] cols = descriptor.getColumnFamilies();
			for (HColumnDescriptor col : cols) {
				for (Map.Entry<String, String> val : col.getConfiguration().entrySet()) {
					System.out.println(val.getKey() + " : " + val.getValue());
				}
				ColumnFamilySchema csma = col.convert();
				for (Map.Entry<FieldDescriptor, Object> fd : csma.getAllFields().entrySet()) {
					FieldDescriptor fdk = fd.getKey();
					System.out.println(fdk.getFullName());
				}
			}
			Scan scan = new Scan();
			ResultScanner scanner = table.getScanner(scan);
			for (Result row : scanner) {
				for (Cell cell : row.listCells()) {
					System.out.println(new String(cell.getQualifierArray()));
				}
			}

		} catch (IOException e) {
			System.err.println("Exception while running HelloWorld: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

	}

}
