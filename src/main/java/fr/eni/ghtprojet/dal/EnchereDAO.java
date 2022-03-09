package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Encheres;

public interface EnchereDAO {
	
	 
		public void insert(Encheres enchere) throws DALException; 
		public Encheres selectById(int no_article) throws Exception; 
		public List<Encheres> SelectAll(); 
		public void update(Encheres enchere) throws DALException; 
		public void delete(int no_article); 

	}

