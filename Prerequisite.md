# Prerequisite #

query-runner is a java/jsp/servlet based web application. It requires oracle database for storing connection and query information. query-runner application can be run on tomcat server.

# Details #

**Oracle Database**
Oracle Database is required to save  the different database connections information (like URL, username,password etc.) which are used to make connection to database where the query is run. Frequently used queries and user information (username, password) are also saved in database.

**Tomcat**
Tomcat is a servlet container required to run this web application. query-runner is a standard java web application which can be run any server capable of running java web applications.

**query-runner war file**
you will also need the setup sql scripts for initial database setup and query-runner war file which will need to be deployed on tomcat.

The detailed instruction for setup are present on Setup Instructions page.