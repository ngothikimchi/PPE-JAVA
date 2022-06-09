package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Tableau;
import Controleur.TypeEveAdulte;
import Controleur.TypeEveEnfant;
import Modele.modele;

public class PanelTypeEve extends PanelDeBase implements ActionListener
{
		
	private JPanel panelForm = new JPanel();
	private JPanel panelForm1 = new JPanel();
	private JPanel panelForm2 = new JPanel();
	
	private JPanel panelTable1 = new JPanel();
	private JPanel panelTable2 = new JPanel();
	
	private JButton btEnregistrer= new JButton("Enregistrer");
	private JButton btAnnuler= new JButton("Annuler");
	
	private JTextField txtCodeType= new JTextField();
	private JTextField txtNomtype= new JTextField();
	
	//enfant
	private JTextField txtAgeMin= new JTextField();
	private JTextField txtAgeMax= new JTextField();
	private JComboBox<String> cbAccompagnant= new JComboBox<String>();
	
	
	private JRadioButton  radioTypeEveEnfant = new JRadioButton(); 
	private JRadioButton  radioTypeEveAdult= new JRadioButton(); 
	
	private JTable uneTableE = null; 
	private static Tableau unTableauE = null ; 
	
	private JTable uneTableA = null; 
	private static Tableau unTableauA  = null ; 
	
	//zone de recherche - enfant 
	private JTextField txtMotE = new JTextField();
	private JButton btRechercherE = new JButton("Rechercher"); 
	
	//zone de recherche - adult
		private JTextField txtMotA = new JTextField();
		private JButton btRechercherA = new JButton("Rechercher"); 
	
	
	
	public PanelTypeEve ()
	{
		super(new Color(163, 222, 142));
		
		this.panelForm.setLayout(new GridLayout(2,2));
		this.panelForm.add(new JLabel("Code type  :")); 
		this.panelForm.add(this.txtCodeType); 
		
		this.panelForm.add(new JLabel("Nom  :")); 
		this.panelForm.add(this.txtNomtype); 
		
		
		this.panelForm1.setLayout(new GridLayout(3,2));
		this.panelForm1.add(new JLabel("Age min  :")); 
		this.panelForm1.add(this.txtAgeMin); 
		
		this.panelForm1.add(new JLabel("Age max  :")); 
		this.panelForm1.add(this.txtAgeMax); 
		
		this.panelForm1.add(new JLabel("Accompagnant  :")); 
		this.panelForm1.add(this.cbAccompagnant);
		
		this.panelForm2.setLayout(new GridLayout(1,2));
		this.panelForm2.add(this.btAnnuler); 
		this.panelForm2.add(this.btEnregistrer);
		
		this.panelForm.setBounds(20, 20, 300, 60);
		this.panelForm1.setBounds(20, 140, 300, 80);
		this.panelForm2.setBounds(20, 250, 300, 30);
		
				
		this.add(this.panelForm);
		this.add(this.panelForm1);
		this.panelForm1.setVisible(false);
		this.add(this.panelForm2);
		
		JLabel lbTypeEnfant = new JLabel("Type Enfant");
		lbTypeEnfant.setBounds(90, 100, 80, 20);
		this.add(lbTypeEnfant);
		this.radioTypeEveEnfant.setBounds(40,100 ,20, 20);
		this.add(this.radioTypeEveEnfant);
		
		
		JLabel lbTypeAdult = new JLabel("Type Adult");
		lbTypeAdult.setBounds(230, 100, 80, 20);
		this.add(lbTypeAdult);
		this.radioTypeEveAdult.setBounds(190,100 ,20, 20);
		this.add(this.radioTypeEveAdult);
		
		ButtonGroup editableGroup = new ButtonGroup();
	    editableGroup.add(radioTypeEveEnfant);
	    editableGroup.add(radioTypeEveAdult);
	    
	    //add jradio button ecoutable
	    this.radioTypeEveEnfant.addActionListener(this);
		this.radioTypeEveAdult.addActionListener(this);
  
		 
		//combobox accompagant
		this.cbAccompagnant.addItem("oui");
		this.cbAccompagnant.addItem("non");
		this.cbAccompagnant.addItem("");
		
		    //add button ecoutable
	    this.btEnregistrer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btRechercherE.addActionListener(this);
		this.btRechercherA.addActionListener(this);
		
		//construction  du panel Table typeEveEnfant
		this.panelTable1.setBounds(400, 60, 450, 200);
		//this.panelTable1.setBackground(Color.gray);
		this.panelTable1.setLayout(null);
		String entetes[] = {"Code type","Nom","AgeMin","AgeMax","Accompagnant"};
		Object donnees [][] = this.getLesDonnees (""); 
		unTableauE = new Tableau (entetes, donnees);//appel du constructeur tableau 					
		this.uneTableE = new JTable(unTableauE); 
		JScrollPane uneScroll = new JScrollPane(this.uneTableE); 
		uneScroll.setBounds(0, 60, 450, 200);
		this.panelTable1.add(uneScroll); 
		
		
		//construction  du panel Table typeEveAdult
		this.panelTable2.setBounds(400, 60, 380, 200);
		//this.panelTable2.setBackground(Color.gray);
		this.panelTable2.setLayout(null);
		String entetesA[] = {"Code type","Nom"};
		Object donneesA [][] = this.getLesDonnees1 (""); 
		unTableauA = new Tableau (entetesA, donneesA);//appel du constructeur tableau 					
		this.uneTableA = new JTable(unTableauA); 
		JScrollPane uneScrollA = new JScrollPane(this.uneTableA); 
		uneScrollA.setBounds(0, 60, 380, 200);
		this.panelTable2.add(uneScrollA); 
		
		
		this.add(this.panelTable1);
		this.panelTable1.setVisible(false);
		this.add(this.panelTable2);
		this.panelTable2.setVisible(false);
		
		//mot de recherche dans le tableau enfant
		this.txtMotE.setBounds(60,10,120,25);
		this.panelTable1.add(this.txtMotE);
		this.btRechercherE.setBounds(200,10,120,25);
		this.panelTable1.add(this.btRechercherE);
		this.add(this.panelTable1);
		
		//mot de recherche dans le tableau adult
		this.txtMotA.setBounds(60,10,120,25);
		this.panelTable2.add(this.txtMotA);
		this.btRechercherA.setBounds(200,10,120,25);
		this.panelTable2.add(this.btRechercherA);
		this.add(this.panelTable2);
		
		
		//mouse listener type eve enfant
		this.uneTableE.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int nbclic = e.getClickCount();
				if(nbclic==2)
				{
					int numLigne=uneTableE.getSelectedRow();
					int retour =JOptionPane.showConfirmDialog(null, "Vous voulez suppimer ce type ?",
							"Suprresion type evénement enfant", JOptionPane.YES_NO_OPTION);
					if (retour == 0)
					{
						//suppresion du type eve enfant
						String codeTypeE = unTableauE.getValueAt(numLigne, 0).toString();
						modele.deletetypeEveEnfant(codeTypeE);
						
						//actualiser l'affichage
						unTableauE.supprimerLigne(numLigne);
					}
					
				}
				else if(nbclic==1)
				{
					int numLigne1=uneTableE.getSelectedRow();					
					
					String codeTypeE = uneTableE.getValueAt(numLigne1,0).toString();
					txtCodeType.setText(codeTypeE);
					
					String nomTypeE = uneTableE.getValueAt(numLigne1,1).toString();
					txtNomtype.setText(nomTypeE);
					
					String ageMin=uneTableE.getValueAt(numLigne1,2).toString();
					txtAgeMin.setText(ageMin);
										
					String ageMax = uneTableE.getValueAt(numLigne1,3).toString();
					txtAgeMax.setText(ageMax);
					
					String accompagnant = uneTableE.getValueAt(numLigne1,4).toString();
					cbAccompagnant.setSelectedItem(accompagnant);

					btEnregistrer.setText("Modifier");				
					
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
		});
		
		
		
