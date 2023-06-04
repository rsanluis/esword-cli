-- Drop virtual table WoG (Word of God)
drop table if exists WoG;

-- Create virtual table WoG (Word of God)
create virtual table WoG using fts5(b,c,v,s);

-- Create table Books
create table if not exists Books (
    id integer not null primary key,
    title text not null,
    short_title text not null,
    chapters integer not null
)