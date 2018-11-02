<?php
require("phpsqlajax_dbinfo.php");
function parseToXML($htmlStr) 
{ 
$xmlStr=str_replace('<','&lt;',$htmlStr); 
$xmlStr=str_replace('>','&gt;',$xmlStr); 
$xmlStr=str_replace('"','&quot;',$xmlStr); 
$xmlStr=str_replace("'",'&apos;',$xmlStr); 
$xmlStr=str_replace("&",'&amp;',$xmlStr); 
return $xmlStr; 
} 

// Opens a connection to a mySQL server
$connection=mysqli_connect ("softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com
", $username, $password);
if (!$connection) {
  die('Not connected : ' . mysqli_error());
}
//$database="phpsqlsearch_data";
// Set the active mySQL database
$db = mysqli_connect('fall2018softenggroup2health.cmbbmvtvxryw.us-east-1.rds.amazonaws.com', 'yuyangchen0122', 'a123123q45', 'HealthMonitoring');
                                    // sending query
$query=("SELECT * FROM markers WHERE id = 1");
$result = mysqli_query($db,$query);
if (!$result) {
  die("Query to show fields from table failed");
}

header("Content-type: text/xml");

// Start XML file, echo parent node
echo '<markers>';

// Iterate through the rows, printing XML nodes for each
while ($row = @mysqli_fetch_assoc($result)){
  // ADD TO XML DOCUMENT NODE
  echo '<marker ';
  echo 'name="' . parseToXML($row['name']) . '" ';
  echo 'address="' . parseToXML($row['address']) . '" ';
  echo 'lat="' . $row['lat'] . '" ';
  echo 'lng="' . $row['lng'] . '" ';
  echo 'type="' . $row['type'] . '" ';
  echo '/>';
}

// End XML file
echo '</markers>';

?>