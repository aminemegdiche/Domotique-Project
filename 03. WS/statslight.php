<?php
// array for JSON response
$response = array();

// include db connect class
require "db_connect.php";
// connecting to db
$db = new DB_CONNECT();




if(isset($_GET['id_lampe']))  
{
@$id_lampe=$_GET['id_lampe'];
}
else
{@$id_lampe=0;
}

  

   // print("SELECT * FROM users WHERE email_user = '".$mail."' AND mdp_user = ".$mdp);
	$result = mysql_query("SELECT * FROM `lampe` WHERE `id_lampe`=".$id_lampe)or die(mysql_error());
	
	

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;

		 $response["etat_lampe"] =$row["etat_lampe"];
		  $response["auto_lampe"] =$row["auto_lampe"];
		 	    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "etat lampe";
    echo json_encode($response);
		}
		
	else
	{
	     $response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "lampe incorrect";
    // echoing JSON response
    echo json_encode($response);
	}
	
 
 
 
?>
