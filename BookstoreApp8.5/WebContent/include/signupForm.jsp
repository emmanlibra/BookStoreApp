<!-- Sign-up Form -->

<div id="id02" class="modal">
  <form class="modal-content animate" action="RegistrationServlet" method="post">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" required>      
      
      <label for="email"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block;  border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="contact"><b>Contact</b></label>
      <input type="text" placeholder="Enter Contact Number" name="contact" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block; border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" id="password" name="psw" onkeyup='check();' required>

      <label for="psw-repeat"><b>Repeat Password</b></label> <span id='message'></span>
      <input type="password" placeholder="Repeat Password" id="confirm_password" name="psw-repeat" onkeyup='check();' required>
      
      <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>

      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn2">Cancel</button>
        <button type="submit" class="signupbtn">Sign Up</button>
      </div>
    </div>
  </form>
</div>

<script>
var check = function() {
    if (document.getElementById('password').value ==
        document.getElementById('confirm_password').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'matching';
    } else {
    		document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'not matching';
    }
}
</script>