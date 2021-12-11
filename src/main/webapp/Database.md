```sql
create table board (
	bno int primary key, 
    subject varchar(500) not null, 
    content text not null, 
    writer varchar(20) not null
);
```