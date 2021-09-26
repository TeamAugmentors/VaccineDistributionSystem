/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccine.distribution.system;

import UI.Login;
import UI.SplashScreen;
import dbConnection.DBConnection;

/**
 *
 * @author Lassassin
 */
public class VaccineDistributionSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DBConnection().getConnection();
        
        showSplashScreen();
    }

    private static void showSplashScreen() {
        new SplashScreen().setVisible(true);
//         new Login().setVisible(true);
    }
}
