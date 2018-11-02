<?php

require "mobile_connect.php";

$password =$_POST["password"];
$user_name = $_POST["user_name"];
$encryptedPassword = md5($password);

$sql = " select firstname, email from users where username like '".$user_name."'and password like '".$encryptedPassword."';";

$result = mysqli_query($con,$sql);
$response = array();
if (mysqli_num_rows($result)>0) {
	$row = mysqli_fetch_row($result);
	$firstname = $row[0];
	$email= $row[1];
	$code=" login success";
	array_push($response,array("code"=>$code, "name"=>$name, "email"=>$email));
	echo json_encode($response);
}
else
{
		$code=" login failed";
		$message = ' User not found. Try again';
		array_push($response,array("code"=>$code, "message"=>$message));
		echo json_encode($response);

}

mysqli_close($con);

?>