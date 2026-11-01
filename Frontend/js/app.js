//const API_URL = 'http://localhost:8080/usuarios';

// API_URL - WEB
const API_URL = 'https://backend-java-online.onrender.com/usuarios';

const formulario = document.getElementById('formUsuario');
const tabela = document.getElementById('tabelaUsuarios');

//console.log("API:", API_URL);
//console.log("Formulário:", formulario);
//console.log("Tabela:", tabela);

// ===== // LISTAR USUÁRIOS // =====

async function listarUsuarios() {

    try {

        const resposta = await fetch(API_URL);

        const usuarios = await resposta.json();

        //console.log("Dados recebidos:", usuarios);

        tabela.innerHTML = '';

        usuarios.forEach(usuario => {

            const linha = document.createElement('tr');

            const colunaNome = document.createElement('td');
            colunaNome.textContent = usuario.nome;

            const colunaEmail = document.createElement('td');
            colunaEmail.textContent = usuario.email;

            linha.appendChild(colunaNome);
            linha.appendChild(colunaEmail);

            tabela.appendChild(linha);

        });

    } catch (erro) {

        console.error("Erro ao listar usuários:", erro);

    }

}

// ===== // CADASTRAR USUÁRIO // =====

formulario.addEventListener('submit', async (event) => {

    event.preventDefault();

    const usuario = {

        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value

    };

    try {

        const resposta = await fetch(API_URL, {

            method: 'POST',

            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(usuario)

        });

        if (!resposta.ok) {
            throw new Error('Erro ao cadastrar usuário');
        }

        alert('Usuário cadastrado com sucesso!');

        formulario.reset();

        // Atualiza a lista após cadastrar
        listarUsuarios();

    } catch (erro) {

        console.error('Erro ao cadastrar usuário:', erro);

        alert('Não foi possível cadastrar o usuário.');

    }

});

// ===== // CARREGAR USUÁRIOS // =====

listarUsuarios();
