/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.LinkedList;

/**
 *
 * @author Victor
 */
public interface GestorInterface {
    public void setEstado(boolean estado);
    public boolean isInsert();
    public boolean isModificar();
    public boolean isVer();
    public int getTipo();
    public Object getObjetoactual();
}
