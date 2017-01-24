package garage;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class PannesCatalogueDBAdapter {
    private Connection connexion ;
    private HashMap<Integer,String> all = new HashMap<Integer, String>();
    String url = "jdbc:mysql://localhost:3306/garage";
    String utilisateur = "root";
    String motDePasse = "root";
    
    public PannesCatalogueDBAdapter() throws Exception{

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

    }
    
    public void insert(String nom) throws SQLException{
        
        Statement statement = connexion.createStatement();
        int ok = statement.executeUpdate( "INSERT INTO pannes values (null, \""+nom+"\") ;" );
    }
    
    public void reload() throws SQLException{
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery( "SELECT id,nom FROM pannes;" );
        all.clear();
        while ( resultat.next() ) {
            all.put(resultat.getInt(1), resultat.getString(2)); 
        }      
    }
    public String get(int i){
        return all.get(i);
    }

    @Override
    public String toString() {
        String str ="";
        for(Map.Entry<Integer, String> entry : all.entrySet()){
            str += entry.getKey()+": "+entry.getValue()+"\n";
        }
        return str ;
    }
    
    
    
    public void fermerConnexion() throws SQLException{
        connexion.close();
    }
}
