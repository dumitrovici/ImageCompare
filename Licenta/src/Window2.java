
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;


import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import javax.swing.border.Border;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Window2 {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Back");
	
	private JLabel Label1;
	private JLabel Label2;
	
	private JLabel Label3;
	private JLabel Label4;
	
	private JLabel Label5;
	private JLabel Label6;
	
	private JLabel Label1_1;
	private JLabel Label2_1;
	private JLabel Label3_1;
	private JLabel Label4_1;
	private JLabel Label5_1;
	private JLabel Label6_1;
	
	
	private JLabel Label1_big;
	private JLabel Label2_big;
	private JLabel Label3_big;
	private JLabel Label4_big;
	private JLabel Label5_big;
	private JLabel Label6_big;
	
	
	private JLabel rezultat1;
	private JLabel rezultat2;
	private JLabel rezultat3;
	private JLabel rezultat4;
	private JLabel rezultat5;
	private JLabel rezultat6;
	
	private JTextPane text;
	private JTextPane textSave;
	
	private JTextPane textTitlu1;
	private JTextPane textTitlu2;
	private JTextPane textTitlu3;
	private JTextPane textTitlu4;
	private JTextPane textTitlu5;
	private JTextPane textTitlu6;
	
	
	private JTextPane textRezultat1;
	private JTextPane textRezultat2;
	private JTextPane textRezultat3;
	private JTextPane textRezultat4;
	private JTextPane textRezultat5;
	private JTextPane textRezultat6;
	
	private JButton saveButton;
	

	public void setFrame()
	{
		this.frame.setLocationRelativeTo(null);
	}
	
	
	public void setVisible(boolean input){
	    frame.setVisible(input);
	}
	
	public void setImage(String path, JLabel j)
	{
		BufferedImage img1 = null;
		
		try {
				img1 = ImageIO.read(new File(path));
		} catch (Exception exce)
		{
			exce.printStackTrace();
		}
		
		Image dimg1 = img1.getScaledInstance(j.getWidth(), j.getHeight(),Image.SCALE_SMOOTH);
		j.setIcon(new ImageIcon(dimg1));
	}
	
	
	
	public void setImage(BufferedImage img, JLabel label)
	{
		Image imagine = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imagine));
	}
	
	
	
	public JLabel getLabel1_big()
	{
		return Label1_big;
	}
	
	public JLabel getLabel2_big()
	{
		return Label2_big;
	}
	
	public JLabel getLabel3_big()
	{
		return Label3_big;
	}
	
	public JLabel getLabel4_big()
	{
		return Label4_big;
	}
	
	public JLabel getLabel5_big()
	{
		return Label5_big;
	}
	
	public JLabel getLabel6_big()
	{
		return Label6_big;
	}
	
	
	public JLabel rezultat1()
	{
		return rezultat1;
	}
	
	public JLabel rezultat2()
	{
		return rezultat2;
	}
	
	
	public JLabel rezultat3()
	{
		return rezultat3;
	}
	
	public JLabel rezultat4()
	{
		return rezultat4;
	}
	
	public JLabel rezultat5()
	{
		return rezultat5;
	}
	
	
	public JLabel rezultat6()
	{
		return rezultat6;
	}
	
	
	
	

	
	
	
	

	public JLabel getLabel1()
	{
		return Label1;
	}
	
	public JLabel getLabel2()
	{
		return Label2;
	}
	
	public JLabel getLabel3()
	{
		return Label3;
	}
	
	public JLabel getLabel4()
	{
		return Label4;
	}
	
	public JLabel getLabel5()
	{
		return Label5;
	}
	
	public JLabel getLabel6()
	{
		return Label6;
	}
	
	public JLabel getLabel1_1()
	{
		return Label1_1;
	}
	
	public JLabel getLabel2_1()
	{
		return Label2_1;
	}
	

	public JLabel getLabel3_1()
	{
		return Label3_1;
	}
	
	public JLabel getLabel4_1()
	{
		return Label4_1;
	}
	
	public JLabel getLabel5_1()
	{
		return Label5_1;
	}
	
	public JLabel getLabel6_1()
	{
		return Label6_1;
	}
	
	public JTextPane getPaneText()
	{
		return text;
	}
	
	public JTextPane getPaneTextTitlu1()
	{
		return textTitlu1;
	}

	public JTextPane getPaneTextTitlu2()
	{
		return textTitlu2;
	}

	
	public JTextPane getPaneTextTitlu3()
	{
		return textTitlu3;
	}
	
	
	public JTextPane getPaneTextTitlu4()
	{
		return textTitlu4;
	}
	
	
	public JTextPane getPaneTextTitlu5()
	{
		return textTitlu5;
	}
	
	
	public JTextPane getPaneTextTitlu6()
	{
		return textTitlu6;
	}
	
	
	
	
	
	public JTextPane getPaneRezultat1()
	{
		return textRezultat1;
	}
	
	public JTextPane getPaneRezultat2()
	{
		return textRezultat2;
	}
	
	public JTextPane getPaneRezultat3()
	{
		return textRezultat3;
	}
	
	public JTextPane getPaneRezultat4()
	{
		return textRezultat4;
	}
	
	public JTextPane getPaneRezultat5()
	{
		return textRezultat5;
	}
	
	public JTextPane getPaneRezultat6()
	{
		return textRezultat6;
	}
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
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
	public Window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1084, 819);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//directory_interface d1 = new directory_interface();
				//d1.setVisible(true);
				frame.setVisible(false);
			
			
			}
		});
		
		btnNewButton.setBounds(23, 11, 120, 31);
		frame.getContentPane().add(btnNewButton);
		

		 Border border = BorderFactory.createLineBorder(Color.black, 2);
		 Border border2 = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
		
		Label1 = new JLabel("");
		Label1.setBounds(23, 162, 130, 165);
		Label1.setBorder(border);
		frame.getContentPane().add(Label1);
		
		Label2 = new JLabel("");
		Label2.setBounds(206, 162, 130, 165);
		Label2.setBorder(border);
		frame.getContentPane().add(Label2);
		
		Label3 = new JLabel("");
		Label3.setBounds(380, 162, 130, 165);
		Label3.setBorder(border);
		frame.getContentPane().add(Label3);
		
		Label4 = new JLabel("");
		Label4.setBounds(560, 162, 130, 165);
		Label4.setBorder(border);
		frame.getContentPane().add(Label4);
		
		Label5 = new JLabel("");
		Label5.setBounds(738, 162, 130, 165);
		Label5.setBorder(border);
		frame.getContentPane().add(Label5);
		
		Label6 = new JLabel("");
		Label6.setBounds(918, 162, 130, 165);
		Label6.setBorder(border);
		frame.getContentPane().add(Label6);
		
		Label1_1 = new JLabel("");
		Label1_1.setBounds(23, 348, 130, 165);
		Label1_1.setBorder(border);
		frame.getContentPane().add(Label1_1);
		
		Label2_1 = new JLabel("");
		Label2_1.setBounds(206, 348, 130, 165);
		Label2_1.setBorder(border);
		frame.getContentPane().add(Label2_1);
		
		Label3_1 = new JLabel("");
		Label3_1.setBounds(380, 348, 130, 165);
		Label3_1.setBorder(border);
		frame.getContentPane().add(Label3_1);
		
		Label4_1 = new JLabel("");
		Label4_1.setBounds(560, 348, 130, 165);
		Label4_1.setBorder(border);
		frame.getContentPane().add(Label4_1);
		
		Label5_1 = new JLabel("");
		Label5_1.setBounds(738, 348, 130, 165);
		Label5_1.setBorder(border);
		frame.getContentPane().add(Label5_1);
		
		Label6_1 = new JLabel("");
		Label6_1.setBounds(918, 348, 130, 165);
		Label6_1.setBorder(border);
		frame.getContentPane().add(Label6_1);
		
		
		Label1_big = new JLabel("");
		Label1_big.setBounds(10, 73, 159, 700);
		Label1_big.setBorder(border2);
		frame.getContentPane().add(Label1_big);
		
		
		Label2_big = new JLabel("");
		Label2_big.setBounds(190, 73, 159, 700);
		Label2_big.setBorder(border2);
		frame.getContentPane().add(Label2_big);
		
		Label3_big = new JLabel("");
		Label3_big.setBounds(368, 73, 159, 700);
		Label3_big.setBorder(border2);
		frame.getContentPane().add(Label3_big);
		
		
		Label4_big = new JLabel("");
		Label4_big.setBounds(545, 73, 159, 700);
		Label4_big.setBorder(border2);
		frame.getContentPane().add(Label4_big);
		
		
		Label5_big = new JLabel("");
		Label5_big.setBounds(724, 73, 159, 700);
		Label5_big.setBorder(border2);
		frame.getContentPane().add(Label5_big);
		
		
		Label6_big = new JLabel("");
		Label6_big.setBounds(905, 73, 159, 700);
		Label6_big.setBorder(border2);
		frame.getContentPane().add(Label6_big);
		
		
		
		
		text = new JTextPane();
		text.setBounds(171, 10, 492, 48);
		frame.getContentPane().add(text);
		text.setBackground(frame.getBackground());
		
		SimpleAttributeSet attribs3 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs3, StyleConstants.ALIGN_CENTER);
		StyleConstants.setBold(attribs3, true);
		StyleConstants.setFontSize(attribs3, 24);
		StyleConstants.setForeground(attribs3, Color.BLUE);
		StyleConstants.setFontFamily(attribs3, Font.MONOSPACED);
		text.setEditable(false);
		text.setParagraphAttributes(attribs3, true);
		frame.getContentPane().add(text);
		
		
		
	
		SimpleAttributeSet attrib = new SimpleAttributeSet();
		StyleConstants.setAlignment(attrib, StyleConstants.ALIGN_CENTER);
		StyleConstants.setBold(attrib, true);
		StyleConstants.setFontSize(attrib, 15);
		StyleConstants.setBackground(attrib, Color.WHITE);
		StyleConstants.setForeground(attrib, Color.BLUE);
		StyleConstants.setFontFamily(attrib, Font.MONOSPACED);
		
		SimpleAttributeSet attrib4 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attrib4, StyleConstants.ALIGN_CENTER);
		StyleConstants.setBold(attrib4, true);
		StyleConstants.setFontSize(attrib4, 15);
		StyleConstants.setBackground(attrib4, Color.WHITE);
		StyleConstants.setForeground(attrib4, Color.RED);
		StyleConstants.setFontFamily(attrib4, Font.MONOSPACED);
		
		
		textSave = new JTextPane();
		textSave.setBounds(754, 0, 306, 31);
		textSave.setText("Save the entire top as CSV File !");
		textSave.setParagraphAttributes(attrib4, true);
		textSave.setEditable(false);
		frame.getContentPane().add(textSave);
		textSave.setBackground(frame.getBackground());
		
		
		saveButton = new JButton("Save File");
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser chooser = new JFileChooser();
	
				chooser.setDialogTitle("Save a File ");
				chooser.setSelectedFile(new File("rezult.csv"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv", "CSV");
				chooser.setFileFilter(filter);
				int save = chooser.showSaveDialog(frame);
				
				
				if (save == JFileChooser.APPROVE_OPTION) {
	
					String dir = chooser.getSelectedFile().getAbsolutePath();
					Path p1 = Paths.get("src\\data\\rezult.csv");
					Path p2 = Paths.get(dir);
					
					 CopyOption[] options = new CopyOption[]{
				                StandardCopyOption.REPLACE_EXISTING,
				                StandardCopyOption.COPY_ATTRIBUTES
				        };
	
					try {
						Files.copy(p1, p2,options);
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
				  
				}
	
			}
		});
		
		
		
		saveButton.setBounds(859, 38, 141, 25);
		frame.getContentPane().add(saveButton);
		
		
		textTitlu1 = new JTextPane();
		textTitlu1.setBounds(23, 87, 130, 65);
		textTitlu1.setEditable(false);
		textTitlu1.setParagraphAttributes(attrib, true);
		textTitlu1.setBackground(frame.getBackground());
		textTitlu1.setBorder(border2);
		frame.getContentPane().add(textTitlu1);
		
		
		textTitlu2 = new JTextPane();
		textTitlu2.setBounds(206, 87, 130, 65);
		textTitlu2.setParagraphAttributes(attrib, true);
		textTitlu2.setEditable(false);
		textTitlu2.setBackground(frame.getBackground());
		textTitlu2.setBorder(border2);
		frame.getContentPane().add(textTitlu2);
		
		textTitlu3 = new JTextPane();
		textTitlu3.setBounds(380, 87, 130, 65);
		textTitlu3.setParagraphAttributes(attrib, true);
		textTitlu3.setBackground(frame.getBackground());
		textTitlu3.setBorder(border2);
		textTitlu3.setEditable(false);
		frame.getContentPane().add(textTitlu3);
		
		
		textTitlu4 = new JTextPane();
		textTitlu4.setBounds(560, 87, 130, 65);
		textTitlu4.setParagraphAttributes(attrib, true);
		textTitlu4.setBackground(frame.getBackground());
		textTitlu4.setBorder(border2);
		textTitlu4.setEditable(false);
		frame.getContentPane().add(textTitlu4);
		
		
		textTitlu5 = new JTextPane();
		textTitlu5.setBounds(738, 87, 130, 65);
		textTitlu5.setParagraphAttributes(attrib, true);
		textTitlu5.setBackground(frame.getBackground());
		textTitlu5.setBorder(border2);
		textTitlu5.setEditable(false);
		frame.getContentPane().add(textTitlu5);
		
		
		
		textTitlu6 = new JTextPane();
		textTitlu6.setBounds(918, 88, 130, 64);
		textTitlu6.setParagraphAttributes(attrib, true);
		textTitlu6.setBackground(frame.getBackground());
		textTitlu6.setBorder(border2);
		textTitlu6.setEditable(false);
		frame.getContentPane().add(textTitlu6);
		
		
		rezultat1 = new JLabel("");
		rezultat1.setBounds(23, 562, 130, 197);
		rezultat1.setBorder(border);
		frame.getContentPane().add(rezultat1);
		
		rezultat2 = new JLabel("");
		rezultat2.setBounds(206, 562, 130, 197);
		rezultat2.setBorder(border);
		frame.getContentPane().add(rezultat2);
		
		rezultat3 = new JLabel("");
		rezultat3.setBounds(380, 562, 130, 197);
		rezultat3.setBorder(border);
		frame.getContentPane().add(rezultat3);
		
		rezultat4 = new JLabel("");
		rezultat4.setBounds(560, 562, 130, 197);
		rezultat4.setBorder(border);
		frame.getContentPane().add(rezultat4);
		
		rezultat5 = new JLabel("");
		rezultat5.setBounds(738, 562, 130, 197);
		rezultat5.setBorder(border);
		frame.getContentPane().add(rezultat5);
		
		rezultat6 = new JLabel("");
		rezultat6.setBounds(918, 562, 130, 197);
		rezultat6.setBorder(border);
		frame.getContentPane().add(rezultat6);
		
		
		
		
		
		

		SimpleAttributeSet attribb = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribb, StyleConstants.ALIGN_CENTER);
		StyleConstants.setBold(attribb, true);
		StyleConstants.setFontSize(attribb, 13);
		StyleConstants.setBackground(attribb, Color.WHITE);
		StyleConstants.setForeground(attribb, Color.BLUE);
		StyleConstants.setFontFamily(attribb, Font.MONOSPACED);
		
		textRezultat1 = new JTextPane();
		textRezultat1.setBounds(23, 515, 130, 36);
		textRezultat1.setParagraphAttributes(attribb, true);
		textRezultat1.setBackground(frame.getBackground());
		textRezultat1.setEditable(false);
		frame.getContentPane().add(textRezultat1);
		
		
		textRezultat2 = new JTextPane();
		textRezultat2.setBounds(206, 515, 130, 36);
		textRezultat2.setParagraphAttributes(attribb, true);
		textRezultat2.setBackground(frame.getBackground());
		textRezultat2.setEditable(false);
		frame.getContentPane().add(textRezultat2);
		
		textRezultat3 = new JTextPane();
		textRezultat3.setBounds(380, 515, 130, 36);
		textRezultat3.setParagraphAttributes(attribb, true);
		textRezultat3.setBackground(frame.getBackground());
		textRezultat3.setEditable(false);
		frame.getContentPane().add(textRezultat3);
		
		textRezultat4 = new JTextPane();
		textRezultat4.setBounds(560, 515, 130, 36);
		textRezultat4.setParagraphAttributes(attribb, true);
		textRezultat4.setBackground(frame.getBackground());
		textRezultat4.setEditable(false);
		frame.getContentPane().add(textRezultat4);
		
		textRezultat5 = new JTextPane();
		textRezultat5.setBounds(738, 515, 130, 36);
		textRezultat5.setParagraphAttributes(attribb, true);
		textRezultat5.setBackground(frame.getBackground());
		textRezultat5.setEditable(false);
		frame.getContentPane().add(textRezultat5);
		
		textRezultat6 = new JTextPane();
		textRezultat6.setBounds(918, 515, 130, 36);
		textRezultat6.setParagraphAttributes(attribb, true);
		textRezultat6.setBackground(frame.getBackground());
		textRezultat6.setEditable(false);
		frame.getContentPane().add(textRezultat6);
		
	
		
		
		
	}
}
