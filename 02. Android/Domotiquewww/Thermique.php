<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id_usr=$_GET['id_usr'];
  @$id_rm=$_GET['id_rm'];
    @$th=$_GET['th'];
	 @$th_m=$_GET['th_m'];
	
 
		
 
		$result = mysql_query(" update rooms set th_m=$th_m,th=$th where id_rm=$id_rm and id_usr=$id_usr ; ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		 if($th==0)
			{
			$response["message"] = "Clim off ";
			$response["th"] = 0;
			}
			
			 if($th==1 && $th_m==0)
			{
			$response["message"] = "Clim mode Froid";
			$response["th"] = 1;
			$response["th_m"] = 0;
			}
			 if($th==1 && $th_m==1)
			{
			$response["message"] = "Clim mode Chaud";
			$response["th"] = 1;
			$response["th_m"] = 1;
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
