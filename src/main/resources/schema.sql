-- Drop virtual table WoG (Word of God)
drop table if exists WoG;

-- Create virtual table WoG (Word of God)
create virtual table WoG using fts5(book,title,short_title,chapter,verse,scripture);

-- Create table Books
create table if not exists Book (
    id integer not null primary key,
    title text not null,
    short_title text not null,
    chapters integer not null
);

-- Create table Context
create table if not exists Context (
    id integer not null primary key,
    context text not null,
    short_context text not null,
    start_id integer not null,
    end_id integer not null
);