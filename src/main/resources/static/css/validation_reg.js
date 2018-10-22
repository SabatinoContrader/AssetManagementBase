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
        'telefono':{  
            required: true,
            phoneNumber: true
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
        'telefono':{  
            phoneNumber: "inserire numero di telefono valido" 
            }  
        }  
    });   
});  
$.validator.addMethod("phoneNumber", function(value, element) {   
    return this.optional(element) || /^([\+?][0-9]{2}[\s]?)?[0-9]{10}$/.test(value);   
    }, "Please choise a username with only a-z 0-9.");   
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