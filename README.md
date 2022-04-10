<b><I>@Author - Rashmi Solanki</I></b>

About - This project is the implementation of a basic URL Shortener.
It will cover three following use-case. 

<b>Requirements</b> 
	
	1)Shorten a URL
		1.1) Input: A regular URL (not from applau.se domain).
		1.2) Output: A shortened URL (use only ten digits, 
		     26 lowercase characters, 26 uppercase characters) of extra 
		     length 2 from a given link (example: applau.se/5s).
		1.3) Handle the case that the 2-character length 
		     is running out of choices by retiring the shortened
		     URL that has not been called for the longest time.
	2) Retrieve a URL
		2.1) Input: A shortened URL (from applau.se domain).
		2.2) Output: Retrieve the original URL.
	3) Basic admin
		3.1) Show all stored shortened URLs (including shortened URL, original URL, 
			 call count and latest call time) and sort by call count.
			 
<b> System Requirements <b>

	1)JAVA - JDK
	2)IDE - Eclipes or IntelliJ 
	3)Maven 
	4)Postman
	5) Database used in this Project is H2

<b> Steps To execute code <b>

	1) Navigate to Package com.urlshortener > SpringBootApplication - Run the class on java Application 
	2) Then, Use following end point to access the short URL, original URL or all the data from database
		2.1) POST - http://localhost:8080/url/short?url=<OriginalURL>
		2.2) GET - http://localhost:8080/url/original?url=<shortURL>
		2.3) GET - http://localhost:8080/urls
	3) To access database - http://localhost:8080/h2-console (This will only execute after bootstraping the application).
	
	
		