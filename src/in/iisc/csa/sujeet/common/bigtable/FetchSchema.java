package in.iisc.csa.sujeet.common.bigtable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
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
import org.apache.hadoop.hbase.util.Bytes;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;

public class FetchSchema {

	public static void main(String[] args) {
		String projectId = "hike-staging";
		String instanceId = "analytics-metrics-driven";
		String tableName = "wide_metrics";
		try (Connection connection = BigtableConfiguration.connect(projectId, instanceId)) {

			/*Admin admin = connection.getAdmin();
			TableName[] tns = admin.listTableNames();

			for (TableName tn : tns) {
				System.out.println(tn.getNameAsString());
			}*/
			byte[] columnFamilyName=Bytes.toBytes("f");
			Table table = connection.getTable(TableName.valueOf(tableName));
			/*HTableDescriptor descriptor = table.getTableDescriptor();
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
			}*/
			Scan scan = new Scan();
			scan.addFamily("f".getBytes());
			//String columnName="user_dau_status_raw_2_min";
			//scan.addColumn(columnFamilyName, Bytes.toBytes("user_dau_status_raw_4_min:1524806400"));
			//scan.setColumnFamilyTimeRange("f".getBytes(),  1525611669l, 1525681571l);
			ResultScanner scanner = table.getScanner(scan);
			for (Result row : scanner) {
				//System.out.println(Bytes.toString(row.getRow()));
				//System.out.println(StringUtils.newStringUtf8(row.getRow()));
				
				byte[] rowkey = row.getRow();
		        int metricValue = 0;
		       // byte[] columnName = Bytes.toBytes("user_dau_status_raw_4_min:1524806400");
		        byte[] valueBytes = row.value();
		        //.getValue("f".getBytes(), columnName);
		        
		        if (valueBytes != null) {
		               metricValue = Bytes.toInt(valueBytes);
		               byte[] objBytes = null;
		               try{
		                   ArrayUtils.reverse(rowkey);
		                   objBytes = Base64.encodeBase64(rowkey);
		               }catch (Exception e) {
		                   // TODO: handle exception
		                   System.out.println(e.getMessage());
		               }
		               String ret=new String(objBytes);
		            
		               System.out.println(ret+"###########"+metricValue);
		        }

			}

		} catch (IOException e) {
			System.err.println("Exception while running HelloWorld: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

	}

}
