/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutar;
/********************************************************************
*	El siguiente programa es un ejemplo bastante sencillo de 		*
*	impresión con JAVA. 											*
********************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
 
/********************************************************************
*	La siguiente clase llamada "Impresora", es la encargada de  	*
*	establecer la fuente con que se va a imprimir, de obtener el	*
*	trabajo de impresion, la página. En esta clase hay un método	*
*	llamado imprimir, el cual recibe una cadena y la imprime.		*
********************************************************************/
class Impresora
{
    Font fuente = new Font("Dialog", Font.PLAIN, 10);
	PrintJob pj;
	Graphics pagina;
 
 
	/********************************************************************
	*	A continuación el constructor de la clase. Aquí lo único que	*
	*	hago es tomar un objeto de impresion.							*
	********************************************************************/
	Impresora()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
	}
 
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
    public void imprimir(String Cadena)
	{
		//LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
		try
		{
			pagina = pj.getGraphics();
			pagina.setFont(fuente);
			pagina.setColor(Color.black);
 
			pagina.drawString(Cadena, 60, 60);
 
			pagina.dispose();
			pj.end();
		}catch(Exception e)
		{
			System.out.println("LA IMPRESION HA SIDO CANCELADA...");
		}
	}//FIN DEL PROCEDIMIENTO imprimir(String...)
 
 
}//FIN DE LA CLASE Impresora
 
 
 
//A CONTINUACION LA CLASE PRINCIPAL
public class Programa extends JFrame
{
	String cadena;
	JTextField campo;
	JButton imprimir;
	JLabel info;
	Impresora imp;
	JPanel principal = new JPanel(new BorderLayout());
	JPanel etiq = new JPanel(new FlowLayout());
	JPanel dos = new JPanel(new FlowLayout());
 
	//CONSTRUCTOR DE LA CLASE
	Programa()
	{
		super("Muestra Simple de Impresión en JAVA...");
 
		info = new JLabel("ESCRIBA ALGO EN EL CAMPO Y HAGA CLIC EN IMPRIMIR...");
		cadena = new String();
		campo = new JTextField(30);
		imprimir = new JButton("IMPRIMIR");
 
		dos.add(campo);
		dos.add(imprimir);
		etiq.add(info);
 
		campo.setToolTipText("ESCRIBA ALGO AQUÍ...");
		imprimir.setToolTipText("CLIC AQUI PARA IMPRIMIR...");
 
		principal.add(etiq, BorderLayout.NORTH);
		principal.add(dos, BorderLayout.CENTER);
 
		getContentPane().add(principal);
 
		//AJUSTO EL TAMAÑO DE LA VENTANA AL MINIMO
		pack();
		//NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
		this.setResizable(false);
 
		//AHORA LA CENTRARÉ EN LA PANTALLA
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
 
		this.setLocation(((pantalla.width - cuadro.width)/2),
						  (pantalla.height - cuadro.height)/2);
 
 
		//LE AGREGAMOS EL EVENTO AL BOTON "imprimir"
 
		imprimir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				cadena = "";
				cadena = String.valueOf(campo.getText());
				if (!cadena.equals(""))
				{
					imp = new Impresora();
					imp.imprimir(cadena);
				}
				else System.out.println("NO SE IMPRIME NADA EN BLANCO...");
 
				campo.requestFocus();
				campo.select(0, cadena.length());
			}
		});
 
 
 
	}//FIN DEL CONSTRUCTOR
 
	public static void main(String jm[])
	{
		Programa p = new Programa();
		p.show();
 
		p.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});
	}//FIN DEL MAIN
 
 
}//FIN DE LA CLASE PRINCIPAL
