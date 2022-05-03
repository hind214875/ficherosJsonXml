/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hinda
 */
public class LeerJson {
    
    public static void main(String[] args) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<MuebleVO> catalogo = mapeador.readValue(new File("catalogoMuebles.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, MuebleVO.class));
        
        for (MuebleVO muebleVO : catalogo) {
            System.out.println(muebleVO);
        }
        
        ArrayList<EnvioMuebles> envios = mapeador.readValue(new File("catalogoEnvios.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, EnvioMuebles.class));
        System.out.println("\n");
        System.out.println("---- Catálogo de Envíos ----");
        for (EnvioMuebles envio : envios) {
            System.out.println(envio);
        }
        System.out.println("---- Catálogo de Envíos ----");
    }
}
