<?php
// array for JSON response
$response = array();

// include db connect class
require "db_connect.php";
// connecting to db
$db = new DB_CONNECT();




if(isset($_GET['id_climatiseur']))  
{
@$id_climatiseur=$_GET['id_climatiseur'];
}
else
{@$id_climatiseur=0;
}

  

   // print("SELECT * FROM users WHERE email_user = '".$mail."' AND mdp_user = ".$mdp);
	$result = mysql_query("SELECT * FROM `climatiseur` WHERE `id_climatiseur`=".$id_climatiseur)or die(mysql_error());
		
	
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;

		 $response["id_climatiseur"] =$row["id_climatiseur"];
		 	 $response["id_rm"] =$row["id_rm"];
			 	 $response["etat_clima"] =$row["etat_clima"];
				 	 $response["niveau_clima"] =$row["niveau_clima"];
					 	 $response["type_clima"] =$row["type_clima"];
						 	 $response["id_model"] =$row["id_model"];
							 $result1 = mysql_query(" SELECT * FROM `rooms` WHERE `id_rm`=".$id_climatiseur)or die(mysql_error());
							 $row1 = mysql_fetch_array($result1) ;
							 $response["temp_rm"] =$row1["temp_rm"];
							 	 $response["himu_rm"] =$row1["himu_rm"];
							 
		 	    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "etat climatiseur";
    echo json_encode($response);
		}
		
	else
	{
	     $response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "climatiseur incorrect";
    // echoing JSON response
    echo json_encode($response);
	}
	
 
 
 
?>
