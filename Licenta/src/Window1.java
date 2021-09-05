import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class Window1 {

	private JFrame frame;
	private JFileChooser openFileChooser;
	
	private ArrayList<String> ImageList1 = new ArrayList<>();
	private ArrayList<String> ImageList2 = new ArrayList<>();
	private ArrayList <Pereche> rezultat_comparatie = new ArrayList<>();
	

	
	File Folder1;
	File Folder2;
	
	public void setVisible(boolean input){
	    frame.setVisible(input);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 window = new Window1();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public Window1() {
		
		initialize();
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("c:\\Users\\ir3al\\Desktop"));
		openFileChooser.setDialogTitle("Select Directory");
		openFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		openFileChooser.setAcceptAllFileFilterUsed(false);
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
	
		
		frame.setBounds(200, 200, 445, 344);
		frame.setSize(525, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Image Compare");
		
		JButton Dir1Select = new JButton("Choose Directory");
		Dir1Select.setBounds(32, 53, 150, 23);
		frame.getContentPane().add(Dir1Select);
		Dir1Select.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JButton Dir2Select = new JButton("Choose Directory");
		Dir2Select.setBounds(328, 53, 150, 23);
		frame.getContentPane().add(Dir2Select);
		Dir2Select.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JTextPane Img1Label = new JTextPane();
		Img1Label.setBounds(10, 87, 231, 81);
		Img1Label.setEditable(false);
		Img1Label.setBackground(frame.getBackground());
		Img1Label.setText("No directory choosed ! Please select one !");
		
		
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setFontSize(attribs, 14);
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		StyleConstants.setBold(attribs, true);
		Img1Label.setParagraphAttributes(attribs, true);
		frame.getContentPane().add(Img1Label);
		
		
		JTextPane Img2Label = new JTextPane();
		Img2Label.setBounds(275, 86, 231, 82);
		Img2Label.setEditable(false);
		
		Img2Label.setBackground(frame.getBackground());
		Img2Label.setText("No directory choosed ! Please select one !");
		Img2Label.setParagraphAttributes(attribs, true);
		frame.getContentPane().add(Img2Label);
		
		JButton btnCompare = new JButton("Compare");
		btnCompare.setBounds(179, 612, 165, 40);
		frame.getContentPane().add(btnCompare);
		
		
		 
		
		   JRadioButton crescator  = new JRadioButton("Ascending");
		   crescator.setBounds(142, 565, 105, 23);
		   crescator.setSelected(true);
		   crescator.setFont(new Font("Monospaced", Font.BOLD, 15));
		   frame.getContentPane().add(crescator);
		   
		   JRadioButton descrescator = new JRadioButton("Descendig");
		   descrescator.setBounds(282, 565, 105, 23);
		   descrescator.setFont(new Font("Monospaced", Font.BOLD, 15));
		   frame.getContentPane().add(descrescator);
		   
		   ButtonGroup grup = new ButtonGroup();
		   grup.add(crescator);
		   grup.add(descrescator);
		   
		   
		String[] distante = new String[] {"-- -- -- Select -- -- --","Euclidian Distance", "Manhattan Distance",
                "Chebyshev Distance"};
		JComboBox comboBox = new JComboBox(distante);
		comboBox.setBounds(179, 475, 165, 23);  
		frame.getContentPane().add(comboBox);
		
		
		
		JLabel lblNewLabel = new JLabel("FIRST DIRECTORY",SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 10, 150, 32);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SECOND DIRECTORY",SwingConstants.CENTER);
		lblNewLabel_1.setBounds(318, 10, 162, 32);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(32, 178, 196, 200);
		
		frame.getContentPane().add(img1);
		
		String cale_img_default = this.getClass().getResource("img/pic.png").getFile();
		File file_img_default = new File(cale_img_default);
		Image img_default = null;
		try {
				img_default = ImageIO.read(file_img_default);
		}catch (IOException e3) {
			    e3.printStackTrace();
		}
		Image resize_default_img = img_default.getScaledInstance(img1.getWidth(), img1.getHeight(),
			        Image.SCALE_SMOOTH);
		
		img1.setIcon(new ImageIcon(resize_default_img));
		
		
		JLabel img2 = new JLabel("");
		img2.setBounds(76, 151, 56, 215);
		frame.getContentPane().add(img2);
		img2.setVisible(false);
		
		JLabel img3 = new JLabel("");
		img3.setBounds(142, 152, 57, 215);
		frame.getContentPane().add(img3);
		img3.setVisible(false);
		
		JLabel img4 = new JLabel("");
		img4.setBounds(206, 151, 35, 215);
		frame.getContentPane().add(img4);
		img4.setVisible(false);
		
		JLabel img1_1 = new JLabel("");
		img1_1.setBounds(282, 178, 196, 200);
		frame.getContentPane().add(img1_1);
		img1_1.setIcon(new ImageIcon(resize_default_img));
		
		JLabel img2_1 = new JLabel("");
		img2_1.setBounds(351, 151, 56, 215);
		frame.getContentPane().add(img2_1);
		img2_1.setVisible(false);
		
		JLabel img3_1 = new JLabel("");
		img3_1.setBounds(417, 151, 56, 215);
		frame.getContentPane().add(img3_1);
		img3_1.setVisible(false);
		
		
		JLabel img4_1 = new JLabel("");
		img4_1 .setBounds(477, 153, 29, 225);
		frame.getContentPane().add(img4_1 );
		img4_1.setVisible(false);
		
		JButton delete1 = new JButton("Clear");
		delete1.setBounds(53, 388, 89, 23);
		frame.getContentPane().add(delete1);
		delete1.setVisible(false);
		
		delete1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(ImageList1.size()  >= 3)
				{
					ImageList1.clear();
					Img1Label.setText("The Images have been deleted ! ");
					
					img1.setIcon(new ImageIcon(resize_default_img));
					img1.setBounds(25, 178, 196, 200);//282, 178, 196, 200
					img2.setIcon(null);
					img3.setIcon(null);
					img4.setText(null);
					delete1.setVisible(false);
					
				}
				
				else if(ImageList1.size()  == 2)
				{
					ImageList1.clear();
					Img1Label.setText("The Images have been deleted ! ");
					
					img1.setIcon(new ImageIcon(resize_default_img));
					img1.setBounds(25, 178, 196, 200);
					img2.setIcon(null);
					img3.setText(null);
					delete1.setVisible(false);
				}
				
				else if(ImageList1.size()  == 1)
				{
					ImageList1.clear();
					Img1Label.setText("The Images have been deleted ! ");
					
					img1.setIcon(new ImageIcon(resize_default_img));
					img1.setBounds(25, 178, 196, 200);
					img2.setText(null);
					delete1.setVisible(false);
				}
				
			}
		});
		
		
		
		JButton delete2 = new JButton("Clear");
		delete2.setBounds(328, 388, 89, 23);
		frame.getContentPane().add(delete2);
		delete2.setVisible(false);
		
		delete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ImageList2.size()  >= 3)
				{
					ImageList2.clear();
					Img2Label.setText("The Images have been deleted ! ");
					
					img1_1.setIcon(new ImageIcon(resize_default_img));
					img1_1.setBounds(290, 178, 196, 200);
					img2_1.setIcon(null);
					img3_1.setIcon(null);
					img4_1.setText(null);
					delete2.setVisible(false);
					
					
				}
				
				else if(ImageList2.size()  == 2)
				{
					ImageList2.clear();
					Img2Label.setText("The Images have been deleted ! ");
					
					img1_1.setIcon(new ImageIcon(resize_default_img));
					img1_1.setBounds(290, 178, 196, 200);
					img2_1.setIcon(null);
					img3_1.setText(null);
					delete2.setVisible(false);
				}
				
				else if(ImageList2.size()  == 1)
				{
					ImageList2.clear();
					Img2Label.setText("The Images have been deleted ! ");
					
					img1_1.setIcon(new ImageIcon(resize_default_img));
					img1_1.setBounds(290, 178, 196, 200);
					img2_1.setText(null);
					delete2.setVisible(false);
				}
				
			}
		});
			
		
		JTextPane selectDistPane =  new JTextPane();
		selectDistPane.setBounds(142, 419, 232, 46);
		frame.getContentPane().add(selectDistPane);
		selectDistPane.setText("SELECT A DISTANCE ");
		selectDistPane.setEditable(false);
		SimpleAttributeSet attribs3 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs3, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(attribs3, 17);
		StyleConstants.setBold(attribs3, true);
		StyleConstants.setForeground(attribs3, Color.BLUE);
		StyleConstants.setFontFamily(attribs3, Font.MONOSPACED);
		
		selectDistPane.setParagraphAttributes(attribs3, true);
		//selectDistPane.setVisible(false);
		selectDistPane.setBackground(frame.getBackground());
		
		JTextPane selectDistPane_1 = new JTextPane();
		selectDistPane_1.setText("CHOOSE YOUR FAVORITE ODRDER ");
		selectDistPane_1.setEditable(false);
		selectDistPane_1.setBackground(SystemColor.menu);
		selectDistPane_1.setBounds(10, 519, 491, 40);
		frame.getContentPane().add(selectDistPane_1);
	
		selectDistPane_1.setParagraphAttributes(attribs3, true); 
		
	
Comparator<Pereche> comp = new Comparator<Pereche>()
	{
		public int compare(Pereche p1, Pereche p2) {
					  
				return p1.compareTo(p2);
			}
	};
	
	
	
	
