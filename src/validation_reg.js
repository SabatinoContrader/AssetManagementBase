$(document).ready(function()  
{  
          
    $("#form_register").validate(  
    {  
        rules:  
        {  
        'username':{  
            required: true,  
            minlength: 3  
            },  
        'mail':{  
            required: true,  
            email: true  
            },  
        'password':{  
            required: true,  
            minlength: 8  
            },  
        'pass2':{  
            equalTo: '#reg_pass1'  
            }  
        },  
        messages:  
        {  
        'username':{  
            required: "Il campo username è obbligatorio!",  
            minlength: "Scegli un username di almeno 3 lettere!"  
            },  
        'mail':{  
            required: "Il campo email è obbligatorio!",  
            email: "Inserisci un valido indirizzo email!"  
            },  
        'password':{  
            required: "Il campo password è obbligatorio!",  
            minlength: "Inserisci una password di almeno 8 caratteri!"  
            },  
        'pass2':{  
            equalTo: "Le due password non coincidono!"  
            }  
        }  
    });   
});  
$(document).ready(function()  
		{  
		$("#form_register").validate({  
		    rules:{  
		        'name_campo1':{  
		            metodoA: parametro,  
		            metodoB: parametro  
		            },  
		        'name_altro_campo':{  
		            metodoC: parametro  
		            }  
		    },  
		          
		    messages:{  
		        'name_campo1':{  
		            metodoA: "messaggio di errore per questo metodo.",  
		            metodoB: "messaggio di errore per questo metodo."  
		            },  
		        'name_altro_campo':{  
		            metodoC: "messaggio di errore per questo metodo."  
		            }  
		          
		    }  
		});  
		}); 