# dolapcodecase

**CREATE DATABASE, TABLES AND INITIAL DATA MIGRATION **

in mysql server create schema under root user with following:

 --> create schema dolapcodecase default charset utf8 collate utf8_general_ci;

in the project directory run the following command to create tables and migrate initial data:

 --> mvn liquibase:update


run the spring boot app and go to following address:

http://127.0.0.1:8080/swagger-ui.html 








**SIGN UP, SIGN IN AND AUTHENTICATE IN SWAGGER WITH TOKEN**

open autehntication-api-controller http://127.0.0.1:8080/swagger-ui.html#/authentication-controller and go to signup api end point

![Alt text](src/main/resources/appscreenshots/signup.png?raw=true "Sign Up")



if the response is as following then new user created

  "message": "User registered successfully!"

Now, let's sign in and get our token to authorize privilige to apis http://127.0.0.1:8080/swagger-ui.html#/authentication-controller/authenticateUserUsingPOST

After sending username and password appropriately, we'll get our token as following 
**COPY THE TOKEN**


![Alt text](src/main/resources/appscreenshots/get_jwt_token.png?raw=true "Sign In")

Go back  http://127.0.0.1:8080/swagger-ui.html and you will see "Authorize" button as in the screenshot
![Alt text](src/main/resources/appscreenshots/authorize_button.png?raw=true "Authorize Button")

Click Authorize ann type "Bearer Ctrl+V", i.e. After typing Bearer paste your token as following

![Alt text](src/main/resources/appscreenshots/authorize.png?raw=true "Authorize Button")




