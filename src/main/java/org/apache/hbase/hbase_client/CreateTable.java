package org.apache.hbase.hbase_client;
import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.BasicConfigurator;
import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.conf.Configuration;

public class CreateTable {
	private static HBaseAdmin admin;

	public static void main(String[] args) throws IOException {
		  BasicConfigurator.configure();

	      // Instantiating configuration class
	      Configuration con = HBaseConfiguration.create();
        
	      admin = new HBaseAdmin(con);

	      // Instantiating table descriptor class
	      HTableDescriptor tableDescriptor = new
	      HTableDescriptor(TableName.valueOf("TelemetryTEST"));

	      // Adding column families to table descriptor
	      tableDescriptor.addFamily(new HColumnDescriptor("values"));
	      tableDescriptor.addFamily(new HColumnDescriptor("information"));
	      tableDescriptor.addFamily(new HColumnDescriptor("status"));

	      // Execute the table through admin
	      admin.createTable(tableDescriptor);
	      System.out.println(" Table created ");
	   }

}
