#!/bin/bash

#http://stackoverflow.com/questions/845863/how-to-use-in-an-xargs-command
#https://www.google.it/webhp?sourceid=chrome-instant&ion=1&espv=2&es_th=1&ie=UTF-8#safe=off&q=xargs+redirect+to+file

#USAGE:
#	mdb2sql.sh [OPTS]
#OPTIONS:
#   -h
#       Show help
#	-s
#		Skip all sql inserts in database
#	-i
#		Force all sql inserts in database


########################################## Constants ##########################################

normal="\033[0m"
bold="\033[1m"
underlined="\033[4m"
blink="\033[5m"
red="\033[31m"
green="\033[32m"
orange="\033[31;33m"

DBDIALECTS=("mysql" "postgres")
DBHOST_DEFAULT=localhost
DBNAME_DEFAULT=asr
DBUSER_DEFAULT=asr
DBPSW_DEFAULT=asr
MDB_FILE_DEFAULT=Spe_db.mdb
DEST_DIR=../sqlscripts
IFS=$'\n'
FORCE_SKIP_INSERT=0
FORCE_INSERT=0

###############################################################################################


########################################## Functions ##########################################

printHelp () {
    echo -e "${bold}USAGE:${normal}"
	echo -e "\t${bold}${0##*/} ${normal}[OPTS]"
	echo -e "${bold}OPTIONS:${normal}"
	echo -e "\t${bold}-h${normal}\n\t\tShow this help"
	echo -e "\t${bold}-s${normal}\n\t\tSkip all sql inserts in database"
	echo -e "\t${bold}-i${normal}\n\t\tForce all sql inserts in database"
}

chooseDialect () {
    echo "Choose a sql dialect:"
    select dialect in "${DBDIALECTS[@]}"; do
        case $dialect in
            mysql ) MYSQL=1 ; break ;;
            postgres ) POSTGRES=1 ; break ;;
            * ) echo "Invalid option. Try another one."; continue ;;
        esac
    done
}

chooseParams () {
    read -r -p "Database host [$DBHOST_DEFAULT]: " DBHOST
    DBHOST=${DBHOST:-$DBHOST_DEFAULT}

    read -r -p "Database username [$DBUSER_DEFAULT]: " DBUSER
    DBUSER=${DBUSER:-$DBUSER_DEFAULT}

    read -r -p "Database password [$DBPSW_DEFAULT]: " DBPSW
    DBPSW=${DBPSW:-$DBPSW_DEFAULT}

    read -r -p "Database name [$DBNAME_DEFAULT]: " DBNAME
    DBNAME=${DBNAME:-$DBNAME_DEFAULT}

    read -r -p "MDB file [$MDB_FILE_DEFAULT]: " MDB_FILE
    MDB_FILE=${MDB_FILE:-$MDB_FILE_DEFAULT}
}

confirm () {
    # call with a prompt string or use a default
    read -r -p "Do you want execute the sql script? [y/N] " response
    case $response in
        [yY][eE][sS]|[yY])
            true
            ;;
        *)
            false
            ;;
    esac
}

execInsert () {
    case "$1" in
        mysql )
            `mysql < ${DEST_DIR}/${tableNoWhiteSpaces}.sql -h ${DBHOST} --database ${DBNAME} -u${DBUSER} -p${DBPSW}` ;;
        postgres )
            `psql -h ${DBHPST} -U${DBUSER} -W${DBPSW} -d${DBNAME} -f ${DEST_DIR}/${tableNoWhiteSpaces}.sql` ;;
        * )
            echo -e "${red}Invalid sql dialect!!${normal}" ;;
    esac
}

###############################################################################################


### Read arguments ###
while [ "x$1" != "x" ]; do
    # help
	if [ "${1}" = "-h" ]; then
		printHelp
		exit
	fi

	# skip insert
	if [ "${1}" = "-s" ]; then
		FORCE_SKIP_INSERT=1
		shift
	fi

	# force insert
	if [ "${1}" = "-i" ]; then
		FORCE_INSERT=1
		shift
	fi
done

chooseDialect
chooseParams

### Schema ###
echo "###########################"
echo "## Generating schemas... ##"
echo "###########################"

for table in `mdb-tables -1 ${MDB_FILE}`;
do
    tableNoWhiteSpaces=$( echo $table | sed -e 's/[[:space:]]*//g' | sed 's/[-]*//g' )
    echo -e "Generating schema for ${bold}$tableNoWhiteSpaces${normal}"
    mdb-schema -T "$table" $MDB_FILE mysql | sed -e "s/$table/$tableNoWhiteSpaces/g" > "$DEST_DIR/$tableNoWhiteSpaces.sql";
done

### Insert ###
echo
echo "###########################"
echo "## Generating inserts... ##"
echo "###########################"

for table in `mdb-tables -1 ${MDB_FILE}`;
do
    tableNoWhiteSpaces=$( echo $table | sed -e 's/[[:space:]]*//g' | sed 's/[-]*//g' )
    echo -e "Generating inserts for ${bold}$tableNoWhiteSpaces${normal}"
    mdb-export -H -I mysql $MDB_FILE "$table" | sed -e "s/$table/$tableNoWhiteSpaces/g" >> "$DEST_DIR/$tableNoWhiteSpaces.sql";

    if [ $FORCE_SKIP_INSERT -ne 1 ] ; then
        if [ $FORCE_INSERT -eq 1 ] || confirm ; then
            execInsert "$dialect"
        fi
    fi
done

echo -e "${green}Done!!${normal}"



