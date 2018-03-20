package org.apache.hbase.hbase_client;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

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
	      HTable hTable = new HTable(config, "TelemetryTEST");
	      
	      
	      try 
			{
	    	    int l = 0;
	    	    int count = 0;
				int index = 0;
				FileReader<DownlinkFrame> reader = new FileReader<DownlinkFrame>(DownlinkFrame.SCHEMA$, "frames.avro");
				DownlinkFrame frame = new DownlinkFrame();
				while (reader.hasNext()) 
			    {
			      reader.next(frame);
			      //System.out.print(index++ + ": " + frame.hashCode() + " ");
			      Calendar calendar = Calendar.getInstance();
			      calendar.setTimeInMillis(frame.getTimestamp());
			      ByteBuffer data = frame.getData();
  		          CharSequence gs = frame.getGs();
			      //frame.getGs()
			      			      
			      //System.out.print(calendar.getTime() + ", ");
			     // while (data.hasRemaining()) {
			    	  //System.out.print(String.format("%02X ", data.get()));
				      //System.out.println();
			    	  
			    	  count++;
//			    	  if (count<15) {
			    		  
			    		  
			    			
			       
			            Put p = new Put(Bytes.toBytes(l)); 
			              p.add(Bytes.toBytes("information"),Bytes.toBytes("GS"),
			            		  Bytes.toBytes(gs.toString()));
			    	      p.add(Bytes.toBytes("information"),Bytes.toBytes("Sat"),
			    	    		  Bytes.toBytes("Delfi-C3"));
			    	      p.add(Bytes.toBytes("status"),Bytes.toBytes("Proc"), 
			    	    		  Bytes.toBytes("0"));
		    	          p.add(Bytes.toBytes("values"),Bytes.toBytes("TS"),
		    	        		  Bytes.toBytes(frame.getTimestamp()));
			    	      p.add(Bytes.toBytes("values"),Bytes.toBytes("Data"),
			    	    		  Bytes.toBytes(data));
			    	      hTable.put(p);
			    	      l++;
			    	      
//			    	  }
//			    	  else break;

			      
			    }
			   
				 reader.close();
			    
			 
			}catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchElementException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		     
		      
		      // closing HTable
		         hTable.close();
		         System.out.println("data inserted!!!");
	   

	   
      }
	
}
