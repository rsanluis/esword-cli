-- Drop the following tables if they exist
drop table if exists BibleFTS;

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

-- Create table WordMatchesBible
create table if not exists WordMatchesBible (
    id integer not null primary key autoincrement,
    word text not null unique,
    matches integer default 0
);

-- Create table WordMatchesDan
create table if not exists WordMatchesDan (
    id integer not null primary key autoincrement,
    word text not null unique,
    matches integer default 0
);

-- Create table WordMatchesRev
create table if not exists WordMatchesRev (
    id integer not null primary key autoincrement,
    word text not null unique,
    matches integer default 0
);

-- Create table WordMatchesDanRev
create table if not exists WordMatchesDanRev (
    id integer not null primary key autoincrement,
    word text not null unique,
    matches integer default 0
);