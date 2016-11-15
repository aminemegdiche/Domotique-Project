<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id_usr=$_GET['id_usr'];
  @$id_rm=$_GET['id_rm'];
    @$li_v=$_GET['li_v'];
	
 
		
 
		$result = mysql_query(" update rooms set li_v=$li_v where id_rm=$id_rm and id_usr=$id_usr ; ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		 if($li_v==1)
			{
			$response["message"] = "Eclairage max ";
			$response["li_v"] = 1;
			}
			
			 if($li_v==2)
			{
			$response["message"] = "Eclairage moy";
			$response["li_v"] = 2;
			}
			 if($li_v==3)
			{
			$response["message"] = "Eclairage faible";
			$response["li_v"] = 3;
			}
			 if($li_v==0)
			{
			$response["message"] = "Eclairage eteint";
			$response["li_v"] = 0;
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
