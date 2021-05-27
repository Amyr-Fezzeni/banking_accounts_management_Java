package cptbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;



import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class ajoutemploye {

	public static JFrame frmGestionDemployes;
	public static JTextField prenom;
	public static JTextField nom;
	public static JTextField id;
	public static JTextField mail;
	public static JTextField tel;
	public static JTextField adresse;
	public static JTextField ville;
	public static JTextField pays;
	private JTextField agence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutemploye employ = new ajoutemploye();
					employ.frmGestionDemployes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ajoutemploye() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDemployes = new JFrame();
		frmGestionDemployes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestionDemployes.setTitle("Gestion d'employes");
		frmGestionDemployes.setBounds(100, 100, 383, 557);
		frmGestionDemployes.getContentPane().setLayout(null);
		frmGestionDemployes.setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//subscribe.this.setVisible(false);
				frmGestionDemployes.setVisible(false);
			}
		});
		btnNewButton.setBounds(265, 475, 89, 23);
		frmGestionDemployes.getContentPane().add(btnNewButton);
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 64, 344, 341);
		frmGestionDemployes.getContentPane().add(panel);
		panel.setLayout(null);
		
		prenom = new JTextField();
		prenom.setBounds(104, 11, 205, 20);
		panel.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Prenom :");
		lblNewLabel.setBounds(10, 14, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Nom :");
		lblLastName.setBounds(10, 45, 84, 14);
		panel.add(lblLastName);
		
		nom = new JTextField();
		nom.setBounds(104, 42, 205, 20);
		panel.add(nom);
		nom.setColumns(10);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(10, 73, 84, 14);
		panel.add(lblId);
		
		id = new JTextField();
		id.setBounds(104, 70, 205, 20);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(10, 101, 84, 14);
		panel.add(lblMail);
		
		mail = new JTextField();
		mail.setBounds(104, 98, 205, 20);
		panel.add(mail);
		mail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Tel :");
		lblPhone.setBounds(10, 129, 84, 14);
		panel.add(lblPhone);
		
		tel = new JTextField();
		tel.setBounds(104, 126, 205, 20);
		panel.add(tel);
		tel.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexe :");
		lblNewLabel_5.setBounds(10, 157, 84, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Adresse :");
		lblNewLabel_6.setBounds(10, 270, 84, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date de N\u00B0 :");
		lblNewLabel_7.setBounds(10, 186, 84, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ville :");
		lblNewLabel_8.setBounds(10, 242, 84, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pays :");
		lblNewLabel_9.setBounds(10, 215, 84, 14);
		panel.add(lblNewLabel_9);
		
		adresse = new JTextField();
		adresse.setBounds(104, 267, 205, 20);
		panel.add(adresse);
		adresse.setColumns(10);
		
		ville = new JTextField();
		ville.setBounds(104, 239, 205, 20);
		panel.add(ville);
		ville.setColumns(10);
		
		pays = new JTextField();
		pays.setBounds(104, 212, 205, 20);
		panel.add(pays);
		pays.setColumns(10);
		
		 JComboBox sexe = new JComboBox();
		sexe.setBounds(104, 153, 105, 22);
		panel.add(sexe);
		sexe.setModel(new DefaultComboBoxModel(new String[] {"_____", "homme", "femme"}));
		sexe.setSelectedIndex(0);
		sexe.setToolTipText("");
		
		JComboBox day = new JComboBox();
		day.setBounds(104, 182, 50, 22);
		panel.add(day);
		day.setToolTipText("");
		day.setModel(new DefaultComboBoxModel(new String[] {"JJ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day.setSelectedIndex(0);
		
		JComboBox month = new JComboBox();
		month.setBounds(170, 182, 50, 22);
		panel.add(month);
		month.setToolTipText("");
		month.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		month.setSelectedIndex(0);
		
		JComboBox yearr = new JComboBox();
		yearr.setBounds(239, 182, 70, 22);
		panel.add(yearr);
		yearr.setToolTipText("");
		yearr.setModel(new DefaultComboBoxModel(new String[] {"YYYY", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		yearr.setSelectedIndex(0);
		
		agence = new JTextField();
		agence.setColumns(10);
		agence.setBounds(104, 295, 205, 20);
		panel.add(agence);
		
		JLabel lblNewLabel_6_1 = new JLabel("agence :");
		lblNewLabel_6_1.setBounds(10, 298, 84, 14);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("Inscription");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(107, 0, 258, 75);
		frmGestionDemployes.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection Conn=null;
			
				
		
				try {
					
					Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
					
					
			
					
					
				
					String query= "INSERT INTO employes(prenom,nom,id,mail,tel,sexe,date_n,pays,ville,adresse,agence) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst = Conn.prepareStatement(query);
					
					pst.setString(1,prenom.getText());
					pst.setString(2,nom.getText());
					pst.setString(3,id.getText() );
					pst.setString(4,mail.getText());
					pst.setString(5,tel.getText());
					pst.setString(6,sexe.getSelectedItem().toString());
					                                                                                                                     
					String dat = yearr.getSelectedItem().toString()+"-"+month.getSelectedItem().toString()+"-"+day.getSelectedItem().toString();			   		  
					pst.setString(7,dat);
					
					pst.setString(8,pays.getText());
					pst.setString(9,ville.getText());
					pst.setString(10,adresse.getText());
					pst.setString(11,agence.getText());
					
					pst.execute();
		      
		      JOptionPane.showMessageDialog(null,"Employe ajouté avec succés");

		  
		      
				
		    		  
		    		  
		    		  
				}
				catch (Exception exc) {
					 JOptionPane.showMessageDialog(null,exc);
				}
				finally {
					try {
				
					
					
					if (Conn != null) {
					
							Conn.close();
							
					}
					}	
						 catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
			
				}
			
			
	
			
			
			
		
				
			}
				);
				
					
			
		
		btnNewButton_1.setBounds(125, 428, 130, 23);
		frmGestionDemployes.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Annuler");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			      prenom.setText("");
			      nom.setText("");
			      id.setText("");
			      mail.setText("");
			      tel.setText("");
			      pays.setText("");
			      ville.setText("");
			      adresse.setText("");
			      sexe.setSelectedIndex(0);
			      day.setSelectedIndex(0);
			      month.setSelectedIndex(0);
			      yearr.setSelectedIndex(0);
			      agence.setText("");
				
			}
		});
		btnNewButton_3.setBounds(265, 428, 89, 23);
		frmGestionDemployes.getContentPane().add(btnNewButton_3);
	}

	public void setVisible(boolean b) {
		subscribe window = new subscribe();
		window.frame.setVisible(b);
		
	}
}
