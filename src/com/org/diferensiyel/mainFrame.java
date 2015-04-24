package com.org.diferensiyel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class mainFrame extends JFrame
{

	private JLabel lblFunc;
	private JLabel lblPar;
	private JTextField txtVar;
	private JButton btnAdd;
	private JPanel pnlControl;
	private drawingSpace pnlDraw;
	private JPanel pnlLabel;
	private JPanel pnlComp;
	private FlowLayout lytFlow;
	
	mainFrame()
	{
		lytFlow = new FlowLayout();
		pnlComp = new JPanel(new BorderLayout());
		pnlLabel = new JPanel();
		pnlControl = new JPanel();
		pnlDraw = new drawingSpace();
		txtVar = new JTextField(10);
		lblFunc = new JLabel("y = cx + 1/c");
		lblPar = new JLabel("c = ");
		btnAdd = new JButton("Ekle");
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnlDraw.c.add(Double.parseDouble(txtVar.getText()));
				pnlDraw.c.add((-1)*Double.parseDouble(txtVar.getText()));
				pnlDraw.repaint();
				
			}
		});
		
		pnlControl.setLayout(lytFlow);
		lytFlow.setAlignment(FlowLayout.CENTER);
		
		pnlLabel.add(lblFunc);
		pnlComp.add(pnlLabel, BorderLayout.NORTH);
		pnlControl.add(lblPar);
		pnlControl.add(txtVar);
		pnlControl.add(btnAdd);
		pnlComp.add(pnlControl, BorderLayout.CENTER);
		
		Border brBlue = BorderFactory.createLineBorder(Color.BLUE, 3);
		Border brYellow = BorderFactory.createLineBorder(Color.yellow, 3);
		Border brGreen = BorderFactory.createLineBorder(Color.GREEN, 5);
		
		pnlLabel.setBorder(brYellow);
		pnlControl.setBorder(brBlue);
		pnlComp.setBorder(brGreen);
		
		

		
		

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		//this.setLocation(x, y);
		
		
		this.setSize(screenSize.width, screenSize.height);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.add(pnlDraw, BorderLayout.CENTER);
		this.add(pnlComp, BorderLayout.PAGE_END);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) 
	{
		mainFrame mf = new mainFrame();
		mf.pnlDraw.x1 = mf.pnlDraw.getWidth();
		mf.pnlDraw.y1 = mf.pnlDraw.getHeight();
	}

}