		//mouse listener type eve adulte
		this.uneTableA.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				int nbclic = e.getClickCount();
				if(nbclic==2)
				{
					int numLigne=uneTableA.getSelectedRow();
					int retour =JOptionPane.showConfirmDialog(null, "Vous voulez suppimer cet type de evenement ?",
							"Suprresion type d'événement", JOptionPane.YES_NO_OPTION);
					if (retour == 0)
					{
						//suppresion du citoyen
						String codeTypeE = uneTableA.getValueAt(numLigne, 0).toString();
						modele.deletetypeEveAdulte(codeTypeE);
						
						//actualiser l'affichage
						unTableauA.supprimerLigne(numLigne);
					}
					
				}
				else if(nbclic==1)
				{
					int numLigne1=uneTableA.getSelectedRow();					
					String codeTypeE = uneTableA.getValueAt(numLigne1,0).toString();
					txtCodeType.setText(codeTypeE);					
					String nomTypeE = uneTableA.getValueAt(numLigne1,1).toString();
					txtNomtype.setText(nomTypeE);
					btEnregistrer.setText("Modifier");				
				}			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
			
		});
	
	}

	//get les données type Adulte
	private Object[][] getLesDonnees1(String mot) {
		ArrayList<TypeEveAdulte> lesTypeEveAdultes = null; 
		if (mot.equals("")) 
		{
			lesTypeEveAdultes = modele.selectAllTypeEveAdultes(); 
		} else {
			lesTypeEveAdultes = modele.selectLikeTypeEveAdulte(mot);
		}
		Object [][] matrice = new Object[lesTypeEveAdultes.size()][5];
		int i =0; 
		for (TypeEveAdulte unTypeEveAdulte : lesTypeEveAdultes)
		{
			matrice[i][0] = unTypeEveAdulte.getCodeTypeE();
			matrice[i][1] = unTypeEveAdulte.getNomTypeE();	
			i++; 
		}
		return matrice ; 
	}

	//get les données type Enfant
	private Object[][] getLesDonnees(String mot) 
	{
		ArrayList<TypeEveEnfant> lesTypeEveEnfant = null; 
		if (mot.equals("")) 
		{
			lesTypeEveEnfant = modele.selectAllTypeEveEnfant(); 
		} else {
			lesTypeEveEnfant = modele.selectLikeTypeEveEnfant(mot);
		}
		Object [][] matrice = new Object[lesTypeEveEnfant.size()][5];
		int i =0; 
		for (TypeEveEnfant unTypeEveEnfant : lesTypeEveEnfant)
		{
			matrice[i][0] = unTypeEveEnfant.getCodeTypeE();
			matrice[i][1] = unTypeEveEnfant.getNomTypeE();
			matrice[i][2] = unTypeEveEnfant.getAgeMin();
			matrice[i][3] = unTypeEveEnfant.getAgeMax();
			matrice[i][4] = unTypeEveEnfant.isAccompagnant();
			
			i++; 
		}
		return matrice ; 
	}
	//saisir TypeEveEnfant
	public TypeEveEnfant saisirTypeEveEnfant()
	{		
		TypeEveEnfant unTypeEveEnfant =null;
		String errorMessage = "";
		String codeTypeE = this.txtCodeType.getText();
		String nomTypeE = this.txtNomtype.getText();
		String txtAgeMin = this.txtAgeMin.getText();
		String txtAgeMax = this.txtAgeMax.getText();
		Integer ageMin = 0;
		Integer ageMax = 0;
		boolean accompagnant = false;
		
		String txtAccompagant = this.cbAccompagnant.getSelectedItem().toString();
		if(txtAccompagant.equals(""))
		{
			this.txtCodeType.setBackground(Color.red);
			errorMessage += "Info accompagnant est requis \n";
		}
		else
		{
			if(txtAccompagant == "oui")
			{
				accompagnant = true;
			}
			else
			{
				accompagnant = false;
			}
		}
		
		if(codeTypeE.equals(""))
		{
			this.txtCodeType.setBackground(Color.red);
			errorMessage += "Code type est requis \n";
		}
		else 
		{
			this.txtCodeType.setBackground(Color.white);
		}
		
		//check nom
		if(nomTypeE.equals(""))
		{
			this.txtNomtype.setBackground(Color.red);
			errorMessage += "Nom type est requis \n";
		}
		else 
		{
			this.txtNomtype.setBackground(Color.white);
		}
		
		//check age min
		try 
		{
			ageMin = Integer.parseInt(txtAgeMin);
			this.txtAgeMin.setBackground(Color.white);
		} catch (NumberFormatException nfe) 
		{
		  this.txtAgeMin.setBackground(Color.red);
		  errorMessage += "Age minimum est requis \n";
		}
		
		//check age max
		try 
		{
			ageMax = Integer.parseInt(txtAgeMax);
			this.txtAgeMax.setBackground(Color.white);
		} catch (NumberFormatException nfe) 
		{
		  this.txtAgeMax.setBackground(Color.red);
		  errorMessage += "Age maximum est requis \n";
		}
		
		if(errorMessage != "")
		{
			JOptionPane.showMessageDialog(this, "Erreur de saisir: \n" + errorMessage);
			
			return null;
		}
		
		if(!codeTypeE.equals("") && !nomTypeE.equals("")
			&& ( accompagnant != true  || accompagnant != false)	)			
			{
				unTypeEveEnfant = new TypeEveEnfant(codeTypeE,nomTypeE,ageMin,ageMax,accompagnant);
			}
			else 
			{
				return null;
			}
			return unTypeEveEnfant;
	}
	
	//saisirTypeAdulte
	public TypeEveAdulte saisirtypeEveAdulte()
	{
		TypeEveAdulte uneTypeEveAdulte=null;
		String errorMessage = "";
		String codeTypeE =this.txtCodeType.getText();
		String nomTypeE = this.txtNomtype.getText();
		

		//check saisi ****************************
		//check code type
		if(codeTypeE.equals(""))
		{
			this.txtCodeType.setBackground(Color.red);
			errorMessage += "Code type est requis \n";
		}
		else 
		{
			this.txtCodeType.setBackground(Color.white);
		}
		
		//check nom
		if(nomTypeE.equals(""))
		{
			this.txtNomtype.setBackground(Color.red);
			errorMessage += "Nom de type est requis \n";
		}
		else 
		{
			this.txtNomtype.setBackground(Color.white);
		}
		if(errorMessage != "")
		{
			JOptionPane.showMessageDialog(this, "Erreur de saisir: \n" + errorMessage);
			
			return null;
		}
		
		//*************************************************

		//check type de boolean
		if(!codeTypeE.equals("") && !nomTypeE.equals("") )				
		{
			
			uneTypeEveAdulte = new TypeEveAdulte(codeTypeE, nomTypeE);
		}
		else 
		{
			return null;
		}
		return uneTypeEveAdulte;
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==this.radioTypeEveEnfant)
		{
			this.panelForm1.setVisible(true);
			this.panelTable1.setVisible(true);
			this.panelTable2.setVisible(false);
	
		}
		
		else if (e.getSource()==this.radioTypeEveAdult)
		{
			this.panelForm1.setVisible(false);
			this.panelTable1.setVisible(false);
			this.panelTable2.setVisible(true);
			
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer"))
		{
			if(this.radioTypeEveEnfant.isSelected())
			{
							
				TypeEveEnfant unTypeEveEnfant =this.saisirTypeEveEnfant();
				
				if(unTypeEveEnfant == null)
					return;
				
				modele.insertTypeEveEnfant(unTypeEveEnfant);
								
				//mettre a jour l'affichage 
				Object ligne[] = {unTypeEveEnfant.getCodeTypeE(), unTypeEveEnfant.getNomTypeE(), 
						unTypeEveEnfant.getAgeMin(), unTypeEveEnfant.getAgeMax(), 
						unTypeEveEnfant.isAccompagnant()}; 
				unTableauE.ajouterLigne(ligne);
				
				JOptionPane.showMessageDialog(this, "Insertion Réussie");
				this.viderChamps();
			}
			else 
			{
				TypeEveAdulte unTypeEveAdulte =this.saisirtypeEveAdulte();
				
				if(unTypeEveAdulte == null)
					return;
				modele.insertTypeEveAdulte(unTypeEveAdulte);
								
				//mettre a jour l'affichage 
				Object ligne[] = {unTypeEveAdulte.getCodeTypeE(), unTypeEveAdulte.getNomTypeE()}; 
				unTableauA.ajouterLigne(ligne);
				
				JOptionPane.showMessageDialog(this, "Insertion Réussie");
				this.viderChamps1();
			}
		}
		else if( e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			if(this.radioTypeEveEnfant.isSelected())
			{
				TypeEveEnfant unTypeEveEnfant =this.saisirTypeEveEnfant();
				JOptionPane.showMessageDialog(this, "Modification effectuee");
				int numLigne =this.uneTableE.getSelectedRow();
				
				String codeTypeE = unTableauE.getValueAt(numLigne, 0).toString();
				unTypeEveEnfant.setCodeTypeE(codeTypeE);
				
				Object ligne[]= 
				{
					unTypeEveEnfant.getCodeTypeE(),unTypeEveEnfant.getNomTypeE(), unTypeEveEnfant.getAgeMin(),
					unTypeEveEnfant.getAgeMax(),unTypeEveEnfant.isAccompagnant()
				};
				
				unTableauE.modifierLigne(numLigne,ligne);
				modele.updateTypeEveEnfant(unTypeEveEnfant);
				this.btEnregistrer.setText("Enregistrer");
				this.viderChamps();
				
			}
			else 
			{
				TypeEveAdulte uneTypeEveAdulte = this.saisirtypeEveAdulte();
				if(uneTypeEveAdulte == null)
					return;
				
				JOptionPane.showMessageDialog(this, "Modification effectuee");
				int numLigne =this.uneTableA.getSelectedRow();
				
				String codeTypeE = unTableauA.getValueAt(numLigne, 0).toString();
				uneTypeEveAdulte.setCodeTypeE(codeTypeE);
				
				Object ligne[]= 
				{
					uneTypeEveAdulte.getCodeTypeE(),uneTypeEveAdulte.getNomTypeE()
				};
				
				unTableauA.modifierLigne(numLigne,ligne);
				modele.updateTypeEveAdulte(uneTypeEveAdulte);
				this.btEnregistrer.setText("Enregistrer");
				this.viderChamps1();
				
			}
		}
		else if (e.getSource()==this.btRechercherE)	
		{
			String mot =this.txtMotE.getText();
			
			Object matrice [][] =this.getLesDonnees(mot);
			unTableauE.setDonnees(matrice);
		}
		else if (e.getSource()==this.btRechercherA)	
		{
			String mot =this.txtMotA.getText();
			
			Object matrice [][] =this.getLesDonnees(mot);
			unTableauA.setDonnees(matrice);
		}	
		
		else if (e.getSource()==this.btAnnuler)	
		{
			if(this.radioTypeEveEnfant.isSelected())
			{
				this.viderChamps();
			}
			else
			{
				this.viderChamps1();
			}
		}
			
	
	
	}

	private void viderChamps1()
	{
		this.txtCodeType.setText("");
		this.txtNomtype.setText("");
		
	}

	private void viderChamps()
	{
		this.txtCodeType.setText("");
		this.txtNomtype.setText("");
		this.txtAgeMin.setText("");
		this.txtAgeMax.setText("");
		this.cbAccompagnant.setSelectedItem("");
		
	}
}