btnCompare.addActionListener(new ActionListener ()  {
			
			
			public void actionPerformed(ActionEvent e) {
			
		
				if (comboBox.getSelectedIndex() > 0)
					
				{		
					selectDistPane.setText("");
				}
				
			
				
				if(ImageList1.size()== 0 && ImageList2.size()== 0)
				{
					Img1Label.setText("No Images Loaded ! Please select a directory !");
					Img2Label.setText("No Images Loaded ! Please select a directory !");
					
					StyleConstants.setForeground(attribs, Color.RED);
					Img1Label.setParagraphAttributes(attribs, true);
					Img2Label.setParagraphAttributes(attribs, true);
					
				}
				
				else if (ImageList1.size()== 0 && ImageList2.size()!= 0)
				{
					Img1Label.setText("No Images Loaded ! Please select a directory !");
					StyleConstants.setForeground(attribs, Color.RED);
					Img1Label.setParagraphAttributes(attribs, true);
					
				}
				
				else if (ImageList1.size()!= 0 && ImageList2.size()== 0)
				{
					Img2Label.setText("No Images Loaded ! Please select a directory !");
					StyleConstants.setForeground(attribs, Color.RED);
					Img2Label.setParagraphAttributes(attribs, true);
				}
				
				
				
				else if (comboBox.getSelectedIndex() < 1)
					
				{		selectDistPane.setText("PLEASE SELECT A DISTANCE !");
						StyleConstants.setForeground(attribs3, Color.RED);
						selectDistPane.setParagraphAttributes(attribs3, true);
				
				}
				
				
				
				else {
					
					
					String titlu_w2 = "";
					
						if(comboBox.getSelectedItem().toString().equals("Euclidian Distance"))
						{
									titlu_w2 = "Euclidian Distance";
								try {
										rezultat_comparatie = EuclidianDistance2(ImageList1,ImageList2);
										
										Collections.sort(rezultat_comparatie, comp);
										
									} catch (Exception ex1)
										{
											ex1.printStackTrace();
										}
								
										System.out.println("EUCLIDIAN");
										
										for(Pereche p: rezultat_comparatie)
										{
											String nume1=p.getPath1().substring(p.getPath1().lastIndexOf("\\")+1);
											String nume2=p.getPath2().substring(p.getPath2().lastIndexOf("\\")+1);
											System.out.println("Perechea : "  + nume1 + "  -  " + nume2 + "  are rezultatul : " + p.getRezultat());
										}
										
		
						}
						
						
						
						
						else if((comboBox.getSelectedItem().toString().equals("Manhattan Distance")))
						{
							
							titlu_w2 = "Manhattan Distance";
							try {
								rezultat_comparatie = ManhattanDistance(ImageList1,ImageList2);
								Collections.sort(rezultat_comparatie, comp);
								
							} catch (Exception ex1)
								{
									ex1.printStackTrace();
								}
								System.out.println("MANHATTAN");
								for(Pereche p: rezultat_comparatie)
								{
									
									String nume1=p.getPath1().substring(p.getPath1().lastIndexOf("\\")+1);
									String nume2=p.getPath2().substring(p.getPath2().lastIndexOf("\\")+1);
									System.out.println("Perechea : "  + nume1 + "  -  " + nume2 + "  are rezultatul : " + p.getRezultat());
								}

						}
						
						else if((comboBox.getSelectedItem().toString().equals("Chebyshev Distance")))
						{
							titlu_w2 = "Chebyshev Distance";
							
							try {
								rezultat_comparatie = ChebyshevDistance(ImageList1,ImageList2);
								
								Collections.sort(rezultat_comparatie, comp);
								
							} catch (Exception ex1)
								{
									ex1.printStackTrace();
								}
								
								System.out.println("CHEBYSHEV");
								for(Pereche p: rezultat_comparatie)
								{	
									
									String nume1=p.getPath1().substring(p.getPath1().lastIndexOf("\\")+1);
									String nume2=p.getPath2().substring(p.getPath2().lastIndexOf("\\")+1);
									System.out.println("Perechea : "  + nume1 + "  -  " + nume2 + "  are rezultatul : " + p.getRezultat());
								}
							
						}
						
						
	if(crescator.isSelected()) {	
		
		
		writeCsv(rezultat_comparatie);
		
		titlu_w2 = titlu_w2 + (" - Ascending !");
		
			if (rezultat_comparatie.size() >=6 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);
				
				//w2.getPaneTextTitlu1_1().setText(nume1_1);
				
				
				w2.setImage(rezultat_comparatie.get(1).getPath1(), w2.getLabel2());
				w2.setImage(rezultat_comparatie.get(1).getPath2(), w2.getLabel2_1());
				w2.setImage(rezultat_comparatie.get(1).getImagine(), w2.rezultat2());
				String nume2 = rezultat_comparatie.get(1).getPath1().substring(rezultat_comparatie.get(1).getPath1().lastIndexOf("\\")+1);
				String nume2_1 = rezultat_comparatie.get(1).getPath2().substring(rezultat_comparatie.get(1).getPath2().lastIndexOf("\\")+1);
				if(nume2.length()>11)
				{
					nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
				}
				
				if(nume2_1.length()>11)
				{
					nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
				}
				w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(1).getRezultat()));
				w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
				//w2.getPaneTextTitlu2_1().setText(nume2_1);
				
				w2.setImage(rezultat_comparatie.get(2).getPath1(), w2.getLabel3());
				w2.setImage(rezultat_comparatie.get(2).getPath2(), w2.getLabel3_1());
				w2.setImage(rezultat_comparatie.get(2).getImagine(), w2.rezultat3());
				String nume3 = rezultat_comparatie.get(2).getPath1().substring(rezultat_comparatie.get(2).getPath1().lastIndexOf("\\")+1);
				String nume3_1 = rezultat_comparatie.get(2).getPath2().substring(rezultat_comparatie.get(2).getPath2().lastIndexOf("\\")+1);
				if(nume3.length()>11)
				{
					nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
				}
				
				if(nume3_1.length()>11)
				{
					nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
				}
				w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(2).getRezultat()));
				w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
				//w2.getPaneTextTitlu3_1().setText(nume3_1);
				
				w2.setImage(rezultat_comparatie.get(3).getPath1(), w2.getLabel4());
				w2.setImage(rezultat_comparatie.get(3).getPath2(), w2.getLabel4_1());
				w2.setImage(rezultat_comparatie.get(3).getImagine(), w2.rezultat4());
				String nume4 = rezultat_comparatie.get(3).getPath1().substring(rezultat_comparatie.get(3).getPath1().lastIndexOf("\\")+1);
				String nume4_1 = rezultat_comparatie.get(3).getPath2().substring(rezultat_comparatie.get(3).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
				}
				
				if(nume4_1.length()>11)
				{
					nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
				}
				w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(3).getRezultat()));
				w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
				//w2.getPaneTextTitlu4_1().setText(nume4_1);
				
				w2.setImage(rezultat_comparatie.get(4).getPath1(), w2.getLabel5());
				w2.setImage(rezultat_comparatie.get(4).getPath2(), w2.getLabel5_1());
				w2.setImage(rezultat_comparatie.get(4).getImagine(), w2.rezultat5());
				String nume5 = rezultat_comparatie.get(4).getPath1().substring(rezultat_comparatie.get(4).getPath1().lastIndexOf("\\")+1);
				String nume5_1 = rezultat_comparatie.get(4).getPath2().substring(rezultat_comparatie.get(4).getPath2().lastIndexOf("\\")+1);
				if(nume5.length()>11)
				{
					nume5 = nume5.substring(0, Math.min(nume5.length(), 10))+"...";
				}
				
				if(nume5_1.length()>11)
				{
					nume5_1 = nume5_1.substring(0, Math.min(nume5_1.length(), 10))+"...";
				}
				w2.getPaneRezultat5().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(4).getRezultat()));
				w2.getPaneTextTitlu5().setText("FIFTH PAIR : "+nume5+"\n"+nume5_1);
				//w2.getPaneTextTitlu5_1().setText(nume5_1);
				
				w2.setImage(rezultat_comparatie.get(5).getPath1(), w2.getLabel6());
				w2.setImage(rezultat_comparatie.get(5).getPath2(), w2.getLabel6_1());
				w2.setImage(rezultat_comparatie.get(5).getImagine(), w2.rezultat6());
				String nume6 = rezultat_comparatie.get(5).getPath1().substring(rezultat_comparatie.get(5).getPath1().lastIndexOf("\\")+1);
				String nume6_1 = rezultat_comparatie.get(5).getPath2().substring(rezultat_comparatie.get(5).getPath2().lastIndexOf("\\")+1);
				if(nume6.length()>11)
				{
					nume6 = nume6.substring(0, Math.min(nume6.length(), 10))+"...";
				}
				
				if(nume6_1.length()>11)
				{
					nume6_1 = nume6_1.substring(0, Math.min(nume6_1.length(), 10))+"...";
				}
				w2.getPaneRezultat6().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(5).getRezultat()));
				w2.getPaneTextTitlu6().setText("SIXTH PAIR : "+nume6+"\n"+nume6_1);
				//w2.getPaneTextTitlu6_1().setText(nume6_1);
			
			}
			
			else if (rezultat_comparatie.size() == 5 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);
				
				//w2.getPaneTextTitlu1_1().setText(nume1_1);
				
				
				w2.setImage(rezultat_comparatie.get(1).getPath1(), w2.getLabel2());
				w2.setImage(rezultat_comparatie.get(1).getPath2(), w2.getLabel2_1());
				w2.setImage(rezultat_comparatie.get(1).getImagine(), w2.rezultat2());
				String nume2 = rezultat_comparatie.get(1).getPath1().substring(rezultat_comparatie.get(1).getPath1().lastIndexOf("\\")+1);
				String nume2_1 = rezultat_comparatie.get(1).getPath2().substring(rezultat_comparatie.get(1).getPath2().lastIndexOf("\\")+1);
				if(nume2.length()>11)
				{
					nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
				}
				
				if(nume2_1.length()>11)
				{
					nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
				}
				w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(1).getRezultat()));
				w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
				//w2.getPaneTextTitlu2_1().setText(nume2_1);
				
				w2.setImage(rezultat_comparatie.get(2).getPath1(), w2.getLabel3());
				w2.setImage(rezultat_comparatie.get(2).getPath2(), w2.getLabel3_1());
				w2.setImage(rezultat_comparatie.get(2).getImagine(), w2.rezultat3());
				String nume3 = rezultat_comparatie.get(2).getPath1().substring(rezultat_comparatie.get(2).getPath1().lastIndexOf("\\")+1);
				String nume3_1 = rezultat_comparatie.get(2).getPath2().substring(rezultat_comparatie.get(2).getPath2().lastIndexOf("\\")+1);
				if(nume3.length()>11)
				{
					nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
				}
				
				if(nume3_1.length()>11)
				{
					nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
				}
				w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(2).getRezultat()));
				w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
				//w2.getPaneTextTitlu3_1().setText(nume3_1);
				
				w2.setImage(rezultat_comparatie.get(3).getPath1(), w2.getLabel4());
				w2.setImage(rezultat_comparatie.get(3).getPath2(), w2.getLabel4_1());
				w2.setImage(rezultat_comparatie.get(3).getImagine(), w2.rezultat4());
				String nume4 = rezultat_comparatie.get(3).getPath1().substring(rezultat_comparatie.get(3).getPath1().lastIndexOf("\\")+1);
				String nume4_1 = rezultat_comparatie.get(3).getPath2().substring(rezultat_comparatie.get(3).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
				}
				
				if(nume4_1.length()>11)
				{
					nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
				}
				w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(3).getRezultat()));
				w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
				//w2.getPaneTextTitlu4_1().setText(nume4_1);
				
				w2.setImage(rezultat_comparatie.get(4).getPath1(), w2.getLabel5());
				w2.setImage(rezultat_comparatie.get(4).getPath2(), w2.getLabel5_1());
				w2.setImage(rezultat_comparatie.get(4).getImagine(), w2.rezultat5());
				String nume5 = rezultat_comparatie.get(4).getPath1().substring(rezultat_comparatie.get(4).getPath1().lastIndexOf("\\")+1);
				String nume5_1 = rezultat_comparatie.get(4).getPath2().substring(rezultat_comparatie.get(4).getPath2().lastIndexOf("\\")+1);
				if(nume5.length()>11)
				{
					nume5 = nume5.substring(0, Math.min(nume5.length(), 10))+"...";
				}
				
				if(nume5_1.length()>11)
				{
					nume5_1 = nume5_1.substring(0, Math.min(nume5_1.length(), 10))+"...";
				}
				w2.getPaneRezultat5().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(4).getRezultat()));
				w2.getPaneTextTitlu5().setText("FIFTH PAIR : "+nume5+"\n"+nume5_1);
				//w2.getPaneTextTitlu5_1().setText(nume5_1);
				
				
				w2.getLabel6().setVisible(false);
				w2.getLabel6_1().setVisible(false);
				
				w2.getPaneTextTitlu6().setVisible(false);
				w2.getLabel6_big().setVisible(false);
				w2.rezultat6().setVisible(false);
				
				w2.getPaneRezultat6().setVisible(false);
				
			}
			
			else if (rezultat_comparatie.size() == 4 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				
			
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);
				
				//w2.getPaneTextTitlu1_1().setText(nume1_1);
				
				
				w2.setImage(rezultat_comparatie.get(1).getPath1(), w2.getLabel2());
				w2.setImage(rezultat_comparatie.get(1).getPath2(), w2.getLabel2_1());
				w2.setImage(rezultat_comparatie.get(1).getImagine(), w2.rezultat2());
				String nume2 = rezultat_comparatie.get(1).getPath1().substring(rezultat_comparatie.get(1).getPath1().lastIndexOf("\\")+1);
				String nume2_1 = rezultat_comparatie.get(1).getPath2().substring(rezultat_comparatie.get(1).getPath2().lastIndexOf("\\")+1);
				if(nume2.length()>11)
				{
					nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
				}
				
				if(nume2_1.length()>11)
				{
					nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
				}
				w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(1).getRezultat()));
				w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
				//w2.getPaneTextTitlu2_1().setText(nume2_1);
				
				w2.setImage(rezultat_comparatie.get(2).getPath1(), w2.getLabel3());
				w2.setImage(rezultat_comparatie.get(2).getPath2(), w2.getLabel3_1());
				w2.setImage(rezultat_comparatie.get(2).getImagine(), w2.rezultat3());
				String nume3 = rezultat_comparatie.get(2).getPath1().substring(rezultat_comparatie.get(2).getPath1().lastIndexOf("\\")+1);
				String nume3_1 = rezultat_comparatie.get(2).getPath2().substring(rezultat_comparatie.get(2).getPath2().lastIndexOf("\\")+1);
				if(nume3.length()>11)
				{
					nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
				}
				
				if(nume3_1.length()>11)
				{
					nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
				}
				w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(2).getRezultat()));
				w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
				//w2.getPaneTextTitlu3_1().setText(nume3_1);
				
				w2.setImage(rezultat_comparatie.get(3).getPath1(), w2.getLabel4());
				w2.setImage(rezultat_comparatie.get(3).getPath2(), w2.getLabel4_1());
				w2.setImage(rezultat_comparatie.get(3).getImagine(), w2.rezultat4());
				String nume4 = rezultat_comparatie.get(3).getPath1().substring(rezultat_comparatie.get(3).getPath1().lastIndexOf("\\")+1);
				String nume4_1 = rezultat_comparatie.get(3).getPath2().substring(rezultat_comparatie.get(3).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
				}
				
				if(nume4_1.length()>11)
				{
					nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
				}
				w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(3).getRezultat()));
				w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
				//w2.getPaneTextTitlu4_1().setText(nume4_1);
				
				
				w2.getLabel5().setVisible(false);
				w2.getLabel5_1().setVisible(false);
				w2.getLabel6().setVisible(false);
				w2.getLabel6_1().setVisible(false);
				
				w2.getPaneTextTitlu6().setVisible(false);
				w2.getPaneTextTitlu5().setVisible(false);
				
				w2.getLabel6_big().setVisible(false);
				w2.getLabel5_big().setVisible(false);
				
				w2.rezultat6().setVisible(false);
				w2.rezultat5().setVisible(false);
				
				w2.getPaneRezultat6().setVisible(false);
				w2.getPaneRezultat5().setVisible(false);
				
			}
			
			else if (rezultat_comparatie.size() == 3 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);

				
				w2.setImage(rezultat_comparatie.get(1).getPath1(), w2.getLabel2());
				w2.setImage(rezultat_comparatie.get(1).getPath2(), w2.getLabel2_1());
				w2.setImage(rezultat_comparatie.get(1).getImagine(), w2.rezultat2());
				String nume2 = rezultat_comparatie.get(1).getPath1().substring(rezultat_comparatie.get(1).getPath1().lastIndexOf("\\")+1);
				String nume2_1 = rezultat_comparatie.get(1).getPath2().substring(rezultat_comparatie.get(1).getPath2().lastIndexOf("\\")+1);
				if(nume2.length()>11)
				{
					nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
				}
				
				if(nume2_1.length()>11)
				{
					nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
				}
				w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(1).getRezultat()));
				w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
				//w2.getPaneTextTitlu2_1().setText(nume2_1);
				
				w2.setImage(rezultat_comparatie.get(2).getPath1(), w2.getLabel3());
				w2.setImage(rezultat_comparatie.get(2).getPath2(), w2.getLabel3_1());
				w2.setImage(rezultat_comparatie.get(2).getImagine(), w2.rezultat3());
				String nume3 = rezultat_comparatie.get(2).getPath1().substring(rezultat_comparatie.get(2).getPath1().lastIndexOf("\\")+1);
				String nume3_1 = rezultat_comparatie.get(2).getPath2().substring(rezultat_comparatie.get(2).getPath2().lastIndexOf("\\")+1);
				if(nume3.length()>11)
				{
					nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
				}
				
				if(nume3_1.length()>11)
				{
					nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
				}
				w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(2).getRezultat()));
				w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
				//w2.getPaneTextTitlu3_1().setText(nume3_1);
				
				w2.getLabel4().setVisible(false);
				w2.getLabel4_1().setVisible(false);
				w2.getLabel5().setVisible(false);
				w2.getLabel5_1().setVisible(false);
				w2.getLabel6().setVisible(false);
				w2.getLabel6_1().setVisible(false);
				
				w2.getPaneTextTitlu6().setVisible(false);
				w2.getPaneTextTitlu5().setVisible(false);
				w2.getPaneTextTitlu4().setVisible(false);
				
				w2.getLabel6_big().setVisible(false);
				w2.getLabel5_big().setVisible(false);
				w2.getLabel4_big().setVisible(false);
				
				
				w2.rezultat6().setVisible(false);
				w2.rezultat5().setVisible(false);
				w2.rezultat4().setVisible(false);
				
				
				w2.getPaneRezultat6().setVisible(false);
				w2.getPaneRezultat5().setVisible(false);
				w2.getPaneRezultat4().setVisible(false);
				
			}
			
			else if (rezultat_comparatie.size() == 2 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);

				
				w2.setImage(rezultat_comparatie.get(1).getPath1(), w2.getLabel2());
				w2.setImage(rezultat_comparatie.get(1).getPath2(), w2.getLabel2_1());
				w2.setImage(rezultat_comparatie.get(1).getImagine(), w2.rezultat2());
				String nume2 = rezultat_comparatie.get(1).getPath1().substring(rezultat_comparatie.get(1).getPath1().lastIndexOf("\\")+1);
				String nume2_1 = rezultat_comparatie.get(1).getPath2().substring(rezultat_comparatie.get(1).getPath2().lastIndexOf("\\")+1);
				if(nume2.length()>11)
				{
					nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
				}
				
				if(nume2_1.length()>11)
				{
					nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
				}
				w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(1).getRezultat()));
				w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
				//w2.getPaneTextTitlu2_1().setText(nume2_1);
				
				w2.getLabel3().setVisible(false);
				w2.getLabel3_1().setVisible(false);
				w2.getLabel4().setVisible(false);
				w2.getLabel4_1().setVisible(false);
				w2.getLabel5().setVisible(false);
				w2.getLabel5_1().setVisible(false);
				w2.getLabel6().setVisible(false);
				w2.getLabel6_1().setVisible(false);
				
				w2.getPaneTextTitlu6().setVisible(false);
				w2.getPaneTextTitlu5().setVisible(false);
				w2.getPaneTextTitlu4().setVisible(false);
				w2.getPaneTextTitlu3().setVisible(false);
				
				
				w2.getLabel6_big().setVisible(false);
				w2.getLabel5_big().setVisible(false);
				w2.getLabel4_big().setVisible(false);
				w2.getLabel3_big().setVisible(false);
				
				
				
				w2.rezultat6().setVisible(false);
				w2.rezultat5().setVisible(false);
				w2.rezultat4().setVisible(false);
				w2.rezultat3().setVisible(false);
				
				
				w2.getPaneRezultat6().setVisible(false);
				w2.getPaneRezultat5().setVisible(false);
				w2.getPaneRezultat4().setVisible(false);
				w2.getPaneRezultat3().setVisible(false);
			}
			
			else if (rezultat_comparatie.size() == 1 )
			{
				Window2 w2 = new Window2();
				w2.setVisible(true);
				w2.setFrame();
				w2.getPaneText().setText(titlu_w2);
				
				w2.setImage(rezultat_comparatie.get(0).getPath1(), w2.getLabel1());
				w2.setImage(rezultat_comparatie.get(0).getPath2(), w2.getLabel1_1());
				w2.setImage(rezultat_comparatie.get(0).getImagine(), w2.rezultat1());
				String nume1 = rezultat_comparatie.get(0).getPath1().substring(rezultat_comparatie.get(0).getPath1().lastIndexOf("\\")+1);
				String nume1_1 = rezultat_comparatie.get(0).getPath2().substring(rezultat_comparatie.get(0).getPath2().lastIndexOf("\\")+1);
				if(nume1.length()>11)
				{
					nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
				}
				
				if(nume1_1.length()>11)
				{
					nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
				}
			
				w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(0).getRezultat()));
				w2.getPaneTextTitlu1().setText("FIRST PAIR : "+"\n"+nume1+"\n"+nume1_1);

				
				
				w2.getLabel2().setVisible(false);
				w2.getLabel2_1().setVisible(false);
				w2.getLabel3().setVisible(false);
				w2.getLabel3_1().setVisible(false);
				w2.getLabel4().setVisible(false);
				w2.getLabel4_1().setVisible(false);
				w2.getLabel5().setVisible(false);
				w2.getLabel5_1().setVisible(false);
				w2.getLabel6().setVisible(false);
				w2.getLabel6_1().setVisible(false);
				
				w2.getPaneTextTitlu6().setVisible(false);
				w2.getPaneTextTitlu5().setVisible(false);
				w2.getPaneTextTitlu4().setVisible(false);
				w2.getPaneTextTitlu3().setVisible(false);
				w2.getPaneTextTitlu2().setVisible(false);
				
				
				w2.getLabel6_big().setVisible(false);
				w2.getLabel5_big().setVisible(false);
				w2.getLabel4_big().setVisible(false);
				w2.getLabel3_big().setVisible(false);
				w2.getLabel2_big().setVisible(false);
				
				w2.rezultat6().setVisible(false);
				w2.rezultat5().setVisible(false);
				w2.rezultat4().setVisible(false);
				w2.rezultat3().setVisible(false);
				w2.rezultat2().setVisible(false);
				
				
				
				w2.getPaneRezultat6().setVisible(false);
				w2.getPaneRezultat5().setVisible(false);
				w2.getPaneRezultat4().setVisible(false);
				w2.getPaneRezultat3().setVisible(false);
				w2.getPaneRezultat2().setVisible(false);
				
			}
			
			else 
			{
				Img2Label.setText("The Images Should Have the Same Dimension !");
				Img1Label.setText("The Images Should Have the Same Dimension !");
				
				
				StyleConstants.setForeground(attribs, Color.red);
				Img2Label.setParagraphAttributes(attribs, true);
				Img1Label.setParagraphAttributes(attribs, true);
			
			}
			
			}
	
	
		else if(descrescator.isSelected())
			{
					int size = rezultat_comparatie.size();
					titlu_w2=titlu_w2 + " - Descending !";
					
					ArrayList<Pereche> lista_reverse = new ArrayList<>(rezultat_comparatie);
					Collections.reverse(lista_reverse);
					writeCsv(lista_reverse);
					
				if (rezultat_comparatie.size() >=6 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.setImage(rezultat_comparatie.get(size-2).getPath1(), w2.getLabel2());
					w2.setImage(rezultat_comparatie.get(size-2).getPath2(), w2.getLabel2_1());
					w2.setImage(rezultat_comparatie.get(size-2).getImagine(), w2.rezultat2());
					String nume2 = rezultat_comparatie.get(size-2).getPath1().substring(rezultat_comparatie.get(size-2).getPath1().lastIndexOf("\\")+1);
					String nume2_1 = rezultat_comparatie.get(size-2).getPath2().substring(rezultat_comparatie.get(size-2).getPath2().lastIndexOf("\\")+1);
					if(nume2.length()>11)
					{
						nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
					}
					
					if(nume2_1.length()>11)
					{
						nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
					}
					w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-2).getRezultat()));
					w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
					//w2.getPaneTextTitlu2_1().setText(nume2_1);
					
					w2.setImage(rezultat_comparatie.get(size-3).getPath1(), w2.getLabel3());
					w2.setImage(rezultat_comparatie.get(size-3).getPath2(), w2.getLabel3_1());
					w2.setImage(rezultat_comparatie.get(size-3).getImagine(), w2.rezultat3());
					String nume3 = rezultat_comparatie.get(size-3).getPath1().substring(rezultat_comparatie.get(size-3).getPath1().lastIndexOf("\\")+1);
					String nume3_1 = rezultat_comparatie.get(size-3).getPath2().substring(rezultat_comparatie.get(size-3).getPath2().lastIndexOf("\\")+1);
					if(nume3.length()>11)
					{
						nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
					}
					
					if(nume3_1.length()>11)
					{
						nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
					}
					w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-3).getRezultat()));
					w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
					//w2.getPaneTextTitlu3_1().setText(nume3_1);
					
					w2.setImage(rezultat_comparatie.get(size-4).getPath1(), w2.getLabel4());
					w2.setImage(rezultat_comparatie.get(size-4).getPath2(), w2.getLabel4_1());
					w2.setImage(rezultat_comparatie.get(size-4).getImagine(), w2.rezultat4());
					String nume4 = rezultat_comparatie.get(size-4).getPath1().substring(rezultat_comparatie.get(size-4).getPath1().lastIndexOf("\\")+1);
					String nume4_1 = rezultat_comparatie.get(size-4).getPath2().substring(rezultat_comparatie.get(size-4).getPath2().lastIndexOf("\\")+1);
					if(nume4.length()>11)
					{
						nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
					}
					
					if(nume4_1.length()>11)
					{
						nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
					}
					w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-4).getRezultat()));
					w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
					//w2.getPaneTextTitlu4_1().setText(nume4_1);
					
					w2.setImage(rezultat_comparatie.get(size-5).getPath1(), w2.getLabel5());
					w2.setImage(rezultat_comparatie.get(size-5).getPath2(), w2.getLabel5_1());
					w2.setImage(rezultat_comparatie.get(size-5).getImagine(), w2.rezultat5());
					String nume5 = rezultat_comparatie.get(size-5).getPath1().substring(rezultat_comparatie.get(size-5).getPath1().lastIndexOf("\\")+1);
					String nume5_1 = rezultat_comparatie.get(size-5).getPath2().substring(rezultat_comparatie.get(size-5).getPath2().lastIndexOf("\\")+1);
					if(nume5.length()>11)
					{
						nume5 = nume5.substring(0, Math.min(nume5.length(), 10))+"...";
					}
					
					if(nume5_1.length()>11)
					{
						nume5_1 = nume5_1.substring(0, Math.min(nume5_1.length(), 10))+"...";
					}
					w2.getPaneRezultat5().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-5).getRezultat()));
					w2.getPaneTextTitlu5().setText("FIFTH PAIR : "+nume5+"\n"+nume5_1);
					//w2.getPaneTextTitlu5_1().setText(nume5_1);
					
					w2.setImage(rezultat_comparatie.get(size-6).getPath1(), w2.getLabel6());
					w2.setImage(rezultat_comparatie.get(size-6).getPath2(), w2.getLabel6_1());
					w2.setImage(rezultat_comparatie.get(size-6).getImagine(), w2.rezultat6());
					String nume6 = rezultat_comparatie.get(size-6).getPath1().substring(rezultat_comparatie.get(size-6).getPath1().lastIndexOf("\\")+1);
					String nume6_1 = rezultat_comparatie.get(size-6).getPath2().substring(rezultat_comparatie.get(size-6).getPath2().lastIndexOf("\\")+1);
					if(nume6.length()>11)
					{
						nume6 = nume6.substring(0, Math.min(nume6.length(), 10))+"...";
					}
					
					if(nume6_1.length()>11)
					{
						nume6_1 = nume6_1.substring(0, Math.min(nume6_1.length(), 10))+"...";
					}
					w2.getPaneRezultat6().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-6).getRezultat()));
					w2.getPaneTextTitlu6().setText("SIXTH PAIR : "+nume6+"\n"+nume6_1);
					//w2.getPaneTextTitlu6_1().setText(nume6_1);
				
				
				}
				
				else if (rezultat_comparatie.size() == 5 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.setImage(rezultat_comparatie.get(size-2).getPath1(), w2.getLabel2());
					w2.setImage(rezultat_comparatie.get(size-2).getPath2(), w2.getLabel2_1());
					w2.setImage(rezultat_comparatie.get(size-2).getImagine(), w2.rezultat2());
					String nume2 = rezultat_comparatie.get(size-2).getPath1().substring(rezultat_comparatie.get(size-2).getPath1().lastIndexOf("\\")+1);
					String nume2_1 = rezultat_comparatie.get(size-2).getPath2().substring(rezultat_comparatie.get(size-2).getPath2().lastIndexOf("\\")+1);
					if(nume2.length()>11)
					{
						nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
					}
					
					if(nume2_1.length()>11)
					{
						nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
					}
					w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-2).getRezultat()));
					w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
					//w2.getPaneTextTitlu2_1().setText(nume2_1);
					
					w2.setImage(rezultat_comparatie.get(size-3).getPath1(), w2.getLabel3());
					w2.setImage(rezultat_comparatie.get(size-3).getPath2(), w2.getLabel3_1());
					w2.setImage(rezultat_comparatie.get(size-3).getImagine(), w2.rezultat3());
					String nume3 = rezultat_comparatie.get(size-3).getPath1().substring(rezultat_comparatie.get(size-3).getPath1().lastIndexOf("\\")+1);
					String nume3_1 = rezultat_comparatie.get(size-3).getPath2().substring(rezultat_comparatie.get(size-3).getPath2().lastIndexOf("\\")+1);
					if(nume3.length()>11)
					{
						nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
					}
					
					if(nume3_1.length()>11)
					{
						nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
					}
					w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-3).getRezultat()));
					w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
					//w2.getPaneTextTitlu3_1().setText(nume3_1);
					
					w2.setImage(rezultat_comparatie.get(size-4).getPath1(), w2.getLabel4());
					w2.setImage(rezultat_comparatie.get(size-4).getPath2(), w2.getLabel4_1());
					w2.setImage(rezultat_comparatie.get(size-4).getImagine(), w2.rezultat4());
					String nume4 = rezultat_comparatie.get(size-4).getPath1().substring(rezultat_comparatie.get(size-4).getPath1().lastIndexOf("\\")+1);
					String nume4_1 = rezultat_comparatie.get(size-4).getPath2().substring(rezultat_comparatie.get(size-4).getPath2().lastIndexOf("\\")+1);
					if(nume4.length()>11)
					{
						nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
					}
					
					if(nume4_1.length()>11)
					{
						nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
					}
					w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-4).getRezultat()));
					w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
					//w2.getPaneTextTitlu4_1().setText(nume4_1);
					
					w2.setImage(rezultat_comparatie.get(size-5).getPath1(), w2.getLabel5());
					w2.setImage(rezultat_comparatie.get(size-5).getPath2(), w2.getLabel5_1());
					w2.setImage(rezultat_comparatie.get(size-5).getImagine(), w2.rezultat5());
					String nume5 = rezultat_comparatie.get(size-5).getPath1().substring(rezultat_comparatie.get(size-5).getPath1().lastIndexOf("\\")+1);
					String nume5_1 = rezultat_comparatie.get(size-5).getPath2().substring(rezultat_comparatie.get(size-5).getPath2().lastIndexOf("\\")+1);
					if(nume5.length()>11)
					{
						nume5 = nume5.substring(0, Math.min(nume5.length(), 10))+"...";
					}
					
					if(nume5_1.length()>11)
					{
						nume5_1 = nume5_1.substring(0, Math.min(nume5_1.length(), 10))+"...";
					}
					w2.getPaneRezultat5().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-5).getRezultat()));
					w2.getPaneTextTitlu5().setText("FIFTH PAIR : "+nume5+"\n"+nume5_1);
					//w2.getPaneTextTitlu5_1().setText(nume5_1);
					
					
				
					w2.getLabel6().setVisible(false);
					w2.getLabel6_1().setVisible(false);
					
					w2.getPaneTextTitlu6().setVisible(false);
				
					w2.getLabel6_big().setVisible(false);
				
					w2.rezultat6().setVisible(false);
					
					w2.getPaneRezultat6().setVisible(false);
				}
				
				else if (rezultat_comparatie.size() == 4 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.setImage(rezultat_comparatie.get(size-2).getPath1(), w2.getLabel2());
					w2.setImage(rezultat_comparatie.get(size-2).getPath2(), w2.getLabel2_1());
					w2.setImage(rezultat_comparatie.get(size-2).getImagine(), w2.rezultat2());
					String nume2 = rezultat_comparatie.get(size-2).getPath1().substring(rezultat_comparatie.get(size-2).getPath1().lastIndexOf("\\")+1);
					String nume2_1 = rezultat_comparatie.get(size-2).getPath2().substring(rezultat_comparatie.get(size-2).getPath2().lastIndexOf("\\")+1);
					if(nume2.length()>11)
					{
						nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
					}
					
					if(nume2_1.length()>11)
					{
						nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
					}
					w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-2).getRezultat()));
					w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
					//w2.getPaneTextTitlu2_1().setText(nume2_1);
					
					w2.setImage(rezultat_comparatie.get(size-3).getPath1(), w2.getLabel3());
					w2.setImage(rezultat_comparatie.get(size-3).getPath2(), w2.getLabel3_1());
					w2.setImage(rezultat_comparatie.get(size-3).getImagine(), w2.rezultat3());
					String nume3 = rezultat_comparatie.get(size-3).getPath1().substring(rezultat_comparatie.get(size-3).getPath1().lastIndexOf("\\")+1);
					String nume3_1 = rezultat_comparatie.get(size-3).getPath2().substring(rezultat_comparatie.get(size-3).getPath2().lastIndexOf("\\")+1);
					if(nume3.length()>11)
					{
						nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
					}
					
					if(nume3_1.length()>11)
					{
						nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
					}
					w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-3).getRezultat()));
					w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
					//w2.getPaneTextTitlu3_1().setText(nume3_1);
					
					w2.setImage(rezultat_comparatie.get(size-4).getPath1(), w2.getLabel4());
					w2.setImage(rezultat_comparatie.get(size-4).getPath2(), w2.getLabel4_1());
					w2.setImage(rezultat_comparatie.get(size-4).getImagine(), w2.rezultat4());
					String nume4 = rezultat_comparatie.get(size-4).getPath1().substring(rezultat_comparatie.get(size-4).getPath1().lastIndexOf("\\")+1);
					String nume4_1 = rezultat_comparatie.get(size-4).getPath2().substring(rezultat_comparatie.get(size-4).getPath2().lastIndexOf("\\")+1);
					if(nume4.length()>11)
					{
						nume4 = nume4.substring(0, Math.min(nume4.length(), 10))+"...";
					}
					
					if(nume4_1.length()>11)
					{
						nume4_1 = nume4_1.substring(0, Math.min(nume4_1.length(), 10))+"...";
					}
					w2.getPaneRezultat4().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-4).getRezultat()));
					w2.getPaneTextTitlu4().setText("FOURTH PAIR : "+nume4+"\n"+nume4_1);
					//w2.getPaneTextTitlu4_1().setText(nume4_1);
					
				
					w2.getLabel5().setVisible(false);
					w2.getLabel5_1().setVisible(false);
					w2.getLabel6().setVisible(false);
					w2.getLabel6_1().setVisible(false);
					
					w2.getPaneTextTitlu6().setVisible(false);
					w2.getPaneTextTitlu5().setVisible(false);
	
					w2.getLabel6_big().setVisible(false);
					w2.getLabel5_big().setVisible(false);
					
					w2.rezultat6().setVisible(false);
					w2.rezultat5().setVisible(false);
					
					w2.getPaneRezultat6().setVisible(false);
					w2.getPaneRezultat5().setVisible(false);
			
					
				}
				
				else if (rezultat_comparatie.size() == 3 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.setImage(rezultat_comparatie.get(size-2).getPath1(), w2.getLabel2());
					w2.setImage(rezultat_comparatie.get(size-2).getPath2(), w2.getLabel2_1());
					w2.setImage(rezultat_comparatie.get(size-2).getImagine(), w2.rezultat2());
					String nume2 = rezultat_comparatie.get(size-2).getPath1().substring(rezultat_comparatie.get(size-2).getPath1().lastIndexOf("\\")+1);
					String nume2_1 = rezultat_comparatie.get(size-2).getPath2().substring(rezultat_comparatie.get(size-2).getPath2().lastIndexOf("\\")+1);
					if(nume2.length()>11)
					{
						nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
					}
					
					if(nume2_1.length()>11)
					{
						nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
					}
					w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-2).getRezultat()));
					w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
					//w2.getPaneTextTitlu2_1().setText(nume2_1);
					
					w2.setImage(rezultat_comparatie.get(size-3).getPath1(), w2.getLabel3());
					w2.setImage(rezultat_comparatie.get(size-3).getPath2(), w2.getLabel3_1());
					w2.setImage(rezultat_comparatie.get(size-3).getImagine(), w2.rezultat3());
					String nume3 = rezultat_comparatie.get(size-3).getPath1().substring(rezultat_comparatie.get(size-3).getPath1().lastIndexOf("\\")+1);
					String nume3_1 = rezultat_comparatie.get(size-3).getPath2().substring(rezultat_comparatie.get(size-3).getPath2().lastIndexOf("\\")+1);
					if(nume3.length()>11)
					{
						nume3 = nume3.substring(0, Math.min(nume3.length(), 10))+"...";
					}
					
					if(nume3_1.length()>11)
					{
						nume3_1 = nume3_1.substring(0, Math.min(nume3_1.length(), 10))+"...";
					}
					w2.getPaneRezultat3().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-3).getRezultat()));
					w2.getPaneTextTitlu3().setText("THIRD PAIR : "+nume3+"\n"+nume3_1);
					//w2.getPaneTextTitlu3_1().setText(nume3_1);
					
					
				
					w2.getLabel4().setVisible(false);
					w2.getLabel4_1().setVisible(false);
					w2.getLabel5().setVisible(false);
					w2.getLabel5_1().setVisible(false);
					w2.getLabel6().setVisible(false);
					w2.getLabel6_1().setVisible(false);
					
					w2.getPaneTextTitlu6().setVisible(false);
					w2.getPaneTextTitlu5().setVisible(false);
					w2.getPaneTextTitlu4().setVisible(false);
				
					
					
					w2.getLabel6_big().setVisible(false);
					w2.getLabel5_big().setVisible(false);
					w2.getLabel4_big().setVisible(false);
					
					
					w2.rezultat6().setVisible(false);
					w2.rezultat5().setVisible(false);
					w2.rezultat4().setVisible(false);
					
					w2.getPaneRezultat6().setVisible(false);
					w2.getPaneRezultat5().setVisible(false);
					w2.getPaneRezultat4().setVisible(false);
				
				}
				
				else if (rezultat_comparatie.size() == 2 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.setImage(rezultat_comparatie.get(size-2).getPath1(), w2.getLabel2());
					w2.setImage(rezultat_comparatie.get(size-2).getPath2(), w2.getLabel2_1());
					w2.setImage(rezultat_comparatie.get(size-2).getImagine(), w2.rezultat2());
					String nume2 = rezultat_comparatie.get(size-2).getPath1().substring(rezultat_comparatie.get(size-2).getPath1().lastIndexOf("\\")+1);
					String nume2_1 = rezultat_comparatie.get(size-2).getPath2().substring(rezultat_comparatie.get(size-2).getPath2().lastIndexOf("\\")+1);
					if(nume2.length()>11)
					{
						nume2 = nume2.substring(0, Math.min(nume2.length(), 10))+"...";
					}
					
					if(nume2_1.length()>11)
					{
						nume2_1 = nume2_1.substring(0, Math.min(nume2_1.length(), 10))+"...";
					}
					w2.getPaneRezultat2().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-2).getRezultat()));
					w2.getPaneTextTitlu2().setText("SECOND PAIR : "+nume2+"\n"+nume2_1);
					//w2.getPaneTextTitlu2_1().setText(nume2_1);
					
					
				
					w2.getLabel3().setVisible(false);
					w2.getLabel3_1().setVisible(false);
					w2.getLabel4().setVisible(false);
					w2.getLabel4_1().setVisible(false);
					w2.getLabel5().setVisible(false);
					w2.getLabel5_1().setVisible(false);
					w2.getLabel6().setVisible(false);
					w2.getLabel6_1().setVisible(false);
					
					w2.getPaneTextTitlu6().setVisible(false);
					w2.getPaneTextTitlu5().setVisible(false);
					w2.getPaneTextTitlu4().setVisible(false);
					w2.getPaneTextTitlu3().setVisible(false);
				
	
					w2.getLabel6_big().setVisible(false);
					w2.getLabel5_big().setVisible(false);
					w2.getLabel4_big().setVisible(false);
					w2.getLabel3_big().setVisible(false);
					
					
					w2.rezultat6().setVisible(false);
					w2.rezultat5().setVisible(false);
					w2.rezultat4().setVisible(false);
					w2.rezultat3().setVisible(false);
					
					
					w2.getPaneRezultat6().setVisible(false);
					w2.getPaneRezultat5().setVisible(false);
					w2.getPaneRezultat4().setVisible(false);
					w2.getPaneRezultat3().setVisible(false);
					
					

				}
				
				else if (rezultat_comparatie.size() == 1 )
				{
					Window2 w2 = new Window2();
					w2.setVisible(true);
					w2.setFrame();
					w2.getPaneText().setText(titlu_w2);
					
					w2.setImage(rezultat_comparatie.get(size-1).getPath1(), w2.getLabel1());
					w2.setImage(rezultat_comparatie.get(size-1).getPath2(), w2.getLabel1_1());
					w2.setImage(rezultat_comparatie.get(size-1).getImagine(), w2.rezultat1());
					String nume1 = rezultat_comparatie.get(size-1).getPath1().substring(rezultat_comparatie.get(size-1).getPath1().lastIndexOf("\\")+1);
					String nume1_1 = rezultat_comparatie.get(size-1).getPath2().substring(rezultat_comparatie.get(size-1).getPath2().lastIndexOf("\\")+1);
					if(nume1.length()>11)
					{
						nume1 = nume1.substring(0, Math.min(nume1.length(), 10))+"...";
					}
					
					if(nume1_1.length()>11)
					{
						nume1_1 = nume1_1.substring(0, Math.min(nume1_1.length(), 10))+"...";
					}
					w2.getPaneRezultat1().setText("RESULT : "+"\n"+ String.format("%.2f",rezultat_comparatie.get(size-1).getRezultat()));
					w2.getPaneTextTitlu1().setText("FIRST PAIR : "+(nume1+"\n"+nume1_1));
					//w2.getPaneTextTitlu1_1().setText(nume1_1);
					
					
					w2.getLabel2().setVisible(false);
					w2.getLabel2_1().setVisible(false);
					w2.getLabel3().setVisible(false);
					w2.getLabel3_1().setVisible(false);
					w2.getLabel4().setVisible(false);
					w2.getLabel4_1().setVisible(false);
					w2.getLabel5().setVisible(false);
					w2.getLabel5_1().setVisible(false);
					w2.getLabel6().setVisible(false);
					w2.getLabel6_1().setVisible(false);
					
					w2.getPaneTextTitlu6().setVisible(false);
					w2.getPaneTextTitlu5().setVisible(false);
					w2.getPaneTextTitlu4().setVisible(false);
					w2.getPaneTextTitlu3().setVisible(false);
					w2.getPaneTextTitlu2().setVisible(false);
					
					
					w2.getLabel6_big().setVisible(false);
					w2.getLabel5_big().setVisible(false);
					w2.getLabel4_big().setVisible(false);
					w2.getLabel3_big().setVisible(false);
					w2.getLabel2_big().setVisible(false);
					
					
					
					w2.rezultat6().setVisible(false);
					w2.rezultat5().setVisible(false);
					w2.rezultat4().setVisible(false);
					w2.rezultat3().setVisible(false);
					w2.rezultat2().setVisible(false);
					
					
					w2.getPaneRezultat6().setVisible(false);
					w2.getPaneRezultat5().setVisible(false);
					w2.getPaneRezultat4().setVisible(false);
					w2.getPaneRezultat3().setVisible(false);
					w2.getPaneRezultat2().setVisible(false);
				}
				
				else 
				{
					Img2Label.setText("The Images Should Have the Same Dimension !");
					Img1Label.setText("The Images Should Have the Same Dimension !");
					
					
					StyleConstants.setForeground(attribs, Color.red);
				
					
					Img2Label.setParagraphAttributes(attribs, true);
					Img1Label.setParagraphAttributes(attribs, true);
				
				}
				
			}
			
			}
			
			}

	
		});

