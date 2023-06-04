drop table if exists WoG;
create virtual table if not exists WoG using fts5(b,c,v,s);