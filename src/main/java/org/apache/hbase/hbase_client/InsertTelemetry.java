package org.apache.hbase.hbase_client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.NoSuchElementException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import SDTL.FileOperations.FileReader;
import SDTL.Protocol.DownlinkFrame;

public class InsertTelemetry 
{

	
	public static void main(String[] args) throws IOException 
	{
		
	      // Instantiating Configuration class
	      Configuration config = HBaseConfiguration.create();

	      // Instantiating HTable class
	      HTable hTable = new HTable(config, "Telemetry1");
	      
	      
	      try 
			{
				int index = 0;
				FileReader<DownlinkFrame> reader = new FileReader<DownlinkFrame>(DownlinkFrame.SCHEMA$, "frames.avro");
				DownlinkFrame frame = new DownlinkFrame();
				while (reader.hasNext()) 
			    {
			      reader.next(frame);
			      System.out.print(index++ + ": " + frame.hashCode() + " ");
			      Calendar calendar = Calendar.getInstance();
			      calendar.setTimeInMillis(frame.getTimestamp());
			      ByteBuffer data = frame.getData();
			      
			      System.out.print(calendar.getTime() + ", ");
			      while (data.hasRemaining())
			          System.out.print(String.format("%02X ", data.get()));
			      System.out.println();
			    }
				reader.close();
			    
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchElementException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		      insert(hTable);
		      
		      // closing HTable
		      hTable.close();
	       
	       
	}
	
	public static void insert(HTable hTable) throws IOException 
	{
	


	      
	   // Instantiating Put class
	      // accepts a row name.
	      Put p = new Put(Bytes.toBytes("row1")); 

	      // adding values using add() method
	      // accepts column family name, qualifier/row name ,value
	      p.add(Bytes.toBytes("values"),
	      Bytes.toBytes("TS"),Bytes.toBytes("562398523"));

	      p.add(Bytes.toBytes("values"),
	      Bytes.toBytes("Data"),Bytes.toBytes("23.9"));

	      p.add(Bytes.toBytes("information"),Bytes.toBytes("GS"),
	      Bytes.toBytes("IT"));

	      p.add(Bytes.toBytes("information"),Bytes.toBytes("Sat"),
	      Bytes.toBytes("DelfiC3"));
	      
	      p.add(Bytes.toBytes("status"),Bytes.toBytes("Proc"),
	      Bytes.toBytes("0"));
	      
	      // Saving the put Instance to the HTable.
	      hTable.put(p);
	      System.out.println("data inserted");


	}
}
