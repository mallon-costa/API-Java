// var xhr = new XMLHttpRequest();


// xhr.onreadystatechange = function (){
//     if(xhr.readyState == 4){
//         console.log(xhr);
//     }
// }

// xhr.open("GET", "http://localhost:8080/passagens/?dataInicio=2020-04-11&dataFim=2020-04-14");
// xhr.send();

// const button = document.querySelector(".button")

// button.addEventListener('submit', function (event){
//     event.preventDefault();//para não atualizar o form

//     xhr.send();
// });


const button = document.querySelector(".button")
/*
const IdataInicio = document.querySelector("#dateIni")
const IdataFim = document.querySelector("#dateFim")

const forma = document.querySelector(".forma")

var texto = IdataInicio.getAttribute;
console.log(texto);
*/
//const IdataInicio = document.querySelector("#dateIni")

var origem1 = document.querySelector("#origem");
var dataAtual = new Date(); // retornar a data atual (Date)
//var dataInput = new Date($("#dateIni").val()); // converte o valor para Date


//var IdataFim = new Date(document.querySelector("#dateFim")).getUTCDate;
//var IdataInicio = new Date(document.querySelector("#dateIni")).getDate;


//document.getElementById("dateIni").valueAsDate = new Date();

const forma = document.querySelector(".forma")

//console.log(IdataFim.value);

const IdataInicio = document.querySelector('#dateIni')
IdataInicio.onchange = (e) => {
    console.log(e.target.value)
}

const IdataFim = document.querySelector('#dateFim')
IdataFim.onchange = (e) => {
    console.log(e.target.value)
}

const showData = (result) => {
    console.log(result);

    for (const campo in result) {
        console.log(campo)
    }
}

function verificarDisponibilidade() {

    forma.addEventListener("submit", function (event) {
        event.preventDefault();

        let dados = {
            IdataInicio,
            IdataFim
        };
        alert(dados);
    })

    fetch("http://localhost:8080/hospedagens/?dataInicio=" + IdataInicio.value + "&dataFim=" + IdataFim.value)
        /*
        .then(function (response) {
            return response.json();
        })
        .then(function(response){
            response.data.forEach(function(origem){
                let item = document.createElement("li");

                item.innerHTML = '<span>'+origem.origem+'</span';
                
            })
        })
        
        .then(function (response) {
            console.log(response);
        })
        */
        /*
          .then(response => response.json())
         .then(data => console.log(data.origem))
         */
        /*
        .then(resposta => resposta.json())
        .then(data => mostrarResposta(data))
        .catch(erro => console.error(erro));
        */

        .then(response => response.json())
        .then(data => {
            data.map((item) => {
                //const li = document.createElement("li");
                //li.setAttribute('id', item.valor_passagem);
                //console.log(item.valor_passagem);
                //origem1.innerHTML = origem1.value = item.origem;

                var cont = 0;
                for (const campo in item) {
                   cont++;
                }

                for (let index = 0; index < 1; index++) {
                    var divEl = document.createElement("option")
                    var textEl = document.createTextNode(item.nome_cidade+" "+
                    item.data_entrada+" "+item.data_saida+" "+item.valor);
                    divEl.appendChild(textEl)

                    document.getElementById("ddlCores").appendChild(divEl)
                }
                /*
                for (const campo in item) {
                    //console.log(item[campo]);
                    //console.log(campo.length);
                    origem1.innerHTML = origem1.value = item[campo];

                    var divEl = document.createElement("option")
                    var textEl = document.createTextNode(item.origem+" "+item.destino);
                    divEl.appendChild(textEl)

                    document.getElementById("ddlCores").appendChild(divEl)
                }
                */
            })
        })

    /*
     .then(response =>{ response.json()
         .then(data => showData(data))
     })
     .catch(erro => console.error(erro))
     */
};

function mostrarResposta(dados) {
    console.log(dados);
    const mensagem = `
        Cidade: ${dados.origem}
    `;
    console.log(Cidade);
    alert(mensagem);
}

/*
$(function () {
    var dynamicDiv = ('#dynamicDiv');
    $('.button').on('click', '.addInput', function () {
         var dynamicId = $(this).attr("id");
         $('<p>'+
           '<input type="text" name"inputteste[]" id="inputeste" size="20" value="" placeholder="" /> '+
           '<a class="btn btn-danger" href="javascript:void(0)" id="remInput">'+
           '<span class="glyphicon glyphicon-minus" aria-hidden="true"></span> '+
           '</a>'+
           '</p>').appendTo(dynamicDiv + dynamicId);
           return false;
      });
      $('.button').on('click', '#remInput', function () {
           $(this).parents('p').remove();
           return false;
      });
});
*/

button.addEventListener("click", function () {
    event.preventDefault();

    verificarDisponibilidade();
});


const Inome = document.querySelector('[name="nome"]');
const Iemail = document.querySelector('[name="email"]');
const Icpf = document.querySelector('[name="cpf"]');
const Iidade = document.querySelector('[name="idade"]');
const Itelefone = document.querySelector('[name="tel"]');

const buttonProsseguir = document.querySelector("#botaoProsseguir");
function cadastrar(){
    fetch("http://localhost:8080/clientes",
        {
            headers: {
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome_completo: Inome.value,
                email: Iemail.value,
                telefone: Itelefone.value,
                cpf: Icpf.value,
                idade: Iidade.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res){console.log(res)})
};

function limpar(){
    Inome.value = "";
    Iemail.value = "";
    Itelefone.value = "";
    Icpf.value = "";
    Iidade.value = "";
}

buttonProsseguir.addEventListener("click", function () {
    event.preventDefault();

    cadastrar();
    limpar();
});
