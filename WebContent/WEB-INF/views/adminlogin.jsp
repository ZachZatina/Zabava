<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to make Quests</title>
</head>
<body>
	<script src="https://apis.google.com/js/platform.js?onload=init" async
		defer></script>
	<script>function init() {
	  gapi.load('auth2', function() {  });
	  }
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
      <%--   }; --%> 
  </script>
	<form action="creator" method="post">
	<input type="hidden" name="creatorstring" id="creatorstring" value="">
	<input type="submit" value="Proceed to Admin Page"> 
	</form>

</body>
</html>