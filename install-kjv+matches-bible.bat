@echo off
set CURDIR=%~dp0
set ESWORD_DB_DIR=%CURDIR%..\esword-db\
pushd .
if not exist %ESWORD_DB_DIR% (
  cd %curdir%..
  echo Downloading esword-db project...
  git clone https://github.com/rsanluis/esword-db.git
)
cd %ESWORD_DB_DIR%
git pull
echo Generating kjv+matches.bbli Bible Database file. Please wait...
call build.bat
popd
xcopy /Y %ESWORD_DB_DIR%kjv+matches.bbli %CURDIR%
