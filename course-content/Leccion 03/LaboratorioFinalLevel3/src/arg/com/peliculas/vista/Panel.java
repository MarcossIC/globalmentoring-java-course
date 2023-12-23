package arg.com.peliculas.vista;

import arg.com.peliculas.negocio.CatalogoPeliculasImpl;
import arg.com.peliculas.negocio.ICatalogoPeliculas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel {

    private JLabel agregarP, buscarP;
    private JTextField nombrePelicula, buscarPelicula;
    private JButton botonIniciar, botonAgregar, botonAgregarP, botonListar, botonBuscar, botonBuscarP, botonSalir;
    private JTextArea pantallaDatos;
    private JScrollPane scrol;

    public Panel() {
        run();
    }

    public void run() {
        setLayout(null);
        setBackground(new Color(139, 146, 137));
        iniComponents();
    }

    private void iniComponents() {
        iniLabel("Bienvenido al Menu del catalogo", "titulo").setBounds(120, 10, 315, 21);
        iniLabel("Iniciar Catalogo", "normal").setBounds(25, 70, 100, 15);
        iniLabel("Agregar Pelicula", "normal").setBounds(25, 140, 110, 15);
        iniLabel("Listar Pelicula", "normal").setBounds(25, 240, 110, 15);
        iniLabel("Buscar Pelicula", "normal").setBounds(25, 300, 110, 15);

        this.agregarP = new JLabel("Nombre Pelicula: ");
        this.agregarP.setBounds(45, 178, 125, 12);
        this.agregarP.setFont(new Font("Arial", Font.PLAIN, 13));
        this.agregarP.setForeground(Color.WHITE);
        this.agregarP.setVisible(false);
        add(this.agregarP);

        this.buscarP = new JLabel("Buscar: ");
        this.buscarP.setBounds(45, 330, 80, 12);
        this.buscarP.setFont(new Font("Arial", Font.PLAIN, 13));
        this.buscarP.setForeground(Color.WHITE);
        this.buscarP.setVisible(false);
        add(this.buscarP);
        //-----------------------------------------------------------------------
        iniButton();

        //-------------------------------------------------
        iniTextField();

        //-------------------------------------------------
        this.pantallaDatos = new JTextArea("");
        this.pantallaDatos.setBackground(Color.LIGHT_GRAY);
        this.pantallaDatos.setEditable(false);

        this.scrol = new JScrollPane(pantallaDatos);
        this.scrol.setBounds(300, 200, 255, 165);
        add(this.scrol);

    }

    private JLabel iniLabel(String etiqueta, String fuente) {
        var label = new JLabel(etiqueta);
        label.setForeground(Color.WHITE);
        switch (fuente) {
            case "titulo" ->
                label.setFont(new Font("Arial", Font.BOLD, 19));
            case "normal" ->
                label.setFont(new Font("Arial", Font.PLAIN, 15));
        }

        return (JLabel) add(label);
    }

    private void iniButton() {
        this.botonIniciar = new JButton("Iniciar");
        this.botonIniciar.setBounds(152, 64, 75, 23);
        this.botonIniciar.setForeground(Color.WHITE);
        this.botonIniciar.setBackground(Color.LIGHT_GRAY);
        add(this.botonIniciar);
        this.botonIniciar.addActionListener(new EventoBoton());

        //--------------------------------------------------------
        this.botonAgregar = new JButton("Agregar");
        this.botonAgregar.setBounds(152, 134, 80, 23);
        this.botonAgregar.setForeground(Color.WHITE);
        this.botonAgregar.setBackground(Color.LIGHT_GRAY);
        add(this.botonAgregar);
        this.botonAgregar.addActionListener(new EventoBoton());

        //--------------------------------------------------------
        this.botonAgregarP = new JButton("Agregar Pelicula");
        this.botonAgregarP.setBounds(75, 200, 128, 22);
        this.botonAgregarP.setForeground(Color.WHITE);
        this.botonAgregarP.setBackground(Color.LIGHT_GRAY);
        this.botonAgregarP.setVisible(false);
        add(this.botonAgregarP);
        this.botonAgregarP.addActionListener(new EventoBoton());

        //--------------------------------------------------------
        this.botonListar = new JButton("Listar");
        this.botonListar.setBounds(152, 235, 70, 23);
        this.botonListar.setForeground(Color.WHITE);
        this.botonListar.setBackground(Color.LIGHT_GRAY);
        add(this.botonListar);
        this.botonListar.addActionListener(new EventoBoton());

        //--------------------------------------------------------
        this.botonBuscar = new JButton("Buscar");
        this.botonBuscar.setBounds(152, 295, 80, 23);
        this.botonBuscar.setForeground(Color.WHITE);
        this.botonBuscar.setBackground(Color.LIGHT_GRAY);
        add(this.botonBuscar);
        this.botonBuscar.addActionListener(new EventoBoton());

        //--------------------------------------------------------
        this.botonBuscarP = new JButton("Buscar Pelicula");
        this.botonBuscarP.setBounds(75, 355, 128, 22);
        this.botonBuscarP.setForeground(Color.WHITE);
        this.botonBuscarP.setBackground(Color.LIGHT_GRAY);
        this.botonBuscarP.setVisible(false);
        add(this.botonBuscarP);
        this.botonBuscarP.addActionListener(new EventoBoton());
    }

    private void iniTextField() {
        this.nombrePelicula = new JTextField("");
        nombrePelicula.setBounds(152, 173, 130, 19);
        nombrePelicula.setVisible(false);
        nombrePelicula.setBackground(Color.LIGHT_GRAY);
        add(nombrePelicula);

        this.buscarPelicula = new JTextField("");
        buscarPelicula.setBounds(105, 325, 130, 19);
        buscarPelicula.setVisible(false);
        buscarPelicula.setBackground(Color.LIGHT_GRAY);
        add(buscarPelicula);
    }

    private class EventoBoton implements ActionListener {

        private CatalogoPeliculasImpl datos;

        public EventoBoton() {
            datos = new CatalogoPeliculasImpl();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonIniciar) {
                datos.iniciarCatalogoPeliculas();
                
                pantallaDatos.setText("""
                              **************************************************
                              Su catalogo se ha iniciado correctamente
                              **************************************************""");

            } else if (e.getSource() == botonAgregar) {
                botonIniciar.setEnabled(false);
                botonAgregar.setEnabled(false);
                botonListar.setEnabled(false);
                botonBuscar.setEnabled(false);

                pantallaDatos.setText("");

                botonAgregarP.setVisible(true);
                agregarP.setVisible(true);
                nombrePelicula.setVisible(true);
            } else if (e.getSource() == botonAgregarP) {

                datos.agregarPelicula(nombrePelicula.getText());
                pantallaDatos.setText("""
                              **************************************************
                              Su pelicula se ha agregado correctamente
                              al catalogo
                              **************************************************""");

                nombrePelicula.setText("");
                botonIniciar.setEnabled(true);
                botonAgregar.setEnabled(true);
                botonListar.setEnabled(true);
                botonBuscar.setEnabled(true);

                botonAgregarP.setVisible(false);
                agregarP.setVisible(false);
                nombrePelicula.setVisible(false);
            } else if (e.getSource() == botonListar) {
                pantallaDatos.setText("");

                datos.listarPeliculas();

                pantallaDatos.setText("**************************************************\n"
                        + datos.getMensaje() + datos.getMensaje2() + "\n"
                        + "**************************************************");
            } else if (e.getSource() == botonBuscar) {
                botonIniciar.setEnabled(false);
                botonAgregar.setEnabled(false);
                botonListar.setEnabled(false);
                botonBuscar.setEnabled(false);

                pantallaDatos.setText("");

                botonBuscarP.setVisible(true);
                buscarP.setVisible(true);
                buscarPelicula.setVisible(true);
            } else if (e.getSource() == botonBuscarP) {

                datos.buscarPelicula(buscarPelicula.getText());

                pantallaDatos.setText("**************************************************\n"
                        + "Se encontro:\n" + datos.getMensaje() + "\n"
                        + "**************************************************");

                buscarPelicula.setText("");
                botonIniciar.setEnabled(true);
                botonAgregar.setEnabled(true);
                botonListar.setEnabled(true);
                botonBuscar.setEnabled(true);

                botonBuscarP.setVisible(false);
                buscarP.setVisible(false);
                buscarPelicula.setVisible(false);
            }
        }
    }
}