writeCsv(rezultat_comparatie);


SimpleAttributeSet atr = new SimpleAttributeSet();
StyleConstants.setFontSize(atr, 14);
StyleConstants.setAlignment(atr, StyleConstants.ALIGN_CENTER);
StyleConstants.setBold(atr, true);
StyleConstants.setForeground(atr, Color.red);

		
		
Dir1Select.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				

				
				if(openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
					
					{
						   Folder1 = new File (openFileChooser.getSelectedFile().getAbsolutePath());
						   
						   Path path = Paths.get(Folder1.getAbsolutePath());
						   Path fileName = path.getFileName(); 
						   
						   
						   File[] listOfFiles = Folder1.listFiles();

						   for (File file : listOfFiles) 
							   {
							   	
							   		String name = file.getAbsolutePath();
							   	
							   		String extension = name.toString().toLowerCase(); //endsWith
							   	

								   		if(extension.endsWith(".jpeg") || extension.endsWith(".jpg") || extension.endsWith(".png"))
								   			{
									   				
									   				ImageList1.add(name);
									   				
									   		}
							   			
							   			else 
							   			{ 
							   				continue;
							   				
							   			}
							   }
						   
						  if (ImageList1.size()==0)
													   
							   {
								   Img1Label.setText("No image found in :" + "\n" + fileName.toString()+"\n"+"Please select another directory !");
								   Img1Label.setParagraphAttributes(atr, true);
							   }
						  
						  else 
				   			{	
							  	delete1.setVisible(true);
				   				Img1Label.setText("Images Loaded From " +"'" + fileName + "'" + " :");
				   				
				   				BufferedImage image1 = null;
				   				BufferedImage image2 = null;
				   				BufferedImage image3 = null;
				   				
				   				
				   				img1.setBounds(10, 152, 56, 214);
				   				
					   			if(ImageList1.size()>=3) {
					   				
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList1.get(0)));
					   				    image2 = ImageIO.read(new File(ImageList1.get(1)));
					   				    image3 = ImageIO.read(new File(ImageList1.get(2)));
					   				   
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1.getWidth(), img1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg2 = image2.getScaledInstance(img2.getWidth(), img2.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg3 = image3.getScaledInstance(img3.getWidth(), img3.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				
					   				img1.setIcon(new ImageIcon(dimg));
					   				img2.setIcon(new ImageIcon(dimg2));
					   				img3.setIcon(new ImageIcon(dimg3));
					   				img4.setText(" + " + (ImageList1.size()-3) );
					   				
					   				img2.setVisible(true);
					   				img3.setVisible(true);
					   				img4.setVisible(true);
					   				
					   				
									StyleConstants.setForeground(attribs, Color.BLACK);
									Img1Label.setParagraphAttributes(attribs, true);
					   				}
					   			
					   			
					   			else if(ImageList1.size()==2)
					   			{
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList1.get(0)));
					   				    image2 = ImageIO.read(new File(ImageList1.get(1)));
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1.getWidth(), img1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg2 = image2.getScaledInstance(img2.getWidth(), img2.getHeight(),
					   				        Image.SCALE_SMOOTH);

					   				
					   				img1.setIcon(new ImageIcon(dimg));
					   				img2.setIcon(new ImageIcon(dimg2));
					   				img3.setText(" + 0 ");
					   			
					   				img2.setVisible(true);
					   				img3.setVisible(true);
					   				
					   				StyleConstants.setForeground(attribs, Color.BLACK);
									Img1Label.setParagraphAttributes(attribs, true);
					   				
					   			}
					   			
					   			
					   			else if(ImageList1.size()==1)
					   			{
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList1.get(0)));
					   				   
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1.getWidth(), img1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   			

					   				
					   				img1.setIcon(new ImageIcon(dimg));
					   				img2.setText(" + 0 ");
					   				
					   				img2.setVisible(true);
					   				
					   				StyleConstants.setForeground(attribs, Color.BLACK);
									Img1Label.setParagraphAttributes(attribs, true);
					   				
					   		
					   			}
				   				
				   			}
					}
					
				
				    else 
					    	{
				    			Img1Label.setText("No directory choosed ! ");
					    	}
			
			}
		});
		

