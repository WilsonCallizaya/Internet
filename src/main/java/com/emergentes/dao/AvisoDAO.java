/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import java.util.List;

public interface AvisoDAO {
    public void insert(Aviso aviso)throws Exception;
    public void update(Aviso aviso)throws Exception;
    public void delete(int id) throws Exception;
    public List<Aviso> getAll() throws Exception;
    public Aviso getById(int id) throws Exception;
}
