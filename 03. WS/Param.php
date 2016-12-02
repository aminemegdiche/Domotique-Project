<?php
// array for JSON response
$response = array();

// include db connect class
require "db_connect.php";
// connecting to db
$db = new DB_CONNECT();




if(isset($_GET['mail'])and isset($_GET['mdp']))  
{
@$mail=$_GET['mail'];
 @$mdp=$_GET['mdp'];
}
else
{@$mail="aaaa";
@$mdp=00000;
}

  

   // print("SELECT * FROM users WHERE email_user = '".$mail."' AND mdp_user = ".$mdp);
	$result = mysql_query("SELECT * FROM users WHERE email_user = '".$mail."' AND mdp_user = ".$mdp)or die(mysql_error());
	
	

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;
if($row["etat_user"]==1)
{
		 $response["id"] =$row["id_usr"];
		 $response["success"] = 1;
	     $response["nom_user"] = $row["nom_user"];
		 $response["prenom_user"] = $row["prenom_user"];
		 $response["tel_user"] = $row["tel_user"];
		$response["date_naissance_user"] = $row["date_naissance_user"];
		$response["pic_user"] = $row["pic_user"];
		$response["etat_user"] = $row["etat_user"];
		 // echoing JSON response
    echo json_encode($response);
		}
		else 
		{
		$response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "pin incorrecte";
    // echoing JSON response
    echo json_encode($response);
		
		}
		
   
	}
	else
	{
	     $response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "pin incorrecte";
    // echoing JSON response
    echo json_encode($response);
	}
	
 
 
 
?>
