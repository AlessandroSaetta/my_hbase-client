package org.apache.hbase.hbase_client;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData{

   public static void main(String[] args) throws IOException {
	   //System.out.println("stefano");

      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      //System.out.println("stefano");
      
      // Instantiating HTable class
      HTable hTable = new HTable(config, "TelemetryGO87");

      //System.out.println("stefano");
      
      // Instantiating Put class
      // accepts a row name.
      for(int i=1;i<=6;i++) {
//      String s = String.valueOf(i);
      Put p = new Put(Bytes.toBytes(i)); 

      // adding values using add() method
      // accepts column family name, qualifier/row name ,value
      p.add(Bytes.toBytes("values"),
      Bytes.toBytes("TS"),Bytes.toBytes(i+10));

      p.add(Bytes.toBytes("values"),
      Bytes.toBytes("Data"),Bytes.toBytes("666"));

      p.add(Bytes.toBytes("information"),Bytes.toBytes("GS"),
      Bytes.toBytes("IT"));

      p.add(Bytes.toBytes("information"),Bytes.toBytes("Sat"),
      Bytes.toBytes("DelfiC3"));
      
      p.add(Bytes.toBytes("status"),Bytes.toBytes("Proc"),
      Bytes.toBytes("0"));
      
      //Put p1 = new Put(Bytes.toBytes("row2")); 
      
//      p1.add(Bytes.toBytes("values"),
//      Bytes.toBytes("TS"),Bytes.toBytes("562394999"));
//
//      p1.add(Bytes.toBytes("values"),
//      Bytes.toBytes("Data"),Bytes.toBytes("22.5"));
//
//      p1.add(Bytes.toBytes("information"),Bytes.toBytes("GS"),
//      Bytes.toBytes("NL"));
//
//      p1.add(Bytes.toBytes("information"),Bytes.toBytes("Sat"),
//      Bytes.toBytes("DelfiC3"));
//      
//      p1.add(Bytes.toBytes("status"),Bytes.toBytes("Proc"),
//      Bytes.toBytes("0"));
      
      // Saving the put Instance to the HTable.
      hTable.put(p);
      
      }
   // closing HTable
      hTable.close(); 
      System.out.println("data inserted*@!");

   }
}