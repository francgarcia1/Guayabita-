/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guayabita;

public class Guayabita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      new logica.Logica().jugar(new logica.Logica().dadoNuevo(), 1000, 1000, 100, 200, 1, new logica.Logica().dadoNuevo(), new logica.Logica().apostarDinero(1000, 100, 200));
      
    }
    
}
