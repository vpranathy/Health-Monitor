<?php
require "mobile_connect.php";


$username = $_POST["username"];
$heartrate = $_POST["heartrate"];
$date = $_POST["date"];
$time =$_POST["time"];
$music = $_POST["music"]

$response = array();
$sql= " insert into HeartData (username,HeartRate, Date, Time , Music) Values('".$username."','".$heartrate."','".$date."','".$time."','".$music."');";
$result= mysqli_query($con,$sql);
$code = " Registered Successfully";
array_push($response,array('code' =>$code));
echo json_encode($response);
mysqli_close($con);

?>