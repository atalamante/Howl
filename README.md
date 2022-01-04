# Howl

## Overview
This app was designed to give UNM students an environment to connect with others whether it is academic or extracurricular. This platform intends to bring students together in a post-covid environment to those who have less access to the university as well as the opportunity to meet others. In our few years at UNM, our team has noticed that the amount of UNM students that we know is extremely small compared to the entire enrollment of UNM. It is not easy to find other UNM students on the large social media apps such as Instagram and Twitter. Our team believes that there is a better way for UNM students to meet other UNM students. This is how we came up with Howl. We believe that creating a social media app designed specifically for UNM will allow our fellow students a better opportunity of meeting people on campus whether that be from their major or a totally different major. 

The language used in this app is Java and was programmed in Android Studio. The app has three pages, a home that is dedicated to the feed, and to view the posting of other users. A compose, which will allow the user to create a post that will be sent to the homepage and the user’s profile page. The third page is a profile page, dedicated to the user, which has their information about their major, year, and will include their posts. 

The login screen requires a returning user to enter a username and password. If the current user is new to Howl, they will go through the sign up process. The sign up process requires a name, UNM email, password, UNM major, and UNM class. From the UNM email, the username is created. For example, the email “atalamante@unm.edu” will give the user a username of “atalamante”. The backend for this app is powered by Parse. Parse contains all the users and their information along with the posts. When the user logins, the data is checked with the Parse database to check the username and password. When the user signs up for the first time, the information is passed to Parse and stored. 

The Home page of Howl is the feed where all the posts are shown. A post will contain the respective user’s name, username, major, class, post text, and their profile picture. The posts are shown in order of recency. The newest post will be on top. The user is able to see all the posts that have been posted by scrolling.

The profile page shows the current user’s name, username, major, and year along with all their posts. At the top right of the page on the bar in red that says “Howl”, there is a menu icon that will show “Sign Out” when pressed. This is the way the user will be able to sign out of their account if they ever need to. This will take them back to the login/sign up screen.

## Team Members
Aaron Talamante is a Junior at UNM majoring in Computer Science. Aaron was the main programmer of the app along with contributions to brainstorming, design, and editing of the app.
Email: atalamante625@gmail.com  

Kellen Nee is a Junior at UNM majoring in Finance. Kellen helped with the brainstorming, design, and editing of the app.
Email: knee@unm.edu 
	
Riley Tarman is a Senior at UNM majoring in Civil Engineering. Riley helped design and review the layout of the app, as well as troubleshoot the app. 
Email: rtarman@unm.edu 

Pete Talamante is a Senior at UNM majoring in Finance. Pete helped with the development, and design processes of the app. 
Email: ptalamante@unm.edu 

## Parse
Parse is the backend for Howl. Parse holds all the information on the users and the posts. The website for Parse is: https://www.back4app.com/

Here is the data stored by Parse for Howl. 

### Users 
[Users.zip](https://github.com/atalamante/Howl/files/7805794/Users.zip)


### Posts
[Posts.zip](https://github.com/atalamante/Howl/files/7805796/Posts.zip)

## Test Accounts
For testing, we will list some accounts that can be used. 

username: atalamante, password: password

username: knee, password: password

username: rtarman, password: test1

## Future Aspirations
In the future, our team would like to add a few features to improve the app. The first feature would be email verification. Since this app will only be for UNM students, the email required will have to be an UNM email. However, this still requires verification. Adding a feature like this will ensure that all the students are in fact UNM students. 

Another feature would be adding the ability to like and leave comments on a post. This will add another level of interaction between students. This will take Howl up a level and become more like social media that everyone is accustomed to.

Another feature would be adding the ability for the user to choose their profile picture and have a bio.
