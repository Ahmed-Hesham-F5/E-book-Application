create table author (author_id nvarchar(10) primary key , Fname nvarchar(10),Lname nvarchar(10));

create table publisher (publisher_id nvarchar(10) primary key , name nvarchar(25),city nvarchar(15) );

create table subjects (subjects_id nvarchar(5) primary key, subjects nvarchar(20));

create table book(ISBN nvarchar(10) primary key , title nvarchar(50) not null , page_count int, price int  ,subjects_id nvarchar(5) foreign key references subjects, publisher_id nvarchar(10) foreign KEY references publisher ) ; 

create table publisher_phones(publisher_id nvarchar(10) foreign key references publisher , phone nvarchar(15) primary key );

create table authors_books(ISBN nvarchar(10) foreign key references book , author_id nvarchar(10) foreign key references author,CONSTRAINT PK_Person PRIMARY KEY (ISBN,author_id));
