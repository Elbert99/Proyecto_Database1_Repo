/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import services.ServicesLocator;
import visual.PrincipalVisual;
import visual.Usuario_IM;
//import static com.sun.javafx.tk.Toolkit.getToolkit;

/**
 *
 * @author Victor
 */
public class Tools {
    //Cargar Imagen

    public static BufferedImage loadImage(String name) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(PrincipalVisual.class.getClassLoader().getResource(name));
        } catch (Exception ex) {

        }
        return image;
    }
    //Centrar Ventana

    public static Rectangle center(int width, int height) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle((d.width - width) / 2, (d.height - height) / 2, width, height);
    }
    //Establecer Titulo con Insertar Modificar

    public static void setTitulo(JDialog dialog, int tipo, String idtitle) {
        //String ult = (insert ? "Insertar " : "Modificar ") + idtitle;
        String aux = "";
        switch (tipo) {
            case 1:
                aux = "Ver ";
                break;
            case 2:
                aux = "Insertar ";
                break;
            case 3:
                aux = "Modificar ";
                break;
        }
        dialog.setTitle(aux + idtitle);
    }
    //Eliminar Lista Generica

    public static <T> void eliminar(int[] selectedRows, LinkedList<T> listarecestab) {
        LinkedList<T> aux = new LinkedList<T>();
        ListIterator<T> iter = listarecestab.listIterator();
        while (iter.hasNext()) {
            if (!tiene(selectedRows, iter.nextIndex())) {
                aux.add(iter.next());
            } else {
                iter.next();
            }
        }
        listarecestab.clear();
        listarecestab.addAll(aux);
    }

    private static boolean tiene(int[] list, int nextIndex) {
        boolean result = false;
        for (int i = 0; i < list.length && !result; i++) {
            if (list[i] == nextIndex) {
                result = true;
            }
        }
        return result;
    }

    //Error en Seleccion en una tabla
    public static boolean errorselection(JTable table, char tipo, JDialog vent) {
        boolean result = false;
        if (tipo == '1') {
            if (table.getSelectedRowCount() != 1) {
                result = true;
                JOptionPane.showMessageDialog(vent, "Seleccione una casilla", "Error en seleción", JOptionPane.ERROR_MESSAGE);
                table.clearSelection();
            }
        } else if (table.getSelectedRowCount() == 0) {
            result = true;
            JOptionPane.showMessageDialog(vent, "Seleccione una o varias casillas", "Error en seleción", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    //Confirmar Eliminar
    public static boolean confirmar(JDialog vent) {
        return JOptionPane.showConfirmDialog(vent, "Está seguro/a de eliminar", "Informacion", JOptionPane.YES_NO_OPTION) == 0;
    }

    //Borrar tabla con modelo
    public static void borrartabla(JTable tabla, DefaultTableModel modelo) {
        tabla.clearSelection();
        modelo.setRowCount(0);
    }

    //Verificar si una cadena es numero entero positivo
    //t=true -> si la cadena completa es numero
    //          (a partir del 2do)si boolean es true verifica ademas mayor(2do)< numero, menor(3ro)>numero 
    //t=false  -> que exista al menos un caracter numerico    
    public static boolean isNumeric(String numero, boolean t, boolean bmin, int min, boolean bmax, int max) {
        //boolean result = true;
        int cont = 0;
        for (int i = 0; i < numero.length(); i++) {
            String s = String.valueOf(numero.charAt(i));
            if (!isdigit(s)) {
                cont++;    //Cantidad de caracteres no numericos
            }
        }
//        if(t){
//            if(cont==0){
//               if(bmin)
//                   result = Integer.parseInt(numero)>=min;
//               if(bmax&&result)
//                   result = Integer.parseInt(numero)<=max;
//            }else
//                result=false;
//        }else
//            result = cont<numero.length();

        //return result;
        //^^^^^^^^^^^^^^^^^^Conversion^^^^^^^^^^^^^^^^^^^^^^^^
        return t ? (cont == 0 && !numero.equals("") ? ((bmin ? (Integer.parseInt(numero) >= min) : (true)) && (bmax ? (Integer.parseInt(numero) <= max) : (true))) : (false)) : (cont < numero.length());
    }

    private static boolean isdigit(String digito) {
        int aux = 0;
        boolean result = true;
        try {
            aux = Integer.parseInt(digito);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    //Determinar si una cadena es flotante y los demas argumentos las propiedades del metodo isNumeric
    public static boolean isFlotante(String numero, boolean bmin, float min, boolean bmax, float max) {
        boolean valido = true;
        int cantp = 0;  //Cantidad de puntos
        for (int i = 0; i < numero.length() && valido; i++) {
            String aux = String.valueOf(numero.charAt(i));
            if (!isdigit(aux)) {
                if (aux.equals(".")) {
                    ++cantp;
                } else {
                    valido = false;
                }
            }
        }
        //Valido=true que no tenga mas caracters que no sean digitos y numeros
        //cantp==1 asegurarse de que solo exista un punto
        //el restante que el punto no se encuentra ni al principio ni al final de la cadena 
        return valido && cantp == 1 && (numero.charAt(0) != '.' && numero.charAt(numero.length() - 1) != '.') && !numero.equals("") ? ((bmin ? (Float.parseFloat(numero) >= min) : (true)) && (bmax ? (Float.parseFloat(numero) <= max) : (true))) : false;
    }

    //Determinar si un String tiene algun tamanno o esta en un rango de tamanno
    //interruptor = true -> si el length del numero es igual al 1er entero
    //interruptor = false -> verifica que este en el rango puesto siempre y cuando se activen los booleanos
    public static boolean isLength(String numero, boolean interruptor, int igual, boolean bmin, int menor, boolean bmax, int mayor) {
        int tam = numero.length();
        return interruptor ? tam == igual : (bmin ? (tam >= menor) : true) && (bmax ? (tam <= mayor) : true);
    }

    //t=true -> devuelve true si la cadena es solo alpha y tiene mas(=) caracteres que liminf y si limsup es distinto de -1 verificar si cont en menor que limitsup
    //t=false -> devuelve true si la cadena tiene mas(=) caracteres alpha que el limit   
    public static boolean isAlpha(String cadena, boolean t, int liminf, int limsup) {
        boolean enc = true;
        int cont = 0; //cantidad de caracteres alpha
        char[] abc = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
            'k', 'l', 'ñ', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'á', 'é', 'í', 'ó', 'ú'};
        for (int i = 0; i < cadena.length() && enc; i++) {
            boolean is = false;
            char aux = cadena.charAt(i);
            for (int y = 0; y < 32 && !is; y++) {
                char m = abc[y]; //miniscula
                char ma = Character.toUpperCase(m); //Mayuscula
                if (m == aux || ma == aux) {
                    cont++;
                }
                if (m == aux || ma == aux || aux == ' ') {
                    is = true;
                }
            }
            if (!is && t) {
                enc = false;
            }
        }
        return t ? enc && cont >= liminf && (limsup != -1 ? cont <= limsup : true) && !cadena.equals("") : cont >= liminf && (limsup != -1 ? cont <= limsup : true) && !cadena.equals("");
    }

    //Crear(true) y quitar(false) decoracion de JDialog y jFrame
    //t(todos), d(JDialog), f(JFrame)
    public static void decoracion(boolean estado) {
        JDialog.setDefaultLookAndFeelDecorated(estado);
//        if(tipo=='t'){
//            JDialog.setDefaultLookAndFeelDecorated(estado);
//            JFrame.setDefaultLookAndFeelDecorated(estado);
//        }else if(tipo=='d'){
//            JDialog.setDefaultLookAndFeelDecorated(estado);
//        }else if(tipo=='f'){
//            JFrame.setDefaultLookAndFeelDecorated(estado);
//        }
    }
    //Colores

    private static Color azul() {
        return new Color(204, 255, 255);
    }

    private static Color verde() {
        return new Color(204, 255, 204);
    }

    private static Color xp() {
        return new Color(240, 240, 240);
    }

    //Cambiar Tema
    //0-azul 1-verde 2-windowsxp
    public static void tema(int tipo) {
        String blue = "com.jtattoo.plaf.mint.MintLookAndFeel";
        String green = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
        String xp = "com.jtattoo.plaf.luna.LunaLookAndFeel";
        String ref = "";
        switch (tipo) {
            case 0:
                ref = blue;
                break;
            case 1:
                ref = green;
                break;
            case 2:
                ref = xp;
                break;
        }
        try {
            UIManager.setLookAndFeel(ref);
        } catch (Exception a) {
        }
    }

    //Actulizar el fondo de una lista de componentes dependiendo del tema
    public static void actualizarcomponentes(LinkedList<Component> lista, int tipo) {
        Color ref = null;
        switch (tipo) {
            case 0:
                ref = azul();
                break;
            case 1:
                ref = verde();
                break;
            case 2:
                ref = xp();
                break;
        }
        Iterator<Component> iter = lista.iterator();
        while (iter.hasNext()) {
            Component c = iter.next();
            c.setBackground(ref);
        }
    }

    //Devolver subcadena despues del 1er espacio
    public static String sub(String cadena) {
        return cadena.substring(cadena.indexOf(' ') + 1, cadena.length());
    }

    public static <T> boolean iselementos(JDialog vent, LinkedList<T> lista, String accion) {
        boolean result = true;
        if (lista.isEmpty()) {
            result = false;
            JOptionPane.showMessageDialog(vent, "No Existen Elementos Para " + accion, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    //OBTENER UN OBJETO DE UNA LISTA DADO SU CODIGO
    public static <T> Object obtenerObjeto(LinkedList<T> objetos, String codigo) {
        Object result = null;
        Iterator<T> iter = objetos.iterator();
        while (iter.hasNext() && result == null) {
            Object aux = iter.next();
            if (aux.toString().equals(codigo)) {
                result = aux;
            }
        }
        return result;
    }

    public static <T> LinkedList<Object> GenericConvertObject(LinkedList<T> objetos) {
        LinkedList<Object> result = new LinkedList<Object>();
        Iterator<T> iter = objetos.iterator();
        while (iter.hasNext()) {
            Object elemento = iter.next();
            result.add(elemento);
        }
        return result;
    }

    public static java.sql.Date fecha() {
        java.util.Date f = Calendar.getInstance().getTime();
        java.sql.Date fechaactual = new java.sql.Date(f.getYear(), f.getMonth(), f.getDate());
        return fechaactual;
    }

    public static java.sql.Date ConDateSql(java.util.Date f) {
        java.sql.Date fecha = new java.sql.Date(f.getYear(), f.getMonth(), f.getDate());
        return fecha;
    }

    public static void errordate(JDialog vent) {
        JOptionPane.showMessageDialog(vent, "Error en Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void exito(JDialog vent, String elemento, String accion) {
        JOptionPane.showMessageDialog(vent, elemento + " " + accion + " " + "con Éxito");
    }

    public static void existe(JDialog vent, String contenido) {
        JOptionPane.showMessageDialog(vent, contenido, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void chsosser(JDateChooser chosser) {
        chosser.setDate(fecha());
    }

    public static boolean existecodigo(String codigo, JDialog control) {
        boolean retorno = false;
        try {
            retorno = ServicesLocator.getAgenciaServices().existeContrato(codigo);
            if (retorno) {
                Tools.existe(control, "Existe esta Ocurrencia de Codigo de Contrato en el Sistema");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //Marcar la fila de la tabla del objeto y el panel si es necesario con Titulo -> elemento
    public static <T> void pintartablapanel(boolean btabla, JTable tabla, LinkedList<T> lista, T elemento, boolean btitle, JPanel panel, String title, String contenido) {
        if (btabla) {
            int pos = -1;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).toString().equals(elemento.toString())) {
                    pos = i;
                    break; //romper la busqueda
                }
            }
            tabla.setRowSelectionInterval(pos, pos);
        }
        if (btitle) {
            Object objeto = elemento;
            if (objeto == null) {
                ((TitledBorder) panel.getBorder()).setTitle(title + " -> " + contenido);
            } else {
                ((TitledBorder) panel.getBorder()).setTitle(title + " -> " + objeto.toString());
            }
            panel.repaint();
        }
    }

    //Desactivar componentes para visualizar
    public static void desactivar(LinkedList<JComponent> listacomponentes) {
        Iterator<JComponent> iter = listacomponentes.iterator();
        while (iter.hasNext()) {
            JComponent objeto = iter.next();
            if (objeto instanceof JTextComponent) {
                ((JTextComponent) objeto).setEditable(false);
            } else {
                objeto.setEnabled(false);
            }
        }
    }

    public static void filtrarspinner(KeyEvent e, JComponent componente, JTextField textospinner) {
        if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_LEFT) {
            componente.grabFocus();
            textospinner.grabFocus();
            textospinner.setCaretPosition(textospinner.getText().length());
        }
    }

    public static boolean punto(String texto) {
        return texto.indexOf('.') > -1;
    }

    public static void alpha(KeyEvent e, JTextField texto, int len) {
        char caracter = e.getKeyChar();
        if ((len == -1 ? false : texto.getText().length() == len) || (!Character.isAlphabetic(caracter) && !Character.isSpaceChar(caracter))) {
            e.consume();
        }
    }

    public static void digit(KeyEvent e, JTextField texto, int len) {
        char caracter = e.getKeyChar();
        if ((len == -1 ? false : texto.getText().length() == len) || !Character.isDigit(caracter)) {
            e.consume();
        }
    }

    public static void alphadigit(KeyEvent e, JTextField texto, int len) {
        char caracter = e.getKeyChar();
        if (texto.getText().length() == len || (!Character.isDigit(caracter) && !Character.isAlphabetic(caracter))) {
            e.consume();
        }
    }

    public static void flotante(KeyEvent e, JTextField texto, int len) {
        char caracter = e.getKeyChar();
        if ((len == -1 ? false : texto.getText().length() == len) || (!Character.isDigit(caracter) && (caracter == '.' ? punto(texto.getText()) : true))) {
            e.consume();
        }
    }

    public static boolean iscarnet(String id) {
        boolean result = true;
        if (id.length() == 11) {
            int[] meses = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int mes = Integer.parseInt(id.substring(2, 4));
            if (mes <= 12 && mes >= 1) {
                int posmes = mes - 1;
                int dia = Integer.parseInt(id.substring(4, 6));
                if (dia < 1 || dia > meses[posmes]) {
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }

    //true primero alpha, false primero digit
    public static boolean mezclaalphadigit(boolean orden, String codigo, int calpha, int cdigit) {
        boolean result = false, isalpha, isdigit;
        String cadalpha = null, caddigit = null;
        if (orden) {
            cadalpha = codigo.substring(0, calpha);
            isalpha = isAlpha(cadalpha, true, calpha, -1);
            caddigit = codigo.substring(codigo.length() - cdigit, codigo.length());
            isdigit = isNumeric(caddigit, true, false, 0, false, 0);
            result = isalpha && isdigit;
        } else {
            caddigit = codigo.substring(0, cdigit);
            isdigit = isNumeric(caddigit, true, false, 0, false, 0);
            cadalpha = codigo.substring(codigo.length() - calpha, codigo.length());
            isalpha = isAlpha(cadalpha, true, calpha, -1);
            result = isalpha && isdigit;
        }
        return result;
    }

    public static boolean correo(String codigo) {
        boolean result = true;
        if (unsolo('@', codigo)) {//Validar los caracteres antes de @
            int posarroba = codigo.indexOf('@');
            String primer = codigo.substring(0, posarroba);
            boolean bprimer = isAlpha(primer, false, 3, -1);
            if (bprimer && unsolo('.', codigo.substring(posarroba, codigo.length()))) {//verificar que exista un solo punto despues de @ y mas de tres alphabeticos 
                int pospunto = codigo.indexOf('.', posarroba);
                String segundo = codigo.substring(posarroba + 1, pospunto);
                boolean bsegundo = isAlpha(segundo, true, 3, -1);
                if (bsegundo) {//verificar que existan mas de tres alphabeticos entre @ y .
                    String tercero = codigo.substring(pospunto + 1, codigo.length());
                    boolean btercero = isAlpha(tercero, true, 2, -1);
                    result = btercero; //verificar que exista al final mas de dos alphabeticos
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }

    private static boolean unsolo(char a, String codigo) {
        int cont = 0;
        for (int i = 0; i < codigo.length() && cont <= 1; i++) {
            if (codigo.charAt(i) == a) {
                ++cont;
            }
        }
        return cont == 1;
    }

}
