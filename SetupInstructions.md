# Setup Instructions #

Below are the instructions for setting up and running query runner.

# Details #


  * Download Tomcat from below given link
> > http://tomcat.apache.org/download-70.cgi

  * Download the query-runner.zip file. The link to query-runner.zip file is present on the [Downloads](Downloads.md) page.

  * query-runner.zip file has setup.sql which can be run on any database to create all the required tables. Run this script on the database wherein you want to create the query-runner tables. The connection information to this database will need to be updated in the properties file in subsequent steps.

  * Create a folder name query-runner in C drive like ` c:\query-runner `

  * Unzip the Tomcat file in this query-runner folder like ` C:\query-runner\apache-tomcat-7.0.42 `

  * Extract the query-runner.zip file downloaded earlier, extract the query-runner.properties to folder ` c:\query-runner `. So the path to the properties file is exactly like: ` c:\query-runner\query-runner.properties `

  * Edit the query-runner.property file (` c:\query-runner\query-runner.properties ` )in as appropriate with the database connection information.
```
        DB_URL=edit_me
        DB_USERNAME=edit_me
        DB_PASSWORD=edit_me
```

  * Now copy the `query-runner.war` file in to the folder name `webapps` which is inside the tomcat folder ` C:\query-runner\apache-tomcat-7.0.42 `.

  * Start the tomcat by running the batch file ` c:\query-runner\apache-tomcat-7.0.42\bin\startup.bat `
> > The folder name of the tomcat can be different based on tomcat version number.

  * Open the browser and give this below given URL to run query-runner
> > http://localhost:8080/query-runner