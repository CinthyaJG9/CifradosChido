const Cifrar = () => {
    
    var msj = document.getElementById('leeArchivoCifrar').innerHTML;
    var llave = document.getElementById('clave').value;

    console.log(msj)

    if(llave == ''){

        alert('Verifique que haya introducido una clave e intente nuevamente');
        
    }
    else{

        var encriptado = CryptoJS.DES.encrypt(msj, CryptoJS.enc.Utf8.parse (llave) , {
                
            mode : CryptoJS.mode.ECB , padding : CryptoJS.pad.Pkcs7
        
        }).toString();
        
        document.getElementById('leeArchivoCifrar').innerHTML = 
        '<label>Mensaje cifrado:</label>'+
        '<h1 id = "resultado1">' + encriptado + '</h1>';

    }

}

// leer
async function subirArchivoCifrar(file){

    var txt = await file.text();
    document.getElementById("leeArchivoCifrar").textContent = txt;

}

// validams
const Validar = () =>{

    var archivoEscogido = document.getElementById('archivoCifrar');
    var contenidoarchivoEscogido = archivoEscogido.value;
    var ext = /(.txt)$/i; 

    if(!ext.exec(contenidoarchivoEscogido)){

        alert('Solo leemos archivos txt :C');
        archivoEscogido.value = '';
        return false;

    }
    else{

        if(archivoEscogido.files && archivoEscogido.files[0]){

            var lector = new FileReader();
            lector.onload = function(event){

                subirArchivoCifrar(archivoEscogido.files[0]); 

            }
        

            lector.readAsDataURL(archivoEscogido.files[0]);

        }

    }

}


const Descifrar = () => {

    var msjEncriptado = document.getElementById('leeArchivoDescifrar').innerHTML;
    var llave = document.getElementById('clave').value;

    if(llave == ''){

        alert('Verifique que haya introducido una clave e intente nuevamente');

    }
    else{

        var desencriptado = CryptoJS.DES.decrypt(msjEncriptado, CryptoJS.enc.Utf8.parse(llave), {
            
            mode : CryptoJS.mode.ECB , padding: CryptoJS.pad.Pkcs7
        
        }).toString(CryptoJS.enc.Utf8);

        document.getElementById("leeArchivoDescifrar").innerHTML = 
        '<label>Mensaje descifrado: </label>'+
        '<h1 id = "resultado2">' + encriptado + '</h1>';

    }

}

// leer
async function subirArchivoDescifrar(file){

    var txt = await file.text();
    document.getElementById('leeArchivoDescifrar').textContent = txt;

}

// Vvalidamos
const ValidarDes = () =>{

    var archivoEscogido = document.getElementById('archivoDescifrar');
    var contenidoarchivoEscogido = archivoEscogido.value;
    var ext = /(.txt)$/i;

    if(!ext.exec(contenidoarchivoEscogido)){

        alert('Solo leemos archivos txt :C');
        archivoEscogido.value = '';
        return false;

    }
    else{

        if(archivoEscogido.files && archivoEscogido.files[0]){

            var lector = new FileReader();
            lector.onload = function(event){

                subirArchivoDescifrar(archivoEscogido.files[0]); // REALIZAR INSERCCION HTML DECENCRIPTADA

            }
        

            lector.readAsDataURL(archivoEscogido.files[0]);

        }

    }}
