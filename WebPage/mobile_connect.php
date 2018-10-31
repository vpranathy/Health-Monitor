<?php

<<<<<<< HEAD
$host = 'softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com';
$db_user = 'yuyangchen0122';
$db_password='a123123q45';
$db_name = 'HealthMonitoring';


$con = mysqli_connect($host, $db_user, $db_password, $db_name);

if($con){
	echo "Success";
}
=======
$host = "softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com";
$db_user = "yuyangchen0122";
$db_password="a123123q45";
$db_name = "HealthMonitoring";

$con = mysqli_connect($host, $db_user, $db_password, $db_name);

>>>>>>> 67a6c03143aba4c7ef781a6c770e955efb0db838
?>