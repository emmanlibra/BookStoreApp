<div id="addbtn" class="modal">
  <form class="modal-content animate" action="RegistrationServlet" >
    <div class="container">
      <h1>Add an Account</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" required>      
      
      <label for="email"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block;  border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="contact"><b>Contact</b></label>
      <input type="text" placeholder="Enter Contact Number" name="contact" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block; border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="psw"><b>Password</b></label>
      <input type="text" placeholder="Enter Password" id="password" name="psw" required>
      
      <label for="usertype"><b>User Type</b></label> 
      <select id="soflow" name="usertype" >
		  <option value="admin_user">Admin User</option>
		  <option value="customer_user">Customer User</option>
	  </select>


      <div class="clearfix">
        <button type="button" onclick="document.getElementById('addbtn').style.display='none'" class="cancelbtn2">Cancel</button>
        <button type="submit" class="signupbtn">Add</button>
      </div>
    </div>
  </form>
</div>