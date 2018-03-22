# my_hbase-client
This code populates a HBase table with the frames taken from Avro. The HBase table is running on Docker.
The HBase table is called 'Telemetry' and has 3 column families: 'information', 'status' and 'values'.
The column family 'information' has 2 columns: 'GS' and 'Sat'.
'Status' has the column 'Proc'. The column family 'values' has 2 columns: 'TS' and 'Data'.
Accordingly, 'GS' provides the ground station information; Delfi-C3 has been assigned to 'Sat' by default, since the frame are
coming from Delfi-C3, the first CubeSat from TU Delft.
'Proc' tells wheter the data has been processed (1) or not (0). 'TS' is the timestamp.  
