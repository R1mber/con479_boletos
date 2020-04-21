/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.controller;

import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import com.com470.boleto.app.service.BoletoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoletoControllerTest {
    
    @Autowired
    private BoletoService boletoService;
    
    @MockBean
    private BoletoDao boletoDao;
    
    @Test
    public void testCreateBoleto() {
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("jose perez ");
        boleto.setSalida("Sucre");
        boleto.setDestino("Tarija");
        boleto.setFecha(new Date());
        boleto.setEmail("jose.perez@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto); 
        assertThat(boletoDao.save(boleto),Matchers.is(CoreMatchers.equalTo(boleto)));
        
    }

    @Test
    public void testGetBoletoById() {
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("jose perez ");
        boleto.setSalida("Sucre");
        boleto.setDestino("Tarija");
        boleto.setFecha(new Date());
        boleto.setEmail("jose.perez@gmail.com");
        
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto); 
        assertThat(boletoDao.findOne(1),Matchers.is(CoreMatchers.equalTo(boleto)));
    }

    @Test
    public void testGetAllBoletos() {
        
        List<Boleto> boletos = new ArrayList<Boleto>();

        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("jose perez ");
        boleto.setSalida("Sucre");
        boleto.setDestino("Tarija");
        boleto.setFecha(new Date());
        boleto.setEmail("jose.perez@gmail.com");
        
        boletos.add(boleto);
        
        Mockito.when(boletoDao.findAll()).thenReturn(boletos);
        assertThat(boletoDao.findAll(), Matchers.equalTo(boletos));
    }

    @Test
    public void testDeleteBoleto() {
        
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("jose perez ");
        boleto.setSalida("Sucre");
        boleto.setDestino("Tarija");
        boleto.setFecha(new Date());
        boleto.setEmail("jose.perez@gmail.com");
        
        //metodo delete retorna void
        //Mockito.when(boletoDao.delete(1)).thenReturn();
        //
    }

    @Test
    public void testUpdateBoleto() {
         Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("jose perez ");
        boleto.setSalida("Sucre");
        boleto.setDestino("Tarija");
        boleto.setFecha(new Date());
        boleto.setEmail("jose.perez@gmail.com");
        
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        boleto.setEmail("joseP@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoService.updateBoleto(1,"jose.perez@gmail.com"),Matchers.is(CoreMatchers.equalTo(boleto)));

    }
    
}
