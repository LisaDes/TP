package fr.unice.l3.formes;

import java.awt.*;
import javax.swing.*;

abstract class AFormeGeometrique extends JComponent{
	protected Point ancrage;
	protected Color couleurTrait = Color.black;
	protected AlignementHorizontal horizontal = AlignementHorizontal.GAUCHE;
	protected AlignementVertical vertical = AlignementVertical.HAUT;
	protected int largeur, hauteur;
	protected int demiEpaisseur;
	
	protected AFormeGeometrique(Point ancrage, int largeur, int hauteur, int demiEpaisseur) {
		this.ancrage = new Point(ancrage);
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.demiEpaisseur = demiEpaisseur;
	}
	
	abstract double surface();
	
	abstract double perimetre();
	
	final int getLargeur() { 
		return this.largeur; 
		}
	
	final int getHauteur() { 
		return this.hauteur; 
		}
	
	final Point getCoinSuperieurGauche() {
		int x = horizontal.adapt(ancrage.getX(), getLargeur());
		int y = vertical.adapt(ancrage.getY(), getHauteur());
		
		return new Point(x, y);
	}
	
	final public void setHorizontal(AlignementHorizontal horizontal) {
		this.horizontal = horizontal;
	}
	final public AlignementHorizontal getHorizontal() {
		return horizontal;
	}
	final public void setVertical(AlignementVertical vertical) {
		this.vertical = vertical;
	}
	final public AlignementVertical getVertical() {
		return vertical;
	}
	
	public void paintComponent(Graphics2D gr) {
		gr.setColor(couleurTrait);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(demiEpaisseur*2+1));
	}
	
	final public Color getCouleurTrait() {
		return couleurTrait;
	}
	final public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
	}
	
	final protected Point getAncrage() {
		return ancrage;
	}
	
	@Override
	public String toString() {
		return "["+getAncrage()+"; "+getLargeur()+"x"+getHauteur()+"]";
	}
}
