<?php
require "mobile_connect.php"

$name = $_POST["name"];
$email = $_POST["email"]
$user_name = $_POST["user_name"]
$password =$_POST["password"]


$sql =" Select * from users where email like '".$email."';";
$result= mysqli_query($con,$sql);
$response = array();
 (mysqli_num_rows($result)>0) {
	$code = " Registration failed"
	$message = " User already exists...."
	array_push($response,array('code' =>$code,'message'=>$message));
	echo json_encode($response);
}
else{
	$sql = " insert into users ( username, password,email, firstname) Values('".$user_name."','".$password."','".$email."','".$name."');";
	$result= mysqli_query($con,$sql);
	$code = " Registered Successfully"
	$message = " Thank you for registering with us. Now you can log in. "
	array_push($response,array('code' =>$code,'message'=>$message));
	echo json_encode($response);
}

mysqli_close($con)

?>
