
package test;

import beans.EmpleadoEjbRemote;
import javax.naming.*;


public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            EmpleadoEjbRemote empleadoEJB = (EmpleadoEjbRemote) jndi.lookup("java:global/HolaMundoEJBV2/EmpleadoEjbImpl");
            double weeklySalary = empleadoEJB.weeklySalary();
            System.out.println("El sueldo por semana: " + weeklySalary);
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

/*
java:global/HolaMundoEJBV2/EmpleadoEjbImpl 
java:global/HolaMundoEJBV2/EmpleadoEjbImpl!beans.EmpleadoEjbRemot

beans.EmpleadoEjbRemote#beans.EmpleadoEjbRemote 
beans.EmpleadoEjbRemote
*/