<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";

$id_climatiseur=0;
// connecting to db
$db = new DB_CONNECT();
if(isset($_GET['id_climatiseur'])and isset($_GET['niveau'])and isset($_GET['etat']) and isset($_GET['chaud_froid']))
{
  @$id_climatiseur=$_GET['id_climatiseur'];
    @$niveau=$_GET['niveau'];
	  @$chaud_froid=$_GET['chaud_froid'];
	    @$etat=$_GET['etat'];
			$result = mysql_query(" update `climatiseur` set `niveau_clima`=".$niveau." ,`etat_clima`=".$etat.",`mode_clima`=".$chaud_froid."  where `id_climatiseur`=".$id_climatiseur."; ") or die(mysql_error());
		print($result);
	}

		if($result)
{
		 $response["success"] = 1;
		 if($etat==1 )
			{
			$response["message"] = "climatiseur allume";
			$response["etat"] = 1;
			
			}
			else 
			{
			$response["message"] = "climatiseur eteint";
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
