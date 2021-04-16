# dbpass - is a password store tool
It is a open source tool for storing password basically using local data base. 
In the below section I described some things why it was created. And main
things is a why?/how to configure it?/how to lunch it?. 
So, welcome.
## Why ? 
If you don't trust any software implementation, you can use it, change 
for yourself.
## How it configure ?
The main configuration file for the program is a special properties, which
you should define according to your data base, user, password and etc.
In this properties file we have 7 items.
#### Related to data base parameters: 
 - **db_name** - it's your data base name;
 - **db_user** - it's your user name;
 - **db_pass** - it's your user password;
 - **db_port** - it's your port for connection to db;
 - **db_host** - it's your host for connection to db;
#### Related to implementation:
 So, for storing password I used AES-256 cipher algorithm. And, how parameters
 for it algorithm, we should define next items:
 
 - **db_pass_key** - is a your key for AES cipher;
 - **db_pass_salt** - is random data that is used as an additional input to a 
 one-way function that hashes data.
#
Example **dbProperties.properties** file:
 ``` properties
 db_name = your_data_base_name
db_user = your_data_base_user_name
db_pass = your_data_base_user_password
db_port = your_data_base_port
db_host = your_data_base_host
db_pass_key = your_key_for_encrypting_decrypting
db_pass_salt = your_salt_for_AES
 ```
 ## How to lunch it ?
 After, when you built jar file with program, you can run it by execute next command:
```console
user@example:~$ java -jar DBPass.jar full_path_to_your_dbProperties.properties 
```
And try it. And enjoy it.



 
