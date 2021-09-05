
import java.awt.image.BufferedImage;

public class Pereche implements Comparable<Pereche>{

	private String path1;
	private String path2;
	private BufferedImage imagine;
	private double rezultat;
	
	
	
	public Pereche(String cale1,String cale2, double rez,BufferedImage imagine)
	{
		this.path1=cale1;
		this.path2=cale2;
		this.imagine=imagine;
		this.rezultat=rez;
	}

	
	public BufferedImage getImagine()
	{
		return this.imagine;
	}
	
	public String getPath1()
	{
		return this.path1;
	}
	

	public String getPath2()
	{
		return this.path2;
	}
	
	

	public double getRezultat()
	{
		return this.rezultat;
	}
	
 public int compareTo(Pereche p1)
 {
	 if(this.getRezultat() < p1.getRezultat())
		 return -1;
	 else if (this.getRezultat() > p1.getRezultat())
		 return 1;
	 else return 0;
 }
	
	
}