Dir2Select.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
	
					
					if(openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
						
					{ 
					  
						   Folder2 = new File (openFileChooser.getSelectedFile().getAbsolutePath());
						   
						   File[] listOfFiles = Folder2.listFiles();
						   
						   Path path = Paths.get(Folder2.getAbsolutePath());
						   
						   Path fileName = path.getFileName();

						   for (File file : listOfFiles) 
						   {
							   	
						   		String name = file.getAbsolutePath();
						   	
						   		String extension = name.toString().toLowerCase(); //endsWith(".java");
						   	

							   		if(extension.endsWith(".jpg") || extension.endsWith(".jpeg") || extension.endsWith(".png"))
							   			{
								   				
								   				ImageList2.add(name);
								   				
								   		}
						   			
						   			else 
						   			{ 
						   				continue;
						   				
						   			}
						   }
					   
						   
						   
						   if (ImageList2.size()==0)
							   
						   {
							   Img2Label.setText("No image found in : " + "\n"+ fileName.toString() + "\n" + "Please select another directory!");
							  
							   Img2Label.setParagraphAttributes(atr, true);
						   }
						   
						   else 
				   			{	delete2.setVisible(true);
							    Img2Label.setText("Images Loaded From " +"'" + fileName + "'" + " :");
							    
							    BufferedImage image1 = null;
				   				BufferedImage image2 = null;
				   				BufferedImage image3 = null;
				   				
				   				img1_1.setBounds(285, 151, 56, 215);
				   				
				   				
					   			if(ImageList2.size()>=3) {
					   				
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList2.get(0)));
					   				    image2 = ImageIO.read(new File(ImageList2.get(1)));
					   				    image3 = ImageIO.read(new File(ImageList2.get(2)));
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1_1.getWidth(), img1_1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg2 = image2.getScaledInstance(img2_1.getWidth(), img2_1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg3 = image3.getScaledInstance(img3_1.getWidth(), img3_1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				
					   				img1_1.setIcon(new ImageIcon(dimg));
					   				img2_1.setIcon(new ImageIcon(dimg2));
					   				img3_1.setIcon(new ImageIcon(dimg3));
					   				img4_1.setText(" + " + (ImageList2.size()-3) );
					   				
					   				img2_1.setVisible(true);
					   				img3_1.setVisible(true);
					   				img4_1.setVisible(true);
					   				
					   				StyleConstants.setForeground(attribs, Color.BLACK);
									Img2Label.setParagraphAttributes(attribs, true);
					   			
					   				}
					   			
					   			
					   			else if(ImageList2.size()==2)
					   			{
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList2.get(0)));
					   				    image2 = ImageIO.read(new File(ImageList2.get(1)));
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1_1.getWidth(), img1_1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   				Image dimg2 = image2.getScaledInstance(img2_1.getWidth(), img2_1.getHeight(),
					   				        Image.SCALE_SMOOTH);

					   				
					   				img1_1.setIcon(new ImageIcon(dimg));
					   				img2_1.setIcon(new ImageIcon(dimg2));
					   				img3_1.setText(" + 0 ");
					   				
					   				img2_1.setVisible(true);
					   				img3_1.setVisible(true);
					   				
					   				StyleConstants.setForeground(attribs, Color.BLACK);
									Img2Label.setParagraphAttributes(attribs, true);
					   			}
					   			
					   			
					   			else if(ImageList2.size()==1)
					   			{
					   				try {
					   				    image1 = ImageIO.read(new File(ImageList2.get(0)));
					   				   
					   				} catch (IOException e2) {
					   				    e2.printStackTrace();
					   				}
					   				
					   				Image dimg = image1.getScaledInstance(img1_1.getWidth(), img1_1.getHeight(),
					   				        Image.SCALE_SMOOTH);
					   			

					   				
					   				img1_1.setIcon(new ImageIcon(dimg));
					   				img2_1.setText(" + 0 ");
					   				img2_1.setVisible(true);
					   				
					   				StyleConstants.setForeground(attribs, Color.BLACK);
									Img2Label.setParagraphAttributes(attribs, true);
					   				
					   			}
							   
				   			}
					      
					} 
					
				    else 
					    	{
				    			Img2Label.setText("No directory choosed !");
					    	}
					
					
				
				}
			});
			

	}
	
	
	


