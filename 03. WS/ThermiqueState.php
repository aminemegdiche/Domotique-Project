<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";

// connecting to db
$db = new DB_CONNECT();
if(isset($_GET['id_user'])and isset($_GET['id_maison']))  
{
 @$id_user=$_GET['id_user'];
  @$id_maison=$_GET['id_maison'];
    }
	else 
	{
	@$id_user=0;
	@$id_maison=0;
	}
	 $result1 = mysql_query("SELECT * FROM `rooms` WHERE `id_rm` in (SELECT `id_rm` FROM `droits_utu` WHERE `id_user`=".$id_user." and `id_maison`=".$id_maison.")") or die(mysql_error());
 
if (mysql_num_rows($result1) > 0)
 {
  $response["climatiseur"] = array();  
  while(  $row1 = mysql_fetch_array($result1) )
        {
 	@$id_rm=$row1["id_rm"];
			$result = mysql_query("SELECT * FROM `climatiseur` WHERE `id_rm`=".$id_rm) or die(mysql_error());
 if (mysql_num_rows($result) > 0)
 {
  
		 while(  $row = mysql_fetch_array($result) )
        {
		 $climatiseur = array();
        $climatiseur["id_climatiseur"] = $row["id_climatiseur"];
        $climatiseur["id_rm"] = $row1["id_rm"];
			$climatiseur["des_rm"] = $row1["des_rm"];
		 $climatiseur["temp_rm"] = $row1["temp_rm"];
		   $climatiseur["himu_rm"] = $row1["himu_rm"];
		$climatiseur["etat_clima"] = $row["etat_clima"];
		 $climatiseur["niveau_clima"] = $row["niveau_clima"];
		   $climatiseur["type_clima"] = $row["type_clima"];
		  $climatiseur["id_model"] = $row["id_model"];
		  array_push($response["climatiseur"], $climatiseur);
		
        // push single per into final response array
		 }
		        
		 }

	}
	    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "List";
    echo json_encode($response);
	}else
	{
	    
		 $response["success"] = 0;
	     $response["message"] = "pas de piéce ";
    // echoing JSON response
    echo json_encode($response);
	}
    
   
 
 
 
?>
