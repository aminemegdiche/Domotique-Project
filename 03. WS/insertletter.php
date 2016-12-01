<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";


// connecting to db
$db = new DB_CONNECT();

  @$id_maison=$_GET['id_maison'];
	
 
		
 
		$result = mysql_query(" INSERT INTO `domotique`.`letter` (`id_letter` ,`date_letter` ,`heure_letter` ,`status_letter` ,`id_maison`)VALUES (NULL , '".date("d-m-Y")."', '". date("H:i")."', '1', '".$id_maison."');; ") or die(mysql_error());
		
 
?>
