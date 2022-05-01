var AudioPuzzle = document.createElement("audio")
var AudioButton = document.createElement("audio")
function seleccionar(casilla){
    //contabilizo el click sobre una casilla:
    num_click+=1;
    if(num_click==1){
        num_casilla_click1=casilla;//Memorizar la casilla donde se ha hecho el primer click
        desmarcarTodas();
        document.getElementById("img_"+casilla).style.border="solid 2px red";
        
        
    }
    if(num_click==2){
    var num_casilla_click2=casilla;//capturando la casilla del segundo click
    variar_array(num_casilla_click1,num_casilla_click2);
    refresacarPuzzle();//Refrescamos el panel al segundo click
    desmarcarTodas();
    if(ordenOk()){
	
			
			
			
			AudioPuzzle.setAttribute("src", "sonido.mp3")
			AudioPuzzle.volume = 1;
			AudioPuzzle.loop = true
			
				AudioPuzzle.play()
				
			
			
}else{
	AudioPuzzle.pause()
}
}
    
   /* console.log("numero de clicks= "+num_click);
    console.log(piezas);*/
    
    
    
}

function variar_array(casilla1,casilla2){
    var cas1=piezas[casilla1-1]
    var cas2=piezas[casilla2-1]
    piezas[casilla1-1]=cas2
    piezas[casilla2-1]=cas1;

}

function desmarcarTodas(){//elimina el borde de todas las casillas
    for(var j=1;j<=9;j++){
        document.getElementById("img_"+j).style.border=null;
    }
}

function desordenar(){
    piezas.sort(function() {return Math.random()-0.5})
    console.log(piezas);
    
}


function refresacarPuzzle(){
    for(var casilla=1;casilla<=9;casilla++){
        //obtengo el numero de la imagen que hay en el array en la casilla j
        var imagen=piezas[casilla-1];
        //pinto en la casilla j, la imagen imagen
            document.getElementById("img_"+casilla).src="imgs/"+imagen+".jpg";
            num_click=0;
            
        }
}
function ordenOk(){//funcion que verifica que el orden de las piezas es el correcto
	var ordenado=[1,2,3,4,5,6,7,8,9];
	var TotalCorrectos=0;
	for(d=0;d<9;d++){
		if(ordenado[d]==piezas[d]){
		TotalCorrectos+=1;
		}
	}
	if(TotalCorrectos==9){
		return true;
	}else{
		return false;
	}
}
//funcion para iniciar y detener audio
function Audio_P_S(){
    if(i==0){
        AudioButton.pause()	
		i=1;	
        document.getElementById("btnAudio").textContent="Play"
    }else{
        AudioButton.setAttribute("src", "sonido.mp3")
			AudioButton.volume = 1;
			AudioButton.loop = true
			
				AudioButton.play()
                i=0;
                document.getElementById("btnAudio").textContent="Pause"
    }
}

//Comienzo el programa:
var piezas= [1,2,3,4,5,6,7,8,9];
//variable para reconocer si es pel primer o segundo click:
var num_click=0;
//defino variable para saber en que casilla se hizo click en primer lugar
var num_casilla_click1;
//lamo a la funcion desordenar:
desordenar();
//llamo a la funcion que refresca el panel con el puzzle:
refresacarPuzzle();
//variable global para el boton audio
var i=1;