protected ArrayList<Pereche> EuclidianDistance(ArrayList<String> imageList1,ArrayList<String> imageList2) throws Exception {
		
		ArrayList<Pereche> lista = new ArrayList<>();
		
		double rezultat;
		
		for(int i=0; i< imageList1.size();i++)
			{
				 
				BufferedImage img1 = null;
				
				File file =  new File(imageList1.get(i));
				
				try {
					
					img1 = ImageIO.read(file);
					
				}catch (Throwable e) {
					e.printStackTrace();
			     }
				
				
				 if(img1 == null)
				 {
					 continue;
				 }
			
				 else {
				
				  int latime1 = img1.getWidth();
			      int inaltime1 = img1.getHeight();
			      
			      for (int j=0; j<imageList2.size(); j++)
			      {
			    	  
			    	  	BufferedImage img2 = null;
			    	  	File file2 =  new File(imageList2.get(j));
						 
			    	  	try {
			    	  		
						 img2 = ImageIO.read(file2);
						 
			    	  	}catch (Throwable e){
			    	  		e.printStackTrace();
			    	  	}
			    	  
						 if(img2 == null)
						 {
							 continue;
						 }
						 
						 else {
			    	  
			    	  int latime2 = img2.getWidth();
			    	  int inaltime2 = img2.getHeight();
			    	 
			      
			     if ((latime1!=latime2) || (inaltime1!=inaltime2)) {
			    	 continue;
			      } 
			      
			      	else {
			      		
				         double diff = 0;
					         	
				         	for (int j2 = 0; j2 < inaltime1; j2++) {
				         		
					         		for (int i2 = 0; i2 < latime1; i2++) {
						              
						               
					         		   int pixel1 = img1.getRGB(i2, j2);
						               Color color1 = new Color(pixel1, true);
						               int r1 = color1.getRed();
						               int g1 = color1.getGreen();
						               int b1 = color1.getBlue();
						               
						               int pixel2 = img2.getRGB(i2, j2);
						               Color color2 = new Color(pixel2, true);
						               int r2 = color2.getRed();
						               int g2 = color2.getGreen();
						               int b2= color2.getBlue();
						               
						               //suma diferentelor valorilor rgb dintre doua imagini
						               double data = Math.sqrt(Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2));
						               
						               diff = diff+data;
						            }
					         }
			         
				     double medie = diff/(latime1*inaltime1*3);
				     rezultat = (medie/255)*100;
				    
				      Pereche p = new Pereche(imageList1.get(i),imageList2.get(j),rezultat,createImage(img1,img2));
				      lista.add(p);
				     
				    
			      }
			   }
			}
			      
		}
			
	}
		return lista;
	}
	

	
