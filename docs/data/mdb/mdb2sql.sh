#!/bin/bash
#http://stackoverflow.com/questions/845863/how-to-use-in-an-xargs-command
#https://www.google.it/webhp?sourceid=chrome-instant&ion=1&espv=2&es_th=1&ie=UTF-8#safe=off&q=xargs+redirect+to+file

normal="\033[0m"
bold="\033[1m"
underlined="\033[4m"
blink="\033[5m"
red="\033[31m"
green="\033[32m"
orange="\033[31;33m"

IFS=$'\n'

### Schema ###
echo "Generating schemas..."
for table in `mdb-tables -1 Spe_db.mdb`;
do
    mdb-schema -T "$table" Spe_db.mdb mysql > "../sqlscripts/$table.sql";
done

### Insert ###
echo "Generating inserts..."
for table in `mdb-tables -1 Spe_db.mdb`;
do
    mdb-export -H -I mysql Spe_db.mdb "$table" >> "../sqlscripts/$table.sql";
done

echo -e "${green}Done!!${normal}"
