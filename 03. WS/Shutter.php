<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";


// connecting to db
$db = new DB_CONNECT();

  @$id_shutter=$_GET['id_shutter'];
    @$etat=$_GET['etat'];
	
 
		
 
		$result = mysql_query(" update `shutter` set `etat`=$etat where `id_shutter`=$id_shutter; ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		 if($etat==1)
			{
			$response["message"] = "volet ouvert";
			$response["etat"] = 1;
			
			}
			else 
			{
			$response["message"] = "volet fermé";
			$response["etat"] = 0;
			}
       // echo no users JSON
        echo json_encode($response);
 }
 else
 {
  $response["success"] = 0;
		$response["message"] = "erreur lors de la modification";
       // echo no users JSON
        echo json_encode($response);
 }
     
 
?>
