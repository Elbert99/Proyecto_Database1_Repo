/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Tools;
import utils.GestorInterface;
import utils.ModelBuild;
import utils.Tools;
import utils.ViewInterface;

/**
 *
 * @author Victor Lerlin Cedron Ayala
 */
//GESTOR(Insertar Modificar Eliminar) GENERICO(para todos los objetos del sistema)

public class GestorArchivoGenerico extends javax.swing.JDialog implements GestorInterface,MouseListener{
    private static GestorArchivoGenerico gestor; //Estatico
    public  JFrame back;
    private ModelBuild modelos; //Todos los modelos de los diferentes objetos hijos
    private boolean estado; //Conocer si se ha accedido en la BD para poder actualizar los datos en memoria RAM
    private int tipo; //Conocer el boton presionado desde el exterior(Insertar Modificar)
    private DefaultTableModel modelo;//Modelo principal que referencia el tipo de modelo a trabajar
    private LinkedList<Object> lista;//Lista de Objetos en RAM
    private JDialog especializado;//Ventana para Insertar Modificar el objeto hijo a Trabajar
    private Object objetoactual;//Objeto seleccionado en la Tabla para modificar o eliminar
    private LinkedList<String> eliminados;
    private LinkedList<Component> c = new LinkedList<Component>();
    private String filter="";
    private LinkedList<Object> listafilter = new LinkedList<Object>();
    
    public GestorArchivoGenerico(JFrame parent, boolean modal,JDialog mostrar,LinkedList<Object> objects,boolean []arrvis,String archivo) {
        super(parent, modal);
        initComponents();
        setBounds(Tools.center(this.getWidth(),this.getHeight()));
        //setResizable(false);
        c.add(todos); c.add(panel); c.add(jPanel1); c.add(jPanel2);
        
        refrescarvisual();
        modelos = new ModelBuild();
        eliminados = new LinkedList<String>();
        
        modelo = new DefaultTableModel(new Object[]{"-------------- Registro Vacío --------------"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        referenciar();
        
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent arg0) {
                objetoactual = lista.get(tabla.getSelectedRow());
            }
        });
        
        jPanel1.addMouseListener(this);
        jPanel2.addMouseListener(this);
        panel.addMouseListener(this);
        insertar.addMouseListener(this);
        modificar.addMouseListener(this);
        eliminar.addMouseListener(this);
        scroll.addMouseListener(this);
        tabla.addMouseListener(this);
        buscar.addMouseListener(this);
        
        refresh(parent,mostrar, objects, arrvis, archivo);
    }
    
    //Patron Singelton
    public static GestorArchivoGenerico getGestor(JFrame parent, boolean modal,JDialog mostrar,LinkedList<Object> objects,boolean []arrvis,String archivo){
        if(gestor==null){
            gestor = new GestorArchivoGenerico(parent,modal,mostrar,objects,arrvis,archivo);
        }
        else
            gestor.refresh(parent,mostrar, objects, arrvis, archivo);
        
        return gestor;
    }
    
    public static GestorArchivoGenerico getInstance(){
        return gestor;
    }
    //Modelo y Tabla
    public void crearmodelohijo(LinkedList<Object> lista){
        limpiarmodelo();
        if(!lista.isEmpty()){
            modelo = modelos.actualizarmodelo(lista, tabla);
            referenciar();
        }
    }
    public void limpiarmodelo(){
        modelo = modelos.clear();
        referenciar();
    }
    public void referenciar(){
        tabla.setModel(modelo); 
    }
    
//    ******METODOS PUBLICOS*********
    //Get
    public boolean isEstado() {
        return estado;
    }
    
    public Object getObjetoactual() {
        return objetoactual;
    }
    
    public boolean isInsert(){
        return getTipo()==2;
    }
    public boolean isModificar(){
        return getTipo()==3;
    }
    public boolean isVer(){
        return getTipo()==1;
    }
    public int getTipo() {
        return tipo;
    }
    public LinkedList<String> getEliminados(){
        return eliminados;
    }
    //Set
    public void setEstado(boolean estado) {    
        this.estado = estado;
    }
    
    public void refresh(JFrame parent,JDialog mostrar,LinkedList<Object> objects,boolean []arrvis,String archivo){
        setEstado(false);
        setBack(parent);
        setFilter("");
        setTitulo(archivo);
        setLista(objects);
        setArreglodehabilitado(arrvis);
        setEspecializado(mostrar);
        ajustartamanno();
        desmarcartodos();
        refrescarvisual();
        addtxtbuscar();
        eliminados.clear();
    }
    
//     ************METODOS PRIVADOS*****************
    //Get
    private String getFilter() {
        return filter;
    }
    
    //Set
    public void setFilter(String filter) {    
        this.filter = filter;
    }
    private void setArreglodehabilitado(boolean[] arreglodehabilitado) {
        enableds(arreglodehabilitado);
    }
    private void setLista(LinkedList<Object> lista) {
        this.lista = lista;
        crearmodelohijo(lista);
    }
    private void setEspecializado(JDialog especializado) {
        this.especializado = especializado;
    }
    private void setTitulo(String titulo) {
        this.setTitle("Gestor Archivo "+titulo);
    }
    private void setTipo(int tipo) {
        this.tipo = tipo;
    }
    private void setBack(JFrame back) {
        this.back = back;
    }
    
