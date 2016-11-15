<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id_usr=$_GET['id_usr'];
  @$id_rm=$_GET['id_rm'];
    @$sh_v=$_GET['sh_v'];
	
 
		
 
		$result = mysql_query(" update rooms set sh_v=$sh_v where id_rm=$id_rm and id_usr=$id_usr ; ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		 if($sh_v==1)
			{
			$response["message"] = "volet ouvert";
			$response["sh_v"] = 1;
			
			}
			else 
			{
			$response["message"] = "volet fermé";
			$response["sh_v"] = 0;
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
