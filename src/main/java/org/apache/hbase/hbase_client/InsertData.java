package org.apache.hbase.hbase_client;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData{

   public static void main(String[] args) throws IOException {
	   System.out.println("stefano");

      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      System.out.println("stefano");
      
      // Instantiating HTable class
      HTable hTable = new HTable(config, "Telemetry1");

      System.out.println("stefano");
      
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
      
      Put p1 = new Put(Bytes.toBytes("row2")); 
      
      p1.add(Bytes.toBytes("values"),
      Bytes.toBytes("TS"),Bytes.toBytes("562394896"));

      p1.add(Bytes.toBytes("values"),
      Bytes.toBytes("Data"),Bytes.toBytes("22.5"));

      p1.add(Bytes.toBytes("information"),Bytes.toBytes("GS"),
      Bytes.toBytes("NL"));

      p1.add(Bytes.toBytes("information"),Bytes.toBytes("Sat"),
      Bytes.toBytes("DelfiC3"));
      
      p1.add(Bytes.toBytes("status"),Bytes.toBytes("Proc"),
      Bytes.toBytes("0"));
      
      // Saving the put Instance to the HTable.
      hTable.put(p1);
      System.out.println("data inserted");
      
      // closing HTable
      hTable.close();
   }
}