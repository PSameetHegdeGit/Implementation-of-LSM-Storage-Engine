# Log Structured Merge Tree Based Storage Engine


## Information

Database storage engines are at the core of all databases. They manage I/O operations to a database and virtual memory
on behalf of the database. When building a storage engine, developers must consider a variety of factors such as read and write expectations for the database, 
i.e. what is the read and write throughput expected for the storage engine. Developers must employ different strategies
when factoring in throughput. Another factor is whether the database is structured, in which algorithms are designed to 
optimally structure data, or unstructured, where data is dumped as unstructured files. Several other factors exist including
whether the database is transactional or not (e.g. a read only db with high write throughput like a datalake), or whether 
the database is relational or non-relational (e.g. page structured db like MongoDB). 

Log structured merge (LSM) tree is a fundamental system design to implement database storage engines specifically 
for databases that expect high write throughput. Write operations are written to an in memory "memtable" and backed up
in an append only file known as a Write Ahead Log (WAL). LSM trees eschew traditional implementations where write operations
are immediately written to a structured file in disk after being cached in memory. While immediately writing to disk 
in a structured file enables a more durable database which is necessary for a transactional db with higher read throughput, 
this is undesirable for a db with high write throughput. Writing to a WAL is inexpensive relative to structured files in disk
since its append-only and therefore is a data dump. 

## Design

Below is the design of Log Structured Merge Tree:

### TODO ~ Provide Diagram

## Testing

### TODO



