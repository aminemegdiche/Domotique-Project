<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id_usr=$_GET['id_usr'];
  @$des_rm=$_GET['des_rm'];
   @$li_s=$_GET['li_s'];
    @$sh_s=$_GET['sh_s'];
	@$th_s=$_GET['th_s'];
	
 
		
 
		$result = mysql_query("insert into rooms (id_usr,des_rm,li_s,sh_s,th_s) values ($id_usr,'$des_rm',$sh_s,$li_s,$th_s) ") or die(mysql_error());
		if($result)
{
		 $response["success"] = 1;
		$response["message"] = "piece ajoutée";
       // echo no users JSON
        echo json_encode($response);
 }
 else
 {
  $response["success"] = 0;
		$response["message"] = "erreur lors l'ajout";
       // echo no users JSON
        echo json_encode($response);
 }
     
 
?>
