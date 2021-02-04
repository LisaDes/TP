package fr.unice.l3.formes;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends AFormeGeometrique {
	public Ellipse(Point centre, int largeur, int hauteur) {
		super(centre, largeur, hauteur);
	}
	
	@Override
	double surface() {
		return Math.PI*getLargeur()*getHauteur()/4;
	}

	@Override
	double perimetre() {
		return Math.PI*(getLargeur() + getHauteur())/2;
	}

	@Override
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		getCentre().paintComponent(g);
		Point coin = getCoinSuperieurGauche() ;
		g.drawOval(coin.getX(), coin.getY(), getLargeur(), getHauteur());
	}

	Point getCentre() {
		return super.getAncrage();
	}
	
	@Override
	public String toString() {
		return "Ellipse"+super.toString();
	}
}
