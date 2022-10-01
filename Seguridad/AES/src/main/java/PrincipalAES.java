/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class PrincipalAES {
    public static void main(String[] args) throws Exception{
        
        String mensaje= "Cada día mas triste, fue una semana fea, la verdad tengo sueño y Alan esta ahi solo viendo, aparte tenemos muchas cosas que hacer";
        
        String mensajecifrado= AES.cifrar(mensaje);
        String mensajedescifrado= AES.descifrar(mensajecifrado);
        
        System.out.println("El mensaje original: "+ mensaje);
        System.out.println("El mensaje cifrado es: "+ mensajecifrado);
        System.out.println("El mensaje descifrado es: "+ mensajedescifrado);
    }
}
