package cptbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Client {

	private String firstname;
	private String lastname;
	private int id;
	private String sexe;
	private String date_n;
	private String date_i;
	private String mail;
	private String adresse;
	private int phone;
	


public static void newClient(String prenom,String nom,String id,String mail,String tel,String sexe,String date,String pays,String ville, String adresse) {
	
	    Connection Conn = null;
		Statement myStmt = null;
		ResultSet rs = null;
		
		
		if (prenom.length()<1) {JOptionPane.showMessageDialog(null,"prenom vide !");subscribe.prenom.requestFocusInWindow();}
		
		else if (nom.length()<1) {JOptionPane.showMessageDialog(null,"non vide !");}
		else if (id.length()!=8) {
			try { int i = Integer.parseInt(id); } catch(Exception r){JOptionPane.showMessageDialog(null,"ID invalide !");}
			} 
		else if ( mail.indexOf("@")< 0 && mail.lastIndexOf(".")<= mail.indexOf("@") && mail.lastIndexOf(".") == mail.length()) {JOptionPane.showMessageDialog(null,"mail invalide !");}
		else if (tel.length()!=8) {
			try { int t = Integer.parseInt(tel); } catch(Exception r){JOptionPane.showMessageDialog(null,"Tel° invalide !");}
			}
		else if (sexe=="Select") {JOptionPane.showMessageDialog(null,"sexe invalide");}
		//1993-05-JJ
		else if (date.indexOf("JJ") > -1 || date.indexOf("MM") > -1 || date.indexOf("YYYY") > -1 ) {JOptionPane.showMessageDialog(null,"date invalide !");}
		
		else if (pays.length()<1) {JOptionPane.showMessageDialog(null,"pays invalide !");}
		else if (ville.length()<1) {JOptionPane.showMessageDialog(null,"ville invalide !");}
		else if (adresse.length()<1) {JOptionPane.showMessageDialog(null,"adresse not valide !");}
		
		
		
		
		
		else {
		
		
	try {
			
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
			
			
	
			
			
		
			String query= "INSERT INTO client VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = Conn.prepareStatement(query);
			
			pst.setString(1,prenom);
			pst.setString(2,nom);
			pst.setString(3,id );
			pst.setString(4,mail);
			pst.setString(5,tel);
			pst.setString(6,sexe);
			                                                                                                                     
		     
			pst.setString(7,date);
			
			pst.setString(8,pays);
			pst.setString(9,ville);
			pst.setString(10,adresse);
			
			pst.execute();
      
      JOptionPane.showMessageDialog(null,"Client ajouté avec succés");

  
      
		
    		  
    		  
    		  
		}
		catch (Exception exc) {
			 JOptionPane.showMessageDialog(null,exc);
		}
		finally {
			try {
			if (rs != null) {
				
					rs.close();
				
			}
			
			if (myStmt != null) {
				
					myStmt.close();
				}
			
			
			if (Conn != null) {
			
					Conn.close();
					
			}
			}	
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		}
	
	
}



public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public String getDate_n() {
	return date_n;
}
public void setDate_n(String date_n) {
	this.date_n = date_n;
}
public String getDate_i() {
	return date_i;
}
public void setDate_i(String date_i) {
	this.date_i = date_i;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}


}