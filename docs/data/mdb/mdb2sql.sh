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
ACTIONS=("Generate SQL sripts form MDB file" "Import SQL scripts into the database")
DBHOST_DEFAULT=localhost
DBNAME_DEFAULT=asr
DBUSER_DEFAULT=asr
DBPSW_DEFAULT=asr
MDB_FILE_DEFAULT=Spe_db.mdb
DEST_DIR_DEFAULT=../db/additionaldata
IFS=$'\n'
FORCE_SKIP_INSERT=0
FORCE_INSERT=0

###############################################################################################


########################################## Functions ##########################################

chooseAction () {
    read -t 1 -n 10000 discard

    echo -e "Select option:"
    echo -e "1) Generate SQL sripts from MDB file"
    echo -e "2) Import SQL scripts into the database"
    echo -e -n "#? "
    while [ true ]; do
        read action
        case $action in
            1 ) break ;;
            2 ) break ;;
            * ) echo "Invalid option. Try another one."; continue ;;
        esac
    done
}

printHelp () {
    echo -e "${bold}USAGE:${normal}"
	echo -e "\t${bold}${0##*/} ${normal}[OPTS]"
	echo -e "${bold}OPTIONS:${normal}"
	echo -e "\t${bold}-h${normal}\n\t\tShow this help"
	echo -e "\t${bold}-s${normal}\n\t\tSkip all sql inserts in database"
	echo -e "\t${bold}-i${normal}\n\t\tForce all sql inserts in database"
}

chooseDialect () {
    read -t 1 -n 10000 discard

    echo "Choose a sql dialect:"
    select dialect in "${DBDIALECTS[@]}"; do
        case $dialect in
            mysql ) MYSQL=1 ; break ;;
            postgres ) POSTGRES=1 ; break ;;
            * ) echo "Invalid option. Try another one."; continue ;;
        esac
    done
}

chooseImportParams () {
    read -t 1 -n 10000 discard

    chooseDialect

    read -r -p "Database host [$DBHOST_DEFAULT]: " DBHOST
    DBHOST=${DBHOST:-$DBHOST_DEFAULT}

    read -r -p "Database username [$DBUSER_DEFAULT]: " DBUSER
    DBUSER=${DBUSER:-$DBUSER_DEFAULT}

    read -r -p "Database password [$DBPSW_DEFAULT]: " DBPSW
    DBPSW=${DBPSW:-$DBPSW_DEFAULT}

    read -r -p "Database name [$DBNAME_DEFAULT]: " DBNAME
    DBNAME=${DBNAME:-$DBNAME_DEFAULT}

    read -r -p "SQL scripts directory [$DEST_DIR_DEFAULT]: " DEST_DIR
    DEST_DIR=${DEST_DIR:-$DEST_DIR_DEFAULT}
}

chooseGenerateParams () {
    read -t 1 -n 10000 discard

    chooseDialect

    read -r -p "MDB file [$MDB_FILE_DEFAULT]: " MDB_FILE
    MDB_FILE=${MDB_FILE:-$MDB_FILE_DEFAULT}

    read -r -p "SQL scripts directory [$DEST_DIR_DEFAULT]: " DEST_DIR
    DEST_DIR=${DEST_DIR:-$DEST_DIR_DEFAULT}
}

# $1 : question text
# $2 : default answer
confirm () {
    if [ $# -lt 2 ]; then
        echo -e "${red}You have to pass question text and default answer${normal}"
    fi

    read -t 1 -n 10000 discard

    # call with a prompt string or use a default
    read -r -p "$1" response
    case $response in
        [yY][eE][sS]|[yY])
            true
            ;;
        [nN][oO])
            false
            ;;
        *)
            if [[ "$2" == "y" ]] ; then
                true
            else
                false
            fi
            ;;
    esac
}

