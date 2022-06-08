package Controleur;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Controleur.User;
import Modele.modele;
import Vue.VueConnexion;
import Vue.VueGenerale;

public class Mairie_Ermont {
	//add
	private static VueConnexion uneConnexion ;
	private static VueGenerale uneVueGenerale;
	public static void main(String[] args) {
		uneConnexion = new VueConnexion();

	}

	/*****************Gestion des users ********************/
	public static User selectWhereUser(String email, String mdp) 
	{
		User unUser = modele.selectWhereUser(email, mdp);
		return unUser;
	}
	//code pour hachage mot de passe
	 public static byte[] getSHA(String mdp) 
	    { 
		 byte[] tab = null;
		 try {
	        // Static getInstance method is called with hashing SHA 
	        MessageDigest md = MessageDigest.getInstance("SHA1"); 
	        tab = md.digest(mdp.getBytes(StandardCharsets.UTF_8));
	        // digest() method called 
	        // to calculate message digest of an input 
	        // and return array of byte
		 	}
		 catch (NoSuchAlgorithmException exp) {
			 exp.printStackTrace();
		 	}
	        return  tab;
	    }
	 
	 public static String toHexString(byte[] tab)
	    {
	        // Convert byte array into signum representation 
	        BigInteger number = new BigInteger(1, tab); 
	  
	        // Convert message digest into hex value 
	        StringBuilder hexString = new StringBuilder(number.toString(16)); 
	  
	        // Pad with leading zeros
	        while (hexString.length() < 32) 
	        { 
	            hexString.insert(0, '0'); 
	        } 
	  
	        return hexString.toString(); 
	    }

	//modification apporte le 22 /04 - Hashage MDP 
	public static String crypterMdp(String mdp)
	{
		//hashage en sha1 
		return toHexString(getSHA(mdp)); 
	}

	public static void instancierVueGenerale(User unUser) {
		uneVueGenerale = new VueGenerale(unUser);
		
	}

	public static void rendreVisibleVueConnexion(boolean action) {
		uneConnexion.setVisible(action);
		
	}

	public static void fermerVueGenerale() 
	{
		uneVueGenerale.dispose();
		
	}

	

}
