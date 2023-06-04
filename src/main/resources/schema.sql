-- Create virtual table Wog (Word of God)
create virtual table if not exists WoG using fts5(b,c,v,s);