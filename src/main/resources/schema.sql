-- Drop the following tables if they exist
drop table if exists BibleFTS;
drop table if exists WordDan;

-- Create virtual table BibleFTS
create virtual table BibleFTS using FTS5(book,chapter,verse,scripture);

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
    context_desc text not null,
    start_id integer not null,
    end_id integer not null
);

-- Create table Word
create table if not exists WordDan (
    id integer not null primary key autoincrement,
    word text not null unique,
    matches integer default 0
);

drop index word_idx;
drop index matches_idx;
create index word_idx on WordDan (word);
create index matches_idx on WordDan (matches);