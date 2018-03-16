<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="740412392638-gqhd6ch0lrtml78nvtdoa0h7318nvcts.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<title>Login to make Quests</title>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="./">ZabavaQuest</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<center>
		<script src="https://apis.google.com/js/platform.js?onload=init" async
			defer></script>
		<script>function init() {
	  gapi.load('auth2', function() {  });
	  document.getElementById('button').style.visibility='hidden';
	  }
	  </script>

		<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
		<script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());
        var email = credential.id;
        document.getElementById("creatorstring").value = profile.getEmail();
        document.getElementById('button').style.visibility='visible';

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      };
    </script>

		<script src="https://smartlock.google.com/client"></script>
		<script>	
    window.onGoogleYoloLoad = (googleyolo) => {
      googleyolo.hint({
        supportedAuthMethods: [
          "https://accounts.google.com"
        ],
        supportedIdTokenProviders: [{
          uri: "https://accounts.google.com",
          clientId: "740412392638-gqhd6ch0lrtml78nvtdoa0h7318nvcts.apps.googleusercontent.com"
        }],
        context: "signUp"
      }).then((credential) => {
        console.log(credential.id);
        console.log(credential);
        var email = credential.id;
        document.getElementById("creatorstring").value = email;
        document.getElementById('button').style.visibility='visible';
        
        
        console.log(typeof credential);
        
        gapi.load('auth2', function() {
            window.gapiAuth2 = gapi.auth2.init({
                client_id: 740412392638-gqhd6ch0lrtml78nvtdoa0h7318nvcts.apps.googleusercontent.com,
                scope: 'email',
                cookiepolicy: 'single_host_origin',
                fetch_basic_profile: false
            });
        });
        

        });
        
      }, (error) => {
        console.log(error.type);
      };
       
  </script>

		<br> <br>




		<form action="creator" method="post" id="button">
			<input type="hidden" name="creatorstring" id="creatorstring" value="">
			<input type="submit" value="Proceed to Creator Page" class="btn btn-primary">
		</form>
	</center>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>