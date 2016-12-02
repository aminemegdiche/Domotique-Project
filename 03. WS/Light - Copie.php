<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";


// connecting to db
$db = new DB_CONNECT();

  @$id_lampe=$_GET['id_lampe'];
    @$etat=$_GET['etat'];
	
 
		
 
		$result = mysql_query(" update `lampe` set `etat_lampe`=$etat where `id_lampe`=$id_lampe; ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		 if($etat==1)
			{
			$response["message"] = "Lampe allume";
			$response["etat"] = 1;
			
			}
			else 
			{
			$response["message"] = "lampe eteint";
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