protected ArrayList<Pereche> EuclidianDistance2(ArrayList<String> imageList1,ArrayList<String> imageList2) throws Exception {
		
		ArrayList<Pereche> lista = new ArrayList<>();
		
		double rezultat;
		
		int i=0;
		
		int limit = 0;
		
		if(imageList1.size() > imageList2.size())
			limit=imageList2.size();
		else if(imageList1.size() < imageList2.size())
			limit = imageList1.size();
		else
			limit = imageList1.size();
		
		
			for(i=0;i<limit;i++)
			{
				
					 	BufferedImage img2 = null;
			    	  	BufferedImage img1 = null;
			    	  	
			    	  	File file =  new File(imageList1.get(i));
			    	  	File file2 =  new File(imageList2.get(i));
			    	  	
			    	  	try {
			    	  	
			    	  	 img1 = ImageIO.read(file);
						 img2 = ImageIO.read(file2);
						 
						 
			    	  	}catch (Throwable e){
			    	  		e.printStackTrace();
			    	  	}
			    	  
				if(img1 == null || img2==null)
				{
					continue;
				}
				
				else
				{
					  int latime1 = img1.getWidth();
				      int inaltime1 = img1.getHeight();
				      
				      int latime2 = img2.getWidth();
			    	  int inaltime2 = img2.getHeight();
	
		 
			     if ((latime1 != latime2) || (inaltime1 != inaltime2)) {
			    	 continue;
			      } 
			      
			      	else {
			      		
				         double diff = 0;
					         	
				         	for (int j2 = 0; j2 < inaltime1; j2++) {
				         		
					         		for (int i2 = 0; i2 < latime1; i2++) {
						              
						               
					         		   int pixel1 = img1.getRGB(i2, j2);
						               Color color1 = new Color(pixel1, true);
						               int r1 = color1.getRed();
						               int g1 = color1.getGreen();
						               int b1 = color1.getBlue();
						               
						               int pixel2 = img2.getRGB(i2, j2);
						               Color color2 = new Color(pixel2, true);
						               int r2 = color2.getRed();
						               int g2 = color2.getGreen();
						               int b2= color2.getBlue();
						               
						             //suma diferentelor valorilor rgb dintre doua imagini
						               double data = Math.sqrt(Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2));
						               
						               diff = diff+data;
						            }
					         }
			         
				     double medie = diff/(latime1*inaltime1*3);
				     rezultat = (medie/255)*100;
				    
				      Pereche p = new Pereche(imageList1.get(i),imageList2.get(i),rezultat,createImage(img1,img2));
				      lista.add(p);
				     
				    
			      }
				}
		
		}
	
		return lista;
	}




