<?php
require "mobile_connect.php";


$username = $_POST["username"];
$heartrate = $_POST["heartrate"];
$date = $_POST["date"];
$time =$_POST["time"];
$music = $_POST["music"];
$latitude= $_POST["latitude"];
$longitude=$_POST["longitude"];

$sql= " insert into HeartData (username,HeartRate, Date, Time , type,lat, lng) Values('".$username."','".$heartrate."','".$date."','".$time."','".$music."','".$latitude."','".$longitude."');";
$response = array();
$result= mysqli_query($con,$sql);
$code = " Registered Successfully";
array_push($response,array('code' =>$code));
echo json_encode($response);
mysqli_close($con);
?>