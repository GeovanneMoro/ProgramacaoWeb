/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global mensagens */

var inputs = document.querySelectorAll("input").addEventListener("keyup", function (ev) {
    if (ev.keyCode == 13)
        formSubmit();
    });
function formSubmit(){   
    //var inputs = document.body.querySelectorAll("input");
    var xhr = new XMLHttpRequest(),
        self = this;
    xhr.open("POST", "Cadastro", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState < 4) {
            mensagens.innerHTML = "carregando...";
            mensagens.className = "aviso";
        }
        if (xhr.readyState === 4 && xhr.status === 200) {
            mensagens.innerHTML = "sucesso.";
            mensagens.className = "sucesso";
            self.value = "";

        }
        if (xhr.readyState === 4 && xhr.status !== 200) {
            mensagens.innerHTML = "erro.";
            mensagens.className = "erro";
        }
    };
    var body = {
        email: inputs[0],
         login: inputs[1],
         address: inputs[2],
        password: inputs[3]
    };
    xhr.send(body);
}