protected ArrayList<Pereche> ManhattanDistance(ArrayList<String> imageList1,ArrayList<String> imageList2) throws Exception {
		
		ArrayList<Pereche> lista = new ArrayList<>();
		
		double rezultat;
		
		int limit = 0;
		
		if(imageList1.size() > imageList2.size())
			limit=imageList2.size();
		else if(imageList1.size() < imageList2.size())
			limit = imageList1.size();
		else
			limit = imageList1.size();
		
		
		for(int i=0; i < limit;i++)
			{
				 
				BufferedImage img1 = null;
	    	  	BufferedImage img2 = null;
	    	  	
	    	  	
	    	  	File file =  new File(imageList1.get(i));
	    	  	File file2 =  new File(imageList2.get(i));
				
				
				try {
				 img1 = ImageIO.read(file);
				 img2 = ImageIO.read(file2);
				 
				}catch (Throwable e) {
					e.printStackTrace();
			     }
	
				 if(img1 == null || img2==null)
				 {
					 continue;
				 }
			
				 else {
				
				  int latime1 = img1.getWidth();
			      int inaltime1 = img1.getHeight();
			      
			      int latime2 = img2.getWidth();
		    	  int inaltime2 = img2.getHeight();
				 
				 
			     if ((latime1!=latime2) || (inaltime1!=inaltime2)) {
			    	 continue;
			      } 
			      
			      	else {
			      		
				         double diff = 0;
					         	
				         	for (int j2 = 0; j2 < inaltime1; j2++) {
				         		
					         		for (int i2 = 0; i2 < latime1; i2++) {
						              
						               
					         		   int pixel1 = img1.getRGB(i2, j2);
						               Color color1 = new Color(pixel1, true);
						               int r1 = color1.getRed();
						               int g1 = color1.getGreen();
						               int b1 = color1.getBlue();
						               
						               int pixel2 = img2.getRGB(i2, j2);
						               Color color2 = new Color(pixel2, true);
						               int r2 = color2.getRed();
						               int g2 = color2.getGreen();
						               int b2= color2.getBlue();
						               
						             //suma diferentelor valorilor rgb dintre doua imagini
						               
						               double data = Math.abs(r1-r2)+Math.abs(g1-g2)+Math.abs(b1-b2);
						               
						               diff = diff+data;
						            }
					         }
			         
				     double medie = diff/(latime1*inaltime1*3);
				     rezultat = (medie/255)*100;
				    
				      Pereche p = new Pereche(imageList1.get(i),imageList2.get(i),rezultat,createImage(img1,img2));
				      lista.add(p);
				     
				    
			      }
			   }
			
			      
		}
			
	
		return lista;
	}


