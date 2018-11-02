<?php
session_start();

// initializing variables

$username = "";
$email    = "";
$errors = array(); 

// connect to the database
$db = mysqli_connect('softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com', 'yuyangchen0122', 'a123123q45', 'HealthMonitoring');

// REGISTER USER
if (isset($_POST['reg_user'])) {
  // receive all input values from the form
  $username = mysqli_real_escape_string($db, $_POST['username']);
  $email = mysqli_real_escape_string($db, $_POST['email']);
  $password_1 = mysqli_real_escape_string($db, $_POST['password_1']);
  $password_2 = mysqli_real_escape_string($db, $_POST['password_2']);
  $firstname = mysqli_real_escape_string($db, $_POST['firstname']);
  $lastname = mysqli_real_escape_string($db, $_POST['lastname']);
  $address = mysqli_real_escape_string($db, $_POST['address']);
  $city = mysqli_real_escape_string($db, $_POST['city']);
  $country = mysqli_real_escape_string($db, $_POST['country']);
  $postalcode = mysqli_real_escape_string($db, $_POST['postalcode']);
  $aboutme = mysqli_real_escape_string($db, $_POST['aboutme']);

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($username)) { array_push($errors, "Username is required"); }
  if (empty($email)) { array_push($errors, "Email is required"); }
  if (empty($password_1)) { array_push($errors, "Password is required"); }
  if ($password_1 != $password_2) {
   array_push($errors, "The two passwords do not match");
 }

  // first check the database to make sure 
  // a user does not already exist with the same username and/or email
 $user_check_query = "SELECT * FROM users WHERE username='$username' OR email='$email' LIMIT 1";
 $result = mysqli_query($db, $user_check_query);
 $user = mysqli_fetch_assoc($result);
 
  if ($user) { // if user exists
    if ($user['username'] === $username) {
      array_push($errors, "Username already exists");
    }

    if ($user['email'] === $email) {
      array_push($errors, "email already exists");
    }
  }

  // Finally, register user if there are no errors in the form
  if (count($errors) == 0) {
  	$password = md5($password_1);//encrypt the password before saving in the database

  	$query = "INSERT INTO users (username, email, password) 
   VALUES('$username', '$email', '$password')";
   mysqli_query($db, $query);
   $_SESSION['username'] = $username;
   $_SESSION['success'] = "You are now logged in";
   header('location: index.php');
 }
}
// LOGIN USER
if (isset($_POST['login_user'])) {
  $username = mysqli_real_escape_string($db, $_POST['username']);
  $password = mysqli_real_escape_string($db, $_POST['password']);

  if (empty($username)) {
    array_push($errors, "Username is required");
  }
  if (empty($password)) {
    array_push($errors, "Password is required");
  }

  if (count($errors) == 0) {
    $password = md5($password);
    $query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
    $results = mysqli_query($db, $query);
    if (mysqli_num_rows($results) == 1) {
      $_SESSION['username'] = $username;
      $_SESSION['success'] = "You are now logged in";
      header('location: index.php');
    }else {
      array_push($errors, "Wrong username/password combination");
    }
  }
}

if (isset($_POST['update_profile'])) {
  $temp=$_SESSION['username'];

  // receive all input values from the form
  $email = mysqli_real_escape_string($db, $_POST['email']);
  $firstname = mysqli_real_escape_string($db, $_POST['firstname']);
  $lastname = mysqli_real_escape_string($db, $_POST['lastname']);
  $address = mysqli_real_escape_string($db, $_POST['address']);
  $city = mysqli_real_escape_string($db, $_POST['city']);
  $country = mysqli_real_escape_string($db, $_POST['country']);
  $postalcode = mysqli_real_escape_string($db, $_POST['postalcode']);
  $aboutme = mysqli_real_escape_string($db, $_POST['aboutme']);
  $query = "UPDATE users SET email='$email',firstname='$firstname', lastname='$lastname', address='$address', city='$city', country='$country', postalcode='$postalcode', aboutme='$aboutme' WHERE username='$temp' "; 
  $_SESSION['aboutme'] = $aboutme; 
  mysqli_query($db, $query);
}

?>