/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
import java.security.*;
import java.util.Arrays;
import javax.crypto.Cipher;
import sun.misc.*;
import javafx.scene.chart.PieChart.Data;
import javax.crypto.spec.SecretKeySpec;
        
public class AES {
    //vamos a onbtener la java

    /**
     *
     */
    
    public static final byte[] nuestrallave= new byte[]{
        
        'q', 'w', 'e', 'r', 't', 'y','u','i',
        'q', 'w', 'e', 'r', 't', 'y','u','i'
    };
    private static final String instancia= "AES";   //vamos a crear un metodo para cifrar 
    
    public static String cifrar(String Data)throws Exception{
        
        //para poder cifrar debemos de generar las llaves,pero vamos a crear un metodo para dicha generacion
        //ocupamos key
        
        Key key= generateKey();
        //inicializamos el cifrado
        
        Cipher cifrado= Cipher.getInstance(instancia);
        
        cifrado.init(Cipher.ENCRYPT_MODE, key);
        
        //vamos a obtener el mensaje y transformarlo
        
        byte [] encValores= cifrado.doFinal(Data.getBytes());
        
        //vamos a aplicar un formato para que pueda serleido
        //el mensaje,por ello elomensaje BASE64
        System.out.println("Valores sin formato: "+ Arrays.toString(encValores));
        
        String valoresencriptados= new BASE64Encoder().encode(encValores);
        
        System.out.println("Valores con formato: "+ valoresencriptados);
        
        return valoresencriptados;
    }
     public static String descifrar(String valoresencriptados)throws Exception{
        
        //para poder cifrar debemos de generar las llaves,pero vamos a crear un metodo para dicha generacion
        //ocupamos key
        
        Key key= generateKey();
        //inicializamos el cifrado
        
        Cipher cifrado= Cipher.getInstance(instancia);
        
        cifrado.init(Cipher.DECRYPT_MODE, key);
        
        //vamos a obtener el formato del mensaje
        
        byte[] decodificadorvalores= new BASE64Decoder().decodeBuffer(valoresencriptados);
        
        //vamos a aplicar un formato para que pueda serleido
        //el mensaje,por ello elomensaje BASE64
        System.out.println("Valores sin formato: "+ Arrays.toString(decodificadorvalores));
        //la transformacion del mensaje
        
        byte [] decValores= cifrado.doFinal(decodificadorvalores);
        
        String valoresdescifrados= new String(decValores);
        
        System.out.println("Valores con formato: "+ valoresencriptados);
        
        return valoresdescifrados;
    }
        

    private static Key generateKey() {
        //vamos aq ocupar las llaves de aes de la clase
        
        Key key = new SecretKeySpec(nuestrallave,instancia);
        
        return key;
    }
    
}