protected ArrayList<Pereche> ChebyshevDistance(ArrayList<String> imageList1,ArrayList<String> imageList2) throws Exception {
	
	ArrayList<Pereche> lista = new ArrayList<>();
	
	double rezultat;
	
	
	int limit = 0;
	
	if(imageList1.size() > imageList2.size())
		limit=imageList2.size();
	else if(imageList1.size() < imageList2.size())
		limit = imageList1.size();
	else
		limit = imageList1.size();
	
	
	for(int i=0; i < limit ;i++)
		{
			 
		BufferedImage img1 = null;
	  	BufferedImage img2 = null;
	  	
	  	
	  	File file =  new File(imageList1.get(i));
	  	File file2 =  new File(imageList2.get(i));
		
		
		try {
		 img1 = ImageIO.read(file);
		 img2 = ImageIO.read(file2);
		 
		}catch (Throwable e) {
			e.printStackTrace();
	     }

		 if(img1 == null || img2==null)
		 {
			 continue;
		 }
	
		 else {
		
		  int latime1 = img1.getWidth();
	      int inaltime1 = img1.getHeight();
	      
	      int latime2 = img2.getWidth();
    	  int inaltime2 = img2.getHeight();
		 
		 
	     if ((latime1!=latime2) || (inaltime1!=inaltime2)) {
	    	 continue;
	      } 
		      
		      	else {
		      		
			         double diff = 0;
				         	
			         	for (int j2 = 0; j2 < inaltime1; j2++) {
			         		
				         		for (int i2 = 0; i2 < latime1; i2++) {
					              
					               
				         		   int pixel1 = img1.getRGB(i2, j2);
					               Color color1 = new Color(pixel1, true);
					               int r1 = color1.getRed();
					               int g1 = color1.getGreen();
					               int b1 = color1.getBlue();
					               
					               int pixel2 = img2.getRGB(i2, j2);
					               Color color2 = new Color(pixel2, true);
					               int r2 = color2.getRed();
					               int g2 = color2.getGreen();
					               int b2= color2.getBlue();
					               
					               
					               double data = Math.max(Math.abs(r1-r2), Math.max(Math.abs(g1-g2),Math.abs(b1-b2)));
					              
					               
					               diff = diff+data;
					            }
				         }
		         
			         	double medie = diff/(latime1*inaltime1*3);
			         	rezultat = (medie/255)*100;
			    
			      Pereche p = new Pereche(imageList1.get(i),imageList2.get(i),rezultat,createImage(img1,img2));
			      lista.add(p);
			     
			    
		      }
		   }
		}
		      

	return lista;
}


public BufferedImage createImage(BufferedImage img1, BufferedImage img2)
{
	
	int inaltime = img1.getHeight();
	int latime = img1.getWidth();
	
	BufferedImage newImage= new BufferedImage(latime,inaltime,img1.getType());
	

	for (int j = 0; j < inaltime; j++) {
 		
 		for (int i = 0; i < latime; i++) {
          
			int pixel1 = img1.getRGB(i, j);
		    Color color1 = new Color(pixel1, true);
		    int r1 = color1.getRed();
		    int g1 = color1.getGreen();
		    int b1 = color1.getBlue();
		    
		    int pixel2 = img2.getRGB(i, j);
		    Color color2 = new Color(pixel2, true);
		    int r2 = color2.getRed();
		    int g2 = color2.getGreen();
		    int b2= color2.getBlue();
		    
		    Color c = new Color(Math.abs(r1-r2),Math.abs(g1-g2),Math.abs(b1-b2));
		    int rgb = c.getRGB();
		    newImage.setRGB(i, j, rgb);
		    
 		}
	}
	
	return newImage;

}

public void writeCsv(ArrayList<Pereche> lista)
{
	
	String newLine="\n";
	String titluCsv="Image1,Image2,Rezult,Path 1, Path 2";
	String pathCsv="src\\data\\rezult.csv";
	try 
	{
		FileWriter csvFile = new FileWriter(pathCsv);
		csvFile.append(titluCsv);
		csvFile.append(newLine);
		
		for(int i=0;i<lista.size();i++)
		{
			String name1 = lista.get(i).getPath1().substring(lista.get(i).getPath1().lastIndexOf("\\")+1);
			String name2 = lista.get(i).getPath2().substring(lista.get(i).getPath2().lastIndexOf("\\")+1);
			String path1 = lista.get(i).getPath1();
			String path2 = lista.get(i).getPath2();
			String rezultat = String.valueOf(lista.get(i).getRezultat());
			
			String string = name1 + "," + name2 + "," + rezultat + "," + path1 + "," + path2;
			csvFile.append(string);
			csvFile.append(newLine);
	
		}

		csvFile.flush();
		csvFile.close();
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	
}
	
	
	

}