//    habilitar botones
    private void enableds(boolean[] arrvis) {
        if(arrvis!=null){
            insertar.setEnabled(arrvis[0]);
            modificar.setEnabled(arrvis[1]);
            eliminar.setEnabled(arrvis[2]);
        }
    }
    //tyDesmarcar Todos
    private void desmarcartodos() {
        todos.setSelected(false);
    }
    
    //Mostrar Epecializado
    private void mostrar(){
        ViewInterface.visualizar(especializado,this);
    }
    //Metodo para decidir si se retrocede al back y obtener los nuevos objetos de la BD
     private void desicionactualizar() {
        if(isEstado())
            dispose();
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ver = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        todos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel1.add(buscar, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        jPanel2.add(ver);

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        jPanel2.add(insertar);

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel2.add(modificar);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(eliminar);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        scroll.setBackground(new java.awt.Color(204, 204, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla);

        todos.setBackground(new java.awt.Color(204, 255, 204));
        todos.setText("Todos");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(todos)
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(todos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Coger todos los tostring de los objetos seleccionados de la tabla para eliminarlos posteriormente
    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(Tools.iselementos(this,lista,"Eliminar")&&!Tools.errorselection(tabla,'2',this)){
            if(Tools.confirmar(this)){
                int arrpos[] = obtenerposiciones();
                for(int i=0; i<arrpos.length ; i++){
                    eliminados.add(lista.get(arrpos[i]).toString());//ERROR
                }
                setEstado(true);
                desicionactualizar();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed
    //Obtener Posiciones Reales de la tabla Seleccionado
    private int [] obtenerposiciones(){
         int [] result = null;   //lista de posiciones reales seleccionadas
         if(listafilter.isEmpty() || listafilter.size()==lista.size()){
             result = tabla.getSelectedRows();
         }else{
             result = new int[tabla.getSelectedRowCount()];
             int [] auxfilter = tabla.getSelectedRows();
             for(int i=0; i<auxfilter.length; i++){
                 Object obj = listafilter.get(auxfilter[i]);
                 int posreal = lista.indexOf(obj);
                 result[i]=posreal; 
             }
         } 
         return result;
    }
    
    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        if(tabla.getRowCount()!=0){
            if(todos.isSelected())
                tabla.selectAll();
            else
                tabla.clearSelection();
        }else
            todos.setSelected(false);
    }//GEN-LAST:event_todosActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if(Tools.iselementos(this,lista,"Modificar")&&!Tools.errorselection(tabla,'1',this)){
            setTipo(3);
            mostrar();
            desicionactualizar();
        }else
            todos.setSelected(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        setTipo(2);
        mostrar();
        desicionactualizar();    
    }//GEN-LAST:event_insertarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
//        if(evt.getClickCount()==2){        
//           mostrar(1);
//        }
    }//GEN-LAST:event_tablaMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        accesoevent();
    }//GEN-LAST:event_buscarKeyReleased

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        if(Tools.iselementos(this,lista,"Ver")&&!Tools.errorselection(tabla,'1',this)){
            setTipo(1);
            mostrar();
            desicionactualizar();
        }else
            todos.setSelected(false);
    }//GEN-LAST:event_verActionPerformed
    //***Funcionalidades de Filtrado de Objetos por Id*****
    //Evento de obtener la nueva cadena entrado por el teclado
    //Filtrar en una lista las coincidencias y mostrarlas en la tabla
    private void accesoevent(){
        setFilter(buscar.getText());
        filtrar(getFilter());
        crearmodelohijo(listafilter);
    }
    //Add a la listafilter los objetos que coinciden con la cadena
    private void filtrar(String aux){
        listafilter.clear();
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            Object obj = iter.next();
            if(obj.toString().startsWith(aux))
                listafilter.add(obj);
        }
    }
    
    private void addtxtbuscar(){
        if(getFilter().length()==0)
            buscar.setText("Buscar por Id");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton insertar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabla;
    private javax.swing.JCheckBox todos;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
//**********************************************************************************
    private void refrescarvisual() {
      actualizarfondocomponentes();
      this.repaint();
    }
   private void actualizarfondocomponentes(){
      Tools.actualizarcomponentes(c,PrincipalVisual.getInstance().getUsuario().getTema());
   }
// (Relacion de Pixeles por Caracter de la Tabla ademas de espacios)Ajustar Tamaño De Ventana por titulo del Modelo 
    private void ajustartamanno() {
        String titulomodelo = obtenertitulo();
        float tamannoventana = 11.5f * titulomodelo.length();
        this.setBounds(Tools.center((int)tamannoventana,this.getHeight()));
    }
    private String obtenertitulo() {
        String result=""; 
        for(int i=0;i<modelo.getColumnCount();i++){
             result+=modelo.getColumnName(i);
        }
        return result;
    }

    
    public void mouseClicked(MouseEvent e) {}
    //Si se da click en un lugar distinto a buscar comprueba que
    //exista texto en filter, si no escribe el texto por defecto
    //si da click en buscar y el filter esta vacio borrar buscar
    public void mousePressed(MouseEvent e) {
        if(e.getSource()!=buscar){
            addtxtbuscar();
            insertar.grabFocus();
        }else if(filter.length()==0){
            if(Tools.iselementos(this,lista,"Buscar")){
                buscar.setText("");
            }else{
                buscar.setText("Buscar por Id");
                insertar.grabFocus();
            }
        }       
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