# $1 : sql_dialect
# $2 : mdb file
# $3 : DEST_DIR
generateSchemas () {
    if [ $# -lt 3 ]; then
        echo -e "${red}You have to pass sql dialect, MDB file, and dir path args${normal}"
    fi

    for table in `mdb-tables -1 ${2}`;
    do
        tableNoWhiteSpaces=$( echo $table | sed -e 's/[[:space:]]/_/g' | sed 's/[-]/_/g' | sed 's/_\+/_/g' | tr '[[:upper:]]' '[[:lower:]]' )
        echo -e "Generating schema for ${bold}$tableNoWhiteSpaces${normal}"
        mdb-schema -T "$table" "$2" "$1" | sed -e "s/$table/$tableNoWhiteSpaces/g" > "$3/$tableNoWhiteSpaces.sql";
    done
}

# $1 : sql_dialect
# $2 : mdb file
# $3 : DEST_DIR
generateInserts () {
    if [ $# -lt 3 ]; then
        echo -e "${red}You have to pass sql dialect, MDB file, and dir path args${normal}"
    fi

    for table in `mdb-tables -1 ${2}`;
    do
        tableNoWhiteSpaces=$( echo $table | sed -e 's/[[:space:]]/_/g' | sed 's/[-]/_/g' | sed 's/_\+/_/g' | tr '[[:upper:]]' '[[:lower:]]' )
        echo -e "Generating inserts for ${bold}$tableNoWhiteSpaces${normal}"
        mdb-export -H -I "$1" -q \' "$2" "$table" | sed -e "s/$table/$tableNoWhiteSpaces/g" >> "$3/$tableNoWhiteSpaces.sql";
    done
}

# $1 : sql_dialect
# $2 : sql file
execInsert () {
    if [ $# -lt 2 ]; then
        echo -e "${red}You have to pass sql dialect and file args${normal}"
    fi

    case "$1" in
        mysql )
            echo -e "Executing SQL script ${2}"
            `mysql < ${2} -h ${DBHOST} --database ${DBNAME} -u${DBUSER} -p${DBPSW}` ;;
        postgres )
            echo -e "Executing SQL script ${2}"
            #`psql -h ${DBHOST} -U ${DBUSER} -d ${DBNAME} -f ${2}` ;;
#            `psql < ${2} -h ${DBHOST} -U ${DBUSER} -d ${DBNAME}` ;;
            `psql -h ${DBHOST} -U ${DBUSER} ${DBNAME} < ${2}` ;;
        * )
            echo -e "${red}Invalid SQL dialect!!${normal}" ;;
    esac
}

# $1 : sql_dialect
# $2 : DEST_DIR
# $3 : FORCE_SKIP_INSERT
# $4 : FORCE_INSERT
importScripts () {
    if [ $# -lt 2 ]; then
        echo -e "${red}You have to pass sql dialect and dir path args${normal}"
    fi

    FORCE_SKIP_INSERT=$3
    FORCE_INSERT=$4

    for file in "$2"/*; do
        if [ $FORCE_SKIP_INSERT -ne 1 ] ; then
            if [ $FORCE_INSERT -eq 1 ] || confirm "Do you want to import ${file}? [y/N] " "n"; then
                execInsert "$1" "$file"
            fi
        fi
    done
}

importScriptsWithQuestions () {
        read -t 1 -n 10000 discard

        if confirm "Do you want to import all generated SQL scripts? [y/N] " "n"; then
            FORCE_SKIP_INSERT=0
            FORCE_INSERT=1
        elif confirm "Do you want to skip import of all generated SQL scripts? [y/N] " "n"; then
            FORCE_SKIP_INSERT=1
            FORCE_INSERT=0
        else
            FORCE_SKIP_INSERT=0
            FORCE_INSERT=0
        fi
        importScripts "$dialect" "$DEST_DIR" $FORCE_SKIP_INSERT $FORCE_INSERT
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

chooseAction

case $action in
    1 )
        chooseGenerateParams

        ### Schema ###
        echo
        echo -e "${orange}Generating SQL schema scripts...${normal}"
        generateSchemas "$dialect" "$MDB_FILE" "$DEST_DIR"
        echo -e "${orange}SQL schema scripts generation done!${normal}"

        ### Insert ###
        echo
        echo -e "${orange}Generating SQL insert scripts...${normal}"
        generateInserts "$dialect" "$MDB_FILE" "$DEST_DIR"
        echo -e "${orange}SQL insert scripts generation done!${normal}"
        ;;

    2 )
        chooseImportParams
        echo
        importScriptsWithQuestions
        ;;

    * )
        echo -e "${red}Invalid action selected!!${normal}"
        ;;
esac

echo
echo -e "${green}Done!!${normal}"