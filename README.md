asr

.....
installare jfilehelpers in locale


mvn install:install-file -Dfile=/Users/fiorenzo/workspace-all/workspace/asr/lib/jfilehelpers-0.3-20140515.jar -DgroupId=org.coury.jfilehelpers -DartifactId=jfilehelpers -Dversion=0.3.0-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=/home/stefano/work/workspaces/intellij-six4/FlussoC/libs/jfilehelpers-0.3-20140515.jar -DgroupId=org.coury.jfilehelpers -DartifactId=jfilehelpers -Dversion=0.3.0-SNAPSHOT -Dpackaging=jar

mvn install:install-file -Dfile=/home/stefano/work/workspaces/asur/asr/docs/data/libs/commons-core-7.0.0-20141114.161228-1.jar -DgroupId=org.giavacms.commons -DartifactId=commons-core -Dversion=7.0.0-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=/home/stefano/work/workspaces/asur/asr/docs/data/libs/commons-gui-7.0.0-20141114.161250-1.jar -DgroupId=org.giavacms.commons -DartifactId=commons-gui -Dversion=7.0.0-SNAPSHOT -Dpackaging=jar



<groupId>org.primefaces</groupId>
    <artifactId>primefaces</artifactId>
    <packaging>jar</packaging>
    <version>5.1</version>
    
    
    mvn install:install-file -Dfile=primefaces-5.1.jar -DgroupId=org.primefaces -DartifactId=primefaces -Dversion=5.1 -Dpackaging=jar